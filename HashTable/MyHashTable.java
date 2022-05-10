public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        K key;
        V value
                int hashCode;
    }

    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public Map()
    {
        chainArray = new MyArrayList<>();
        M = 11;
        size = 0;

        for (int i = 0; i < M; i++)
            chainArray.add(null);
    }

    public MyHashTable(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }

    public MyHashTable(int M) {}

    private  int hash(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % M;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public void put(K key, V value) {
        int hashIndex = getHashIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = chainArray.get(hashIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = chainArray.get(hashIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
        newNode.next = head;
        chainArray.set(hashIndex, newNode);

        if ((1.0 * size) / M >= 0.7) {
            ArrayList<HashNode<K, V> > temp = chainArray;
            chainArray = new MyArrayList<>();
            M = 2 * M;
            size = 0;
            for (int i = 0; i < M; i++)
                chainArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public V get(K key) {
        int hashIndex = getHash(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = chainArray.get(hashIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int hash = getHash(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = chainArray.get(hashIndex);


        HashNode<K, V> prev = null;
        while (head ! = null) {
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;
            prev = head;
            head = head.next;
        }

        if (head == null)
            return null;
        size--;
        if (prev != null)
            prev.next = head.next;
        else
            chainArray.set(hashIndex, head.next);

        return head.value;
    }

    public boolean containsValue(Object value) {
        if (fast) {
            return (map.containsValue(value));
        } else {
            synchronized (map) {
                return (map.containsValue(value));
            }
        }
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++){
            HashNode<K, V> head = chainArray[i];
            while (head ! = null) {
                if(head.value.equals(value)) {
                    return head.key;
                }
                head = head.next;
            }
        }
        return null;
    }

    public static void main(Array[] args)
    {
        Map<String, Integer> map = new Map<>();
        map.add("a", 1);
        map.add("b", 2);
        System.out.println(map.size());
        System.out.println(map.remove("a"));
    }

}