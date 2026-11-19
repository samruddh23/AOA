import java.util.*;

public class BPlusTree {
    static final int MAX = 3;

    static class Node {
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Node> children = new ArrayList<>();
        Node next;
        boolean leaf = true;
    }

    Node root = new Node();

    void insert(int key) {
        Node r = root;

        if (r.keys.size() == MAX) {
            Node newRoot = new Node();
            newRoot.leaf = false;
            newRoot.children.add(r);
            root = newRoot;
            split(newRoot, 0);
        }

        insertNonFull(root, key);
    }

    void split(Node parent, int index) {
        Node left = parent.children.get(index);
        Node right = new Node();

        right.leaf = left.leaf;

        if (left.leaf) {
            right.keys.addAll(left.keys.subList(2, left.keys.size()));
            left.keys.subList(2, left.keys.size()).clear();

            right.next = left.next;
            left.next = right;

            parent.keys.add(index, right.keys.get(0));
        } else {
            int middle = left.keys.get(1);

            right.keys.addAll(left.keys.subList(2, left.keys.size()));
            left.keys.subList(1, left.keys.size()).clear();

            right.children.addAll(left.children.subList(2, left.children.size()));
            left.children.subList(2, left.children.size()).clear();

            parent.keys.add(index, middle);
        }

        parent.children.add(index + 1, right);
    }

    void insertNonFull(Node node, int key) {
        if (node.leaf) {
            int i = 0;

            while (i < node.keys.size() && node.keys.get(i) < key)
                i++;

            node.keys.add(i, key);
        } else {
            int i = 0;

            while (i < node.keys.size() && key >= node.keys.get(i))
                i++;

            if (node.children.get(i).keys.size() == MAX) {
                split(node, i);

                if (key >= node.keys.get(i))
                    i++;
            }

            insertNonFull(node.children.get(i), key);
        }
    }

    boolean search(int key) {
        Node node = root;

        while (!node.leaf) {
            int i = 0;

            while (i < node.keys.size() && key >= node.keys.get(i))
                i++;

            node = node.children.get(i);
        }

        return node.keys.contains(key);
    }

    void display(Node node, int level) {
        System.out.println("Level " + level + ": " + node.keys);

        if (!node.leaf) {
            for (Node child : node.children)
                display(child, level + 1);
        }
    }

    void displayLeaves() {
        Node node = root;

        while (!node.leaf)
            node = node.children.get(0);

        System.out.print("Leaf Chain: ");

        while (node != null) {
            System.out.print(node.keys + " -> ");
            node = node.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BPlusTree tree = new BPlusTree();

        System.out.print("Enter number of keys: ");
        int n = sc.nextInt();

        long start = System.nanoTime();

        System.out.println("Enter keys:");
        for (int i = 0; i < n; i++)
            tree.insert(sc.nextInt());

        long end = System.nanoTime();

        System.out.println("\nB+ Tree Structure:");
        tree.display(tree.root, 0);
        tree.displayLeaves();

        System.out.print("\nEnter key to search: ");
        int key = sc.nextInt();

        long s = System.nanoTime();
        boolean found = tree.search(key);
        long e = System.nanoTime();

        System.out.println(found ? "Key Found" : "Key Not Found");
        System.out.println("Insertion Time Complexity: O(log n) per insertion");
        System.out.println("Search Time Complexity: O(log n)");
        System.out.println("Space Complexity: O(n)");
        System.out.println("Insertion Execution Time: " + (end - start) + " ns");
        System.out.println("Search Execution Time: " + (e - s) + " ns");

        sc.close();
    }

  Output:
  Enter number of keys: 6
Enter keys:
10 20 30 40 50 60

B+ Tree Structure:
Level 0: [30, 50]
Level 1: [10, 20]
Level 1: [30, 40]
Level 1: [50, 60]
Leaf Chain: [10, 20] -> [30, 40] -> [50, 60] -> NULL

Enter key to search: 40
Key Found
Insertion Time Complexity: O(log n) per insertion
Search Time Complexity: O(log n)
Space Complexity: O(n)
Insertion Execution Time: [varies] ns
Search Execution Time: [varies] ns
}
