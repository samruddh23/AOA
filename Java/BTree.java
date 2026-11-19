import java.util.*;

public class BTree {
    static class Node {
        int[] keys = new int[3];
        Node[] child = new Node[4];
        int count = 0;
        boolean leaf = true;
    }

    Node root = new Node();

    void insert(int key) {
        Node r = root;

        if (r.count == 3) {
            Node s = new Node();
            s.leaf = false;
            s.child[0] = r;
            root = s;
            split(s, 0);
        }

        insertNonFull(root, key);
    }

    void split(Node parent, int i) {
        Node y = parent.child[i];
        Node z = new Node();

        z.leaf = y.leaf;
        z.count = 1;
        z.keys[0] = y.keys[2];

        if (!y.leaf) {
            z.child[0] = y.child[2];
            z.child[1] = y.child[3];
        }

        y.count = 1;

        for (int j = parent.count; j >= i + 1; j--)
            parent.child[j + 1] = parent.child[j];

        parent.child[i + 1] = z;

        for (int j = parent.count - 1; j >= i; j--)
            parent.keys[j + 1] = parent.keys[j];

        parent.keys[i] = y.keys[1];
        parent.count++;
    }

    void insertNonFull(Node x, int k) {
        int i = x.count - 1;

        if (x.leaf) {
            while (i >= 0 && k < x.keys[i]) {
                x.keys[i + 1] = x.keys[i];
                i--;
            }

            x.keys[i + 1] = k;
            x.count++;
        } else {
            while (i >= 0 && k < x.keys[i])
                i--;

            i++;

            if (x.child[i].count == 3) {
                split(x, i);
                if (k > x.keys[i])
                    i++;
            }

            insertNonFull(x.child[i], k);
        }
    }

    boolean search(Node x, int k) {
        int i = 0;

        while (i < x.count && k > x.keys[i])
            i++;

        if (i < x.count && k == x.keys[i])
            return true;

        if (x.leaf)
            return false;

        return search(x.child[i], k);
    }

    void display(Node x, int level) {
        System.out.print("Level " + level + ": [");

        for (int i = 0; i < x.count; i++)
            System.out.print(x.keys[i] + " ");

        System.out.println("]");

        if (!x.leaf) {
            for (int i = 0; i <= x.count; i++)
                display(x.child[i], level + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree tree = new BTree();

        System.out.print("Enter number of keys: ");
        int n = sc.nextInt();

        long start = System.nanoTime();

        System.out.println("Enter keys:");
        for (int i = 0; i < n; i++)
            tree.insert(sc.nextInt());

        long end = System.nanoTime();

        System.out.println("\nB-Tree Structure:");
        tree.display(tree.root, 0);

        System.out.print("\nEnter key to search: ");
        int key = sc.nextInt();

        long s = System.nanoTime();
        boolean found = tree.search(tree.root, key);
        long e = System.nanoTime();

        System.out.println(found ? "Key Found" : "Key Not Found");
        System.out.println("Insertion Time Complexity: O(log n) per insertion");
        System.out.println("Search Time Complexity: O(log n)");
        System.out.println("Space Complexity: O(n)");
        System.out.println("Insertion Execution Time: " + (end - start) + " ns");
        System.out.println("Search Execution Time: " + (e - s) + " ns");

        sc.close();
    }
}

Output:
Enter number of keys: 6
Enter keys:
10 20 30 40 50 60

B-Tree Structure:
Level 0: [20 40 ]
Level 1: [10 ]
Level 1: [30 ]
Level 1: [50 60 ]

Enter key to search: 40
Key Found
Insertion Time Complexity: O(log n) per insertion
Search Time Complexity: O(log n)
Space Complexity: O(n)
Insertion Execution Time: [varies] ns
Search Execution Time: [varies] ns
