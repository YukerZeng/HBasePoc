package com.example.hbasepoc;

import static org.apache.hadoop.hbase.HConstants.ZOOKEEPER_CLIENT_PORT;
import static org.apache.hadoop.hbase.HConstants.ZOOKEEPER_QUORUM;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@org.springframework.context.annotation.Configuration
public class HbaseConfig {

  @Value("${hbase.zookeeper.quorum}")
  private String zkQuorum;

  @Value("${hbase.zookeeper.property.clientPort}")
  private int zkPort;

  @Value("${zookeeper.znode.parent}")
  private String zkRootDir;

  @Value("${hbase.rootdir}")
  private String hbaseDir;

  @Bean
  public Configuration hBaseConfiguration() {
    Configuration hBaseConfiguration = HBaseConfiguration.create();
    hBaseConfiguration.set(ZOOKEEPER_QUORUM, "localhost");
    hBaseConfiguration.setInt(ZOOKEEPER_CLIENT_PORT, 2181);
//    hBaseConfiguration.set(HBASE_DIR, "hdfs://localhost:9000/hbase");  //hbase.rootdir   :  hdfs://127.0.0.1:9000/hbase
//    hBaseConfiguration.set(ZOOKEEPER_ZNODE_PARENT, zkRootDir);  // zookeeper.znode.parent  :  /hbase
    return hBaseConfiguration;
  }

  @Bean
  public HbaseTemplate hbaseTemplate(Configuration configuration) {
    HbaseTemplate hbaseTemplate = new HbaseTemplate(configuration);
    return hbaseTemplate;
  }
}
