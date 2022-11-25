package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Initialize an empty map
        Map<String, String> map = Map.of();

        //Initialize a unmodifiable map with Map.of
        Map<String, String> map2 = Map.of("key1", "value1", "key2", "value2");
        System.out.println(map2);

        //Initialize a unmodifiable map with Map.ofEntries();
        Map<String, String> map3 = Map.ofEntries(
                            Map.entry("key1", "value1"),
                            Map.entry("key2", "value2"),
                            //more
                            Map.entry("key100", "value100")
        );
        System.out.println(map3);

        //Initialize a map via the new operator
        Map<String, String> map4 = new HashMap<>();
        map4.put("Android", "Mobile");
        map4.put("Eclipse Ide", "Java");
        map4.put("Eclipse RCP", "Java");
        map4.put("Git", "Version control system");
        System.out.println(map4);

        //Remove an entry from a map
        map4.remove("Git");
        System.out.println(map4);

        //Process the map
        map4.forEach((k,v) -> System.out.printf("%s - %s%n", k,v));

        //convert keys to array
        String[] keys = map4.keySet().toArray(new String[map4.keySet().size()]);
        for(String string: keys){
            System.out.println(string);
        }

        //convert keys to list
        List<String> list = new ArrayList<String>(map4.keySet());
        for(String str: list){
            System.out.println(str);
        }

        //Getting the current value or a default for a map
        Map<String,Integer> map5 = new HashMap<>();
        map5.put("Android", 1 + map5.getOrDefault("Android", 0));
        map5.forEach((k,v) -> System.out.printf("%s - %s%n", k, v));

        //computeIfAbsent calculates and adds an entry to the map if it is not present in the map. (¿malo?)
//        Map<String, Integer> map6 = Map.of();
//        Integer calculatedValue = map6.computeIfAbsent("Java", it -> 0);
//        System.out.println(calculatedValue);

//        map6.keySet().forEach(key -> System.out.println(key + "-" + map6.get(key)));


    }
}