# KafkaTable
 Build a replicated hashtable using kafka as the replication log. That pushes operations encoded as protobuf messages to replicas that execute the operations at each replica.

The service we are providing to clients will be an incrementable hashtable. It is a hashtable whose key is a string and value is an integer. We cannot directly set the integer for a given key, but we can increment it. (We decrement by incrementing with a negative number.) If a key does not exist in the table, we act as if the key has a value of zero. the Two operations we can do on the table are:

get(key) - returns the current integer for the key, or zero if the key does not exist.
increment(key, value) - increments the key by the given value. this operation will fail if the value would take the key below 0. there can be no negative values.
periodically a replica should snapshot the state of the table into the log to enable fast recovery of replicas or new replicas to come up to speed.

you can find starter code at https://github.com/breed/kafkaTableLinks to an external site.

bootstrap server is at cs-reed-07.class.homeofcode.com:9092

<the rest of the protocol was designed in class>

kafka table consists of replicas and clients. each of you will run a replica that will be driven by operations received. replicas will also serve clients via a gRPC service.

client requests
clients will use gRPC to make in and get requests to a replica. they can use any replica. clients will have only one request outstanding. we are giving an exactly once guarantee to clients, so we can only execute operations once. we track the execution of clients using client counter. each client will make a request with a monotonically increasing counter. a client can have only one request outstanding, so if a replica receives a request from a client that has already been executed (either from the client directly or through a published message), it will skip executing the operation and immediately respond to the client.

since clients must remember the last operation executed for each client across restarts, snapshots include a table of these last counters.

replica state machines
there are three relevant topics used by kafka table: operations, snapshot, and snapshotOrdering. NOTE: THESE ARE THE BASE TOPICS NAMES. WE WILL USE A PREFIX FOR THE TOPICS TO ALLOW MULTIPLE GROUPS TO TEST.

operations to be executed will come through the operations topic. they will have the type PublishedItem which will be either an inc or get request. all replicas will execute the inc request on receipt. the inc request will not change the value if the result of the operation is below zero. get requests don't change state, but their execution will return a result to the client who made a request.

snapshots

we will take snapshots periodically so that replicas can recover from a failure. every X (command line parameter) operations, a snapshot will be taken and published to the snapshot topic. when a replica starts it will 1) insert itself into the snapshotOrdering topic if it isn't already there 2) grab the latest snapshot from the snapshot topic and 3) start consuming from the last offset in the snapshot.

when a replica receives a published message whose offset % X == 0, it knows it's time to take a snapshot. it will consume a replica name from snapshotOrdering. if it pulls its own name, it will publish a snapshot and reinsert its name into snapshotOrdering. (hmm, we have a consumer offset synchronization problem that we should discuss in class.)
