public class MyHashMap<K, V> {
    // Generated hash codes will lie in range [0, capacity)
    int capacity;

    // Indexes will be hash codes, and each index will have a linked list of collided keys
    LinkedListNode<K, V>[] arrayOfHashLists;

    // Class to store key, value and reference to next entry of same hash code
    static class LinkedListNode<K, V> {
        K key;
        V value;
        LinkedListNode<K, V> next;

        LinkedListNode(K _key, V _value, LinkedListNode<K, V> _next) {
            key = _key;
            value = _value;
            next = _next;
        }
    }

    // Constructor
    MyHashMap(int _capacity) {
        capacity = _capacity;
        arrayOfHashLists = new LinkedListNode[_capacity];
    }

    // Put entry in map
    void put(K key, V value) {
        // Calculate hash of key
        int hashCode = getHash(key);
        // Get first node of linked list corresponding to hashCode
        LinkedListNode<K, V> firstNode = arrayOfHashLists[hashCode];

        // Iterate till key is different
        LinkedListNode<K, V> currNode = firstNode;
        while (currNode != null && !currNode.key.equals(key)) currNode = currNode.next;

        if (currNode == null) // If key is not found, add a new entry at the front
            arrayOfHashLists[hashCode] = new LinkedListNode<>(key, value, firstNode);
        else // Else update the value in existing node
            currNode.value = value;
    }

    // Get entry from map
    V get(K key) {
        // Iterate till key is different
        LinkedListNode<K, V> currNode = arrayOfHashLists[getHash(key)];
        while (currNode != null && !currNode.key.equals(key)) currNode = currNode.next;

        // If key is not found, return null else value
        return currNode == null ? null : currNode.value;
    }

    // Prints the generated map to help visualize how values are set
    void print() {
        System.out.println("MyHashMap entries:");
        for (int i=0; i<capacity; i++) {
            System.out.print("Index/HashCode: " + i + " => ");
            LinkedListNode<K, V> currNode = arrayOfHashLists[i];
            while (currNode != null) {
                System.out.print("{" + currNode.key + ", " + currNode.value + "} ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    }

    // Calculates hash for key
    private int getHash(K key) {
        return key.hashCode() % capacity;
    }

}
