package com.example.hbasepoc;

import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Service;

@Service
public class HBasePOCService {

  @Autowired
  private HbaseTemplate hbaseTemplate;
  @Value("${hbase.table}")
  private String hbaseTable;

  public void insert() {
    List puts = new ArrayList();
    Put put = new Put("tenant02/123/indoorparam/20200616".getBytes());
    put.addColumn("ts".getBytes(), "location".getBytes(), "sh".getBytes());
    puts.add(put);

    hbaseTemplate.execute("iot-cts-data", table -> {
      table.put(puts);
      return null;
    });
  }

  public void write() {
    hbaseTemplate.put("iot-cts-data", "tenant02/123/indoorparam", "ts", "location", "cd2".getBytes());
  }

  public void query() {
    hbaseTemplate.find("iot-cts-data", "ts", "location", (Result r, int row) -> {
      System.out.println("zyk" + r.toString());
      return null;
    });
  }

  public void delete() {
    hbaseTemplate.delete("iot-cts-data", "tenant02/123/indoorparam/20200616", "ts");
  }

}
