# Trees

## Introduction
In many different domains, we need to organize data in hierarchical structures. For example, think about big organizations, file systems, databases, class hierarchies, family trees, etc. Linear data structures like arrays, queues, and linked lists aren't expressive enough to represent such data. 

## General Trees
A Tree is a data structure that consists of a root and nodes. A Root is a special node that has no parent. All other nodes have exactly one parent and 0 or more children. Children that share the same parent are called siblings. Nodes that have no children are called leaves. Nodes that have children are called internal nodes.
```Python
class TreeNode
    def __init__(self, value, parent=None, children=[]):
        self.value = value
        self.parent: TreeNode = parent
        self.children: list = children
``` 
A tree is <em>ordered</em> if there is a meaningful linear order among the children of each node; that is, we purposefully identify the children of a node as being the first, second, third, and so on. 
The tree T then supports the following accessor methods:

## Binary Trees
Binary Trees are General Trees consisting of nodes with up to two children. Binary trees are ordered trees. Each child can be either left or right. A binary tree is proper if each node has exactly 2 or 0 children (aka full binary tree).
The following function constructs a binary search tree:
```Python
def insert(parent, key):
    if parent is None:
        return TreeNode(key)
    else:
        if parent.val == key:
            return root
        elif parent.val < key:
            parent.right = insert(parent.right, key)
        else:
            parent.left = insert(parent.left, key)
    return parent
```  

## Tree traversal algorithms
- Preorder: visit current node and then recursively visit all children
```Python
def preorder(node: TreeNode):
    if node:
        print(node.value)
        for n in node.children:
            preorder(n)
```
- Postorder: visit recursively all children and the visit the current node
```Python
def postorder(node: TreeNode):
    if node:
        for n in node.children:
            postorder(n)
        print(node.value)
```
- Breadth-First: Visit all nodes in the same depth and then visit all subtrees
```Python
def breadthfirst(root: TreeNode):
    queue = [root]
    while queue:
        node = queue.pop(0)
        print(node.value)
        for c in node.children:
            queue.append(c)
```
- Inorder for Binary Trees:
```Python
def inorder(node: TreeNode):
    if node:
        inorder(node.left)
        print(node.value)
        inorder(node.right)
```
- Binary Search Trees: BST is a binary tree where for each node N the following is true: 
    - <em>N.left.value < N.value < N.right.value</em>
The height of the binary search tree can be as small as log(n + 1) - 1 and as large as n - 1.


## Example: Expression Trees



