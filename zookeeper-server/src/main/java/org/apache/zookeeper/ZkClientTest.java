package org.apache.zookeeper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ZkClientTest implements Watcher{


    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181",
                4000, new ZkClientTest());
        zooKeeper.create("/kevin","123".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.CONTAINER);
    }


    @Override
    public void process(WatchedEvent event) {
        System.out.println("数据变动监听逻辑触发");
    }
}
