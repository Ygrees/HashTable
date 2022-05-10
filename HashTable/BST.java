public class BST<K extends Comparable<K>, V> {

    private Node root;
    private class Node
    {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val)
        {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {}
    public V get(K key) {GetMin()}
    public void delete(K key) {1}
    public Iterable<K> iterator() {}

    public Iterable<Key> keys()

        {
            Queue<Key> q=new Queue<Key>();
            inorder(root,q);
            return q;
        }

        private void inorder(Node x, Queue<Key> q)
        {
            if (x == null) return;
            inorder(x.left, q);
            q.enqueue(x.key);
            inorder(x.right, q);
        }


}