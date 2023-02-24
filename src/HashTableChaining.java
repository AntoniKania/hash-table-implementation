public class HashTableChaining<K, V> {
    private final int size;
    private int numberOfRecords; // tracking number of Key-Value pairs in given hash table
    private LinkedList<K, V>[] indexes; // Array of all records in hash table

    public HashTableChaining() {
        this(997);
    }

    /**
     * creates given number of empty record which are stored in a Array
     * @param size of hash table to create
     */
    public HashTableChaining(int size) {
        this.size = size;
        this.indexes = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            indexes[i] = new LinkedList<>();
        }
    }

    /**
     * hashing function implementing multiplication method of hashing
     * 0x7fffffff is a mask bit, it works as converter to absolute value
     */
    private int hash(K key) {
        return ((int) ((1247463646*key.hashCode() & 0x7fffffff) % Math.pow(2, 32)) >> 16) % size;
    }

    public V getValue(K key) {
        return indexes[hash(key)].getValue(key);
    }

    public void put(K key, V val) {
        indexes[hash(key)].put(key, val);
        numberOfRecords++;
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "] " + indexes[i]);
        }
    }
    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        HashTableChaining<String, String> hashTable = new HashTableChaining<>(7);

        // adding more key-value pairs than the hash table size in order to cause collisions
        hashTable.put("Gdynia", "1998");
        hashTable.put("Gdansk", "2002");
        hashTable.put("Ala", "1968");
        hashTable.put("Hel", "2001");
        hashTable.put("Chlapowo", "1998");
        hashTable.put("Grudziadz", "1979");
        hashTable.put("Bydgoszcz", "1998");
        hashTable.put("Ciechanow", "2004");
        hashTable.put("Zukowo", "1993");
        hashTable.put("Elblag", "2002");
        hashTable.put("Lodz", "1998");
        hashTable.put("Poznan", "1976");
        hashTable.put("Krakow", "1998");
        hashTable.put("Warszawa", "2002");
        hashTable.put("Ala", "1994"); // duplicate: value will be updated

        System.out.println("Size of hash table: " + hashTable.getSize());
        System.out.println("Number of records:" + hashTable.getNumberOfRecords());
        System.out.println("value for key Warszawa: " + hashTable.getValue("Warszawa"));

        hashTable.printTable();
    }

    private static class LinkedList<K, V> {
        private Node first;

        protected class Node {
            K key;
            V val;
            Node next;

            public Node(K key, V val, Node next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

        public V getValue(K key) {
            for (Node x = first; x != null; x = x.next)
                if (key.equals(x.key)) // hit
                    return x.val;
            return null; // miss
        }

        public void put(K key, V val) {
            for (Node x = first; x != null; x = x.next)
                if (key.equals(x.key)) { // hit (value with given key already exists): updating the value
                    x.val = val;
                    return;
                }
            first = new Node(key, val, first); // miss: adding new Node at the beginning of the LinkedList
        }

        public String toString() {
            Node current = first;
            StringBuilder result = new StringBuilder();

            while (current != null) {
                result.append("{ ")
                        .append(String.format("%-1s %-1s", current.key.toString(), current.val.toString()))
                        .append(" } ");

                current = current.next;
            }

            return result + "\n";
        }
    }
}
