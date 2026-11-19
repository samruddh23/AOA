import time

MAX = 3

class Node:
    def __init__(self, leaf=True):
        self.keys = []
        self.children = []
        self.leaf = leaf
        self.next = None


class BPlusTree:
    def __init__(self):
        self.root = Node()

    def split(self, parent, index):
        left = parent.children[index]
        right = Node(left.leaf)

        if left.leaf:
            right.keys = left.keys[2:]
            left.keys = left.keys[:2]

            right.next = left.next
            left.next = right

            parent.keys.insert(index, right.keys[0])
        else:
            middle = left.keys[1]

            right.keys = left.keys[2:]
            left.keys = left.keys[:1]

            right.children = left.children[2:]
            left.children = left.children[:2]

            parent.keys.insert(index, middle)

        parent.children.insert(index + 1, right)

    def insert_non_full(self, node, key):
        if node.leaf:
            i = 0

            while i < len(node.keys) and node.keys[i] < key:
                i += 1

            node.keys.insert(i, key)
        else:
            i = 0

            while i < len(node.keys) and key >= node.keys[i]:
                i += 1

            if len(node.children[i].keys) == MAX:
                self.split(node, i)

                if key >= node.keys[i]:
                    i += 1

            self.insert_non_full(node.children[i], key)

    def insert(self, key):
        if len(self.root.keys) == MAX:
            new_root = Node(False)
            new_root.children.append(self.root)
            self.root = new_root
            self.split(new_root, 0)

        self.insert_non_full(self.root, key)

    def search(self, key):
        node = self.root

        while not node.leaf:
            i = 0

            while i < len(node.keys) and key >= node.keys[i]:
                i += 1

            node = node.children[i]

        return key in node.keys

    def display(self, node, level=0):
        print("Level", level, ":", node.keys)

        if not node.leaf:
            for child in node.children:
                self.display(child, level + 1)

    def display_leaves(self):
        node = self.root

        while not node.leaf:
            node = node.children[0]

        print("Leaf Chain:", end=" ")

        while node:
            print(node.keys, end=" -> ")
            node = node.next

        print("NULL")


tree = BPlusTree()

n = int(input("Enter number of keys: "))
keys = list(map(int, input("Enter keys: ").split()))

start = time.perf_counter_ns()

for key in keys:
    tree.insert(key)

end = time.perf_counter_ns()

print("\nB+ Tree Structure:")
tree.display(tree.root)
tree.display_leaves()

key = int(input("Enter key to search: "))

s = time.perf_counter_ns()
found = tree.search(key)
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

B+ Tree Structure:
Level 0 : [30, 50]
Level 1 : [10, 20]
Level 1 : [30, 40]
Level 1 : [50, 60]
Leaf Chain: [10, 20] -> [30, 40] -> [50, 60] -> NULL
Enter key to search: 40
Key Found
Insertion Time Complexity: O(log n) per insertion
Search Time Complexity: O(log n)
Space Complexity: O(n)
Insertion Execution Time: [varies] ns
Search Execution Time: [varies] ns
