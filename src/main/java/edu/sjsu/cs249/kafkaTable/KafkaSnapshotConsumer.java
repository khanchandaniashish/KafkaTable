package edu.sjsu.cs249.kafkaTable;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static edu.sjsu.cs249.kafkaTable.Replica.*;

/**
 * @author ashish
 */
public class KafkaSnapshotConsumer {
    String bootstrapServer;
    ReplicatedTable replicatedTable;
    Long seekTime;
    Producer producer;

    KafkaSnapshotConsumer(String bootstrapServer, ReplicatedTable replicatedTable, Long seekTime, Producer operationsProducer) {
        this.bootstrapServer = bootstrapServer;
        this.replicatedTable = replicatedTable;
        this.seekTime = seekTime;
        this.producer = operationsProducer;
    }

    public void run() {
        var properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "10000");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, name + "ConsumerGroup1");
        Consumer<String, byte[]> consumer = new KafkaConsumer<>(properties, new StringDeserializer(), new ByteArrayDeserializer());
        System.out.println("Snapshot Consumer successfully initialized");

        consumer.subscribe(List.of(SNAPSHOT_TOPIC));

        ConsumerRecords<String, byte[]> consumerRecords = consumer.poll(Duration.ofSeconds(1));

        consumerRecords.forEach(record -> {
            System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), Arrays.toString(record.value()));
            Snapshot message = null;

            try {
                System.out.println("Received snapshot from Replica: ");
                message = Snapshot.parseFrom(record.value());

                System.out.println("Setting OPS lastSeenOffset to : " + message.getOperationsOffset());
                lastSeenOperationsOffset = message.getOperationsOffset();

                System.out.println("Setting lastSeenOrderingOffset to : " + message.getSnapshotOrderingOffset());
                lastSeenOrderingOffset = message.getSnapshotOrderingOffset();

                System.out.println("Syncing map with snapshot map  : " + message.getTableMap());
                replicatedTable.sync(message.getTableMap());

                System.out.println("Syncing Client Txn map with snapshot map  : " + message.getClientCountersMap());
                for (String key : message.getClientCountersMap().keySet()) {
                    ClientTxnLog.put(key, message.getClientCountersMap().get(key));
                }
            } catch (InvalidProtocolBufferException e) {
                System.out.println("INVALID MESSAGE TYPE Received");
                e.printStackTrace();
            }
        });

    }

    public void publishSnapshot() {
        System.out.println("publishSnapshot Triggered");
        Snapshot snapshot = Snapshot.newBuilder()
                .setReplicaId(Replica.name)
                .putAllTable(replicatedTable.hashtable)
                .setOperationsOffset(lastSeenOperationsOffset)
                .putAllClientCounters(Replica.ClientTxnLog)
                .setSnapshotOrderingOffset(lastSeenOrderingOffset)
                .build();
        System.out.println("Publishing : " + snapshot);
        //publish snapshot
        sendMessage(snapshot.toByteArray(), SNAPSHOT_TOPIC);
        //join the Que again
        System.out.println("Publishing done.. joining the ordering Q again");
        sendMessage(SnapshotOrdering.newBuilder().setReplicaId(name).build().toByteArray(), SNAPSHOT_ORDERING_TOPIC);
    }

    void sendMessage(byte[] message, String topic) {
        if (!Objects.isNull(producer)) {
            var record = new ProducerRecord<String, byte[]>(topic, message);
            producer.send(record);
            System.out.println("Publish to Topic: " + topic);
        }
    }

}
