package com.jabaddon.hazelcast.learning.simplemap;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SimpleMap {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMap.class);

    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        
        Map<String, String> capitals = hz.getMap("capitals");
        capitals.put("GB", "London");
        capitals.put("FR", "Paris");
        capitals.put("US", "Washington DC");
        capitals.put("AU", "Canberra");

        LOGGER.info("Known capital cities: " + capitals.size());
        LOGGER.info("Capital city of GB: " + capitals.get("GB"));
    }

    /*
    After running this then run this in a new terminal

    $ java -cp ~/.m2/repository/com/hazelcast/hazelcast/4.1/hazelcast-4.1.jar com.hazelcast.console.ConsoleApp

    This will start a new node that will join to this node/app and there you will see the contents of the map in
    namespace `capitals`

    > ns capitals
    > m.size
    4

    > m.get GB
    London
     */
}
