// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: messages.proto

package edu.sjsu.cs249.kafkaTable;

public final class Messages {
  private Messages() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_ClientXid_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_ClientXid_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_IncRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_IncRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_IncResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_IncResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_GetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_GetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_GetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_GetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_Snapshot_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_Snapshot_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_Snapshot_TableEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_Snapshot_TableEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_Snapshot_ClientCountersEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_Snapshot_ClientCountersEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_ExitRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_ExitRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_ExitResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_ExitResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_KafkaTableDebugRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_KafkaTableDebugRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_KafkaTableDebugResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_KafkaTableDebugResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_PublishedItem_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_PublishedItem_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_SnapshotOrdering_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_SnapshotOrdering_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kafkaTable_SimpleMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kafkaTable_SimpleMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016messages.proto\022\nkafkaTable\".\n\tClientXi" +
      "d\022\020\n\010clientid\030\001 \001(\t\022\017\n\007counter\030\002 \001(\005\"O\n\n" +
      "IncRequest\022\013\n\003key\030\001 \001(\t\022\020\n\010incValue\030\002 \001(" +
      "\005\022\"\n\003xid\030\003 \001(\0132\025.kafkaTable.ClientXid\"\r\n" +
      "\013IncResponse\"=\n\nGetRequest\022\013\n\003key\030\001 \001(\t\022" +
      "\"\n\003xid\030\002 \001(\0132\025.kafkaTable.ClientXid\"\034\n\013G" +
      "etResponse\022\r\n\005value\030\001 \001(\005\"\256\002\n\010Snapshot\022\021" +
      "\n\treplicaId\030\001 \001(\t\022.\n\005table\030\002 \003(\0132\037.kafka" +
      "Table.Snapshot.TableEntry\022\030\n\020operationsO" +
      "ffset\030\003 \001(\003\022@\n\016clientCounters\030\004 \003(\0132(.ka" +
      "fkaTable.Snapshot.ClientCountersEntry\022\036\n" +
      "\026snapshotOrderingOffset\030\005 \001(\003\032,\n\nTableEn" +
      "try\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\005:\0028\001\0325\n\023C" +
      "lientCountersEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value" +
      "\030\002 \001(\005:\0028\001\"\r\n\013ExitRequest\"\016\n\014ExitRespons" +
      "e\"\030\n\026KafkaTableDebugRequest\"A\n\027KafkaTabl" +
      "eDebugResponse\022&\n\010snapshot\030\001 \001(\0132\024.kafka" +
      "Table.Snapshot\"e\n\rPublishedItem\022%\n\003inc\030\001" +
      " \001(\0132\026.kafkaTable.IncRequestH\000\022%\n\003get\030\002 " +
      "\001(\0132\026.kafkaTable.GetRequestH\000B\006\n\004item\"%\n" +
      "\020SnapshotOrdering\022\021\n\treplicaId\030\001 \001(\t\" \n\r" +
      "SimpleMessage\022\017\n\007message\030\001 \001(\t2|\n\nKafkaT" +
      "able\0226\n\003inc\022\026.kafkaTable.IncRequest\032\027.ka" +
      "fkaTable.IncResponse\0226\n\003get\022\026.kafkaTable" +
      ".GetRequest\032\027.kafkaTable.GetResponse2\236\001\n" +
      "\017KafkaTableDebug\022P\n\005debug\022\".kafkaTable.K" +
      "afkaTableDebugRequest\032#.kafkaTable.Kafka" +
      "TableDebugResponse\0229\n\004exit\022\027.kafkaTable." +
      "ExitRequest\032\030.kafkaTable.ExitResponseB\035\n" +
      "\031edu.sjsu.cs249.kafkaTableP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_kafkaTable_ClientXid_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_kafkaTable_ClientXid_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_ClientXid_descriptor,
        new java.lang.String[] { "Clientid", "Counter", });
    internal_static_kafkaTable_IncRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_kafkaTable_IncRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_IncRequest_descriptor,
        new java.lang.String[] { "Key", "IncValue", "Xid", });
    internal_static_kafkaTable_IncResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_kafkaTable_IncResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_IncResponse_descriptor,
        new java.lang.String[] { });
    internal_static_kafkaTable_GetRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_kafkaTable_GetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_GetRequest_descriptor,
        new java.lang.String[] { "Key", "Xid", });
    internal_static_kafkaTable_GetResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_kafkaTable_GetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_GetResponse_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_kafkaTable_Snapshot_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_kafkaTable_Snapshot_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_Snapshot_descriptor,
        new java.lang.String[] { "ReplicaId", "Table", "OperationsOffset", "ClientCounters", "SnapshotOrderingOffset", });
    internal_static_kafkaTable_Snapshot_TableEntry_descriptor =
      internal_static_kafkaTable_Snapshot_descriptor.getNestedTypes().get(0);
    internal_static_kafkaTable_Snapshot_TableEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_Snapshot_TableEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_kafkaTable_Snapshot_ClientCountersEntry_descriptor =
      internal_static_kafkaTable_Snapshot_descriptor.getNestedTypes().get(1);
    internal_static_kafkaTable_Snapshot_ClientCountersEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_Snapshot_ClientCountersEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_kafkaTable_ExitRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_kafkaTable_ExitRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_ExitRequest_descriptor,
        new java.lang.String[] { });
    internal_static_kafkaTable_ExitResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_kafkaTable_ExitResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_ExitResponse_descriptor,
        new java.lang.String[] { });
    internal_static_kafkaTable_KafkaTableDebugRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_kafkaTable_KafkaTableDebugRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_KafkaTableDebugRequest_descriptor,
        new java.lang.String[] { });
    internal_static_kafkaTable_KafkaTableDebugResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_kafkaTable_KafkaTableDebugResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_KafkaTableDebugResponse_descriptor,
        new java.lang.String[] { "Snapshot", });
    internal_static_kafkaTable_PublishedItem_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_kafkaTable_PublishedItem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_PublishedItem_descriptor,
        new java.lang.String[] { "Inc", "Get", "Item", });
    internal_static_kafkaTable_SnapshotOrdering_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_kafkaTable_SnapshotOrdering_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_SnapshotOrdering_descriptor,
        new java.lang.String[] { "ReplicaId", });
    internal_static_kafkaTable_SimpleMessage_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_kafkaTable_SimpleMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kafkaTable_SimpleMessage_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
