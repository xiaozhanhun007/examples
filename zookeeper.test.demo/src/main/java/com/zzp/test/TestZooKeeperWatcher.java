package com.zzp.test;

import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

//import com.beef.util.HexUtil;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestZooKeeperWatcher implements Runnable {
    private final static Logger logger = Logger.getLogger(TestZooKeeperWatcher.class);

    private String _pathToWatch;
    private ZooKeeper _zooKeeper;
    private Watcher _watcher;
    private AsyncCallback.StatCallback _existsStatCallback;
    private AsyncCallback.ChildrenCallback _childrenCallback;
    
    private AtomicBoolean _runFlg = new AtomicBoolean(false);
    private String _threadId;

    public static void main(String[] args) {
        try {
            //{host}:{port},{host}:{port},{host}:{port}
            String connectString = null;
            if(args.length > 0) {
                connectString = args[0];
            } else {
                //default test
                connectString = "127.0.0.1:2181";
            }

            TestZooKeeperWatcher watcher = new TestZooKeeperWatcher(connectString, "/test");
            watcher.run();
        } catch(Throwable e) {
            logger.error(null, e);
        }
    }

    public TestZooKeeperWatcher(String connectString, String pathToWatch) throws IOException, KeeperException, InterruptedException {
        int sessionTimeout = 30*1000;

        _pathToWatch = pathToWatch;
        _watcher = new MyWatcher();
        _zooKeeper = new ZooKeeper(
                connectString, sessionTimeout,
                _watcher
                );
        _existsStatCallback = new MyExistsStatCallBack();
        _childrenCallback = new MyChildrenCallback();
        
        UUID uuid = UUID.randomUUID();
//        _threadId = HexUtil.toHexString(uuid.getMostSignificantBits()) + HexUtil.toHexString(uuid.getLeastSignificantBits());  
    }

    @Override
    public void run() {
        _runFlg.set(true);
        
        logger.info("run() start -----> " + _threadId);
        try {
            synchronized (this) {
                while (_runFlg.get()) {
                    logger.info("run() wait..."); 
                    wait();
                }
            }
        } catch (InterruptedException e) {
            logger.info("TestZooKeeperWatcher interrupted");
        }

        try {
            _zooKeeper.close();
            logger.info("_zooKeeper closed");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
        logger.info("run() end -----> " + _threadId);
    }
    
    

    public void stop() {
        synchronized (this) {
            _runFlg.set(false);
            notifyAll();
        }
    }

	private class MyWatcher implements Watcher {

        @Override
        public void process(WatchedEvent event) {
            try {
                logger.debug("process() event."
                        + " type:" + event.getType()
                        + " state:" + event.getState()
                        + " path:" + event.getPath()
                );

                Event.EventType eventType = event.getType();
                Event.KeeperState keeperState = event.getState();
                String path = event.getPath();

                if(eventType == Event.EventType.None) {
                    if(keeperState == Event.KeeperState.Expired) {
                        stop();
                    } else if(keeperState == Event.KeeperState.SyncConnected) {
                        //_zooKeeper.exists("/", _watcher);
                        //_zooKeeper.exists(_pathToWatch, true, _existsStatCallback, null);
                        _zooKeeper.exists(_pathToWatch, true);
                        logger.debug("add async callback of exists to " + _pathToWatch);
                        
//                        _zooKeeper.getChildren(_pathToWatch, true, _childrenCallback, null);
                        _zooKeeper.getChildren(_pathToWatch, true);
                        logger.debug("add async callback of getChildren to " + _pathToWatch);
                    }
                } else {
                    //Node changed
                    //_zooKeeper.exists(event.getPath(), );
                    if(eventType == Event.EventType.NodeCreated) {
                    } else if(eventType == Event.EventType.NodeChildrenChanged) {
                    } else if(eventType == Event.EventType.NodeDataChanged) {
                    } else if(eventType == Event.EventType.NodeDeleted) {
                    }
                }
            } catch(Throwable e) {
                logger.error(null, e);
            }
        }
    }

    private class MyExistsStatCallBack implements AsyncCallback.StatCallback {

        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            logger.debug("MyExistsStatCallBack processResult()"
                    + " rc:" + rc
                    + " path:" + path
            );

            if(rc == KeeperException.Code.OK.intValue()) {
            } else if(rc == KeeperException.Code.NONODE.intValue()) {
            } else if(rc == KeeperException.Code.SESSIONEXPIRED.intValue()) {
                //stop the main loop
                stop();
            } else {
            }
        }
    }
    
    private class MyChildrenCallback implements AsyncCallback.ChildrenCallback {

        @Override
        public void processResult(int rc, String path, Object ctx,
                List<String> children) {
            logger.debug("MyChildrenCallback processResult()"
                    + " rc:" + rc
                    + " path:" + path
                    + " children:[" + toCommaStrings(children) + "]"
            );
            
        }
        
    }

    private static String toCommaStrings(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for(int i = 0; i < size; i++) {
            if(i != 0) {
                sb.append(",");
            }
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
    
}
