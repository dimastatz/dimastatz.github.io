# Linked Lists

## Introduction
[Stacks, Queues, and Deques](https://github.com/dimastatz/courses-and-books/blob/master/python-data-structures/book/stack-queues-deques.md) are fundamental data structures that can be implemented by using [Arrays](https://github.com/dimastatz/courses-and-books/blob/master/python-data-structures/book/array-based-sequences.md). The drawback of using arrays as an underlying structure is poor performance when size changes frequently. Both increase and shrink have the time complexity of O(n). Another way to implement stack, queues, and deques, is by using linked lists.

## Singly Linked Lists
A singly linked list is a collection of nodes that collectively form a linear sequence. Each node stores a value and a reference to the next node of the list.

```Python
class Node:
    def __init__(self, element, next=None):
        self.element = element
        self.next: Node = next
```
Implementing stack and queue using linked lists is easy. For example, see stack implementation:
```Python
class LinkedStack:
    def __init__(self) -> None:
        self.size = 0
        self.head: Node = None
        
    def push(self, element):
        node = Node(element, self.head)
        self.head = node
        self.size += 1
        
    def pop(self):
        if self.size == 0:
            raise Exception('stack is empty')
        self.size -= 1
        item = self.head
        self.head = self.head.next
        return item.element

    def top(self):
        if self.size == 0:
            raise Exception('stack is empty')
        return self.head.element

    def len(self):
        return self.size

    def is_empty(self):
        return self.size == 0
```
[Python collection module](https://github.com/python/cpython/blob/main/Modules/_collectionsmodule.c#L71)  contains an implementation of the linked list. [collection.deque](https://realpython.com/python-deque/) can be used as stack or queue. 

## Circularly Linked Lists
A circularly linked list provides a more general model than a standard linked list for data sets that are cyclic, that is, which do not have any particular notion of a beginning and end.

## Doubly Linked Lists
To provide greater symmetry, we define a linked list in which each node keeps an explicit reference to the node before it and a reference to the node after it. Such a structure is known as a doubly-linked list.
```Python
class Node:
    def __init__(self, element, next: None, prev: None):
        self.element = element
        self.next: Node = next
        self.prev: Node = prev
```
In order to avoid some special cases when operating near the boundaries of a doubly-linked list, it helps to add special nodes at both ends of the list: a header node at the beginning of the list, and a trailer node at the end of the list
```Python
class DoublyLinkedList:
    def __init__(self):
        self.size = 0
        self.header: Node = Node(None)
        self.trailer: Node = Node(None)
        self.header.next = self.trailer
        self.trailer.prev = self.header

    def insert_first(self, element):
        node = Node(element, header.next, header)
        self.header.next.prev = node
        self.header.next = node
        ...
```

