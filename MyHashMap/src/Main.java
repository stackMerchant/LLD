public class Main {
    public static void main(String[] args) {
        System.out.println("=== Start Application ===");

        // Initialize map
        MyHashMap<Integer, String> numberToStringMap = new MyHashMap<>(10);

        // Set values
        numberToStringMap.put(1, "ONE");
        numberToStringMap.put(2, "TWO");
        numberToStringMap.put(12, "TWELVE");
        numberToStringMap.put(1000, "ONE_THOUSAND");
        numberToStringMap.put(72, "SEVENTY_TWO");
        numberToStringMap.put(19, "NINETEEN");

        // Get values
        System.out.println("12 => " + numberToStringMap.get(12));
        System.out.println("1000 => " + numberToStringMap.get(1000));

        // Print while map to visualize it
        System.out.println();
        numberToStringMap.print();

        System.out.println("=== End Application ===");
    }
}