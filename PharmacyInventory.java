import java.util.*;

public class PharmacyInventory {
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();

        hashMap.put(101, "Paracetamol");
        hashMap.put(102, "Cetirizine");
        hashMap.put(103, "Vitamin C");

        treeMap.putAll(hashMap);
        linkedMap.putAll(hashMap);

        System.out.println("HashMap: " + hashMap);
        System.out.println("TreeMap: " + treeMap);
        System.out.println("LinkedHashMap: " + linkedMap);
    }
}