import time

class Node:
    def __init__(self, leaf=True):
        self.keys = []
        self.children = []
        self.leaf = leaf


class BTree:
    def __init__(self):
        self.root = Node()

    def split(self, parent, i):
        y = parent.children[i]
        z = Node(y.leaf)

        z.keys = y.keys[2:]
        middle = y.keys[1]
        y.keys = y.keys[:1]

        if not y.leaf:
            z.children = y.children[2:]
            y.children = y.children[:2]

        parent.keys.insert(i, middle)
        parent.children.insert(i + 1, z)

    def insert_non_full(self, node, key):
        if node.leaf:
            i = len(node.keys) - 1
            node.keys.append(0)

            while i >= 0 and key < node.keys[i]:
                node.keys[i + 1] = node.keys[i]
                i -= 1

            node.keys[i + 1] = key
        else:
            i = len(node.keys) - 1

            while i >= 0 and key < node.keys[i]:
                i -= 1

            i += 1

            if len(node.children[i].keys) == 3:
                self.split(node, i)

                if key > node.keys[i]:
                    i += 1

            self.insert_non_full(node.children[i], key)

    def insert(self, key):
        root = self.root

        if len(root.keys) == 3:
            new_root = Node(False)
            new_root.children.append(root)
            self.root = new_root
            self.split(new_root, 0)

        self.insert_non_full(self.root, key)

    def search(self, node, key):
        i = 0

        while i < len(node.keys) and key > node.keys[i]:
            i += 1

        if i < len(node.keys) and node.keys[i] == key:
            return True

        if node.leaf:
            return False

        return self.search(node.children[i], key)

    def display(self, node, level=0):
        print("Level", level, ":", node.keys)

        if not node.leaf:
            for child in node.children:
                self.display(child, level + 1)


tree = BTree()

n = int(input("Enter number of keys: "))
keys = list(map(int, input("Enter keys: ").split()))

start = time.perf_counter_ns()

for key in keys:
    tree.insert(key)

end = time.perf_counter_ns()

print("\nB-Tree Structure:")
tree.display(tree.root)

key = int(input("Enter key to search: "))

s = time.perf_counter_ns()
found = tree.search(tree.root, key)
e = time.perf_counter_ns()

print("Key Found" if found else "Key Not Found")
print("Insertion Time Complexity: O(log n) per insertion")
print("Search Time Complexity: O(log n)")
print("Space Complexity: O(n)")
print("Insertion Execution Time:", end - start, "ns")
print("Search Execution Time:", e - s, "ns")

Output:
Enter number of keys: 6
Enter keys: 10 20 30 40 50 60

B-Tree Structure:
Level 0 : [20, 40]
Level 1 : [10]
Level 1 : [30]
Level 1 : [50, 60]
Enter key to search: 40
Key Found
Insertion Time Complexity: O(log n) per insertion
Search Time Complexity: O(log n)
Space Complexity: O(n)
Insertion Execution Time: [varies] ns
Search Execution Time: [varies] ns
