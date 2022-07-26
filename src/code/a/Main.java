package code.a;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Object> map = initializeMap();
        System.out.println(map);
        getValueFromMap(map, null);
    }

    private static Map<String, Object> initializeMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("A", "b");
        Map<String, Object> eMap = Map.of("E", "f");
        HashMap<Object, Object> bMap = new HashMap<>();
        bMap.put("D", eMap);
        bMap.put("F", "g");
        map.put("B", bMap);
        map.put("G", "h");
        return map;
    }

    private static void getValueFromMap(Map<String, Object> currentMap, String previousKey) {
        if (currentMap == null) {
            System.out.print(previousKey);
        } else {
            currentMap.keySet().forEach(currentKey -> {
                if (previousKey != null) {
                    System.out.print(previousKey + ".");
                }
                Object object = currentMap.get(currentKey);
                if (object instanceof Map) {
                    Map<String, Object> newMap = (Map<String, Object>) object;
                    getValueFromMap(newMap, currentKey);
                } else {
                    getValueFromMap(null, currentKey);
                    String value = (String) object;
                    System.out.print(" = " + value);
                    System.out.println();
                }
            });
        }
    }
}