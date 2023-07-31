# Stacks, Queues, and Deques

## Introduction
[FIFO](https://en.wikipedia.org/wiki/FIFO_and_LIFO_accounting) first-in-first-out and [LIFO](https://en.wikipedia.org/wiki/FIFO_and_LIFO_accounting) last-in-first-out are methods used in managing inventory and financial matters. For instance, they are used to manage assumptions of costs related to inventory, stock repurchases (if purchased at different prices), and various other accounting purposes. Stack (FIFO) and Queue (LIFO) are fundamental data structures in computer science and are widely used in different scenarios.

## Stack
Stack is a data structure that manages a collections of objects by LIFO principle. Stack supports the following operations:
- push: add new element to the top of the stack
    - Time complexity: O(1)
- pop: remove and return the element from the top of the stack
    - Time complexity: O(1)
- top: return and element from the top of stack
    - Time complexity: O(1)
- is_empty: return true if stack is empty, otherwise return false
    - Time complexity: O(1)
- length: return the number of elements in the stack
    - Time complexity: O(1)  
  
In Python we use [list, collections.deque, queue.LifoQueue](https://realpython.com/how-to-implement-python-stack/) as stack or we can implement stack using list:

```python
class ArrayStack:
    def __init__(self, capacity: int) -> None:
        self.top_idx = -1
        self.stack = [None for i in range(capacity)]
        
    def top(self):
        if self.is_empty():
            raise Exception('stack is empty')
        return self.stack[self.top_idx]
    
    def pop(self):
        if self.is_empty():
            raise Exception('stack is empty')   
        self.top_idx -= 1
        return self.stack[self.top_idx + 1]
    
    def push(self, x):
        if self.length() == len(self.stack):
            raise Exception('stack is full')
        self.top_idx += 1
        self.stack[self.top_idx] = x

    def length(self):
        return self.top_idx + 1
    
    def is_empty(self):
        return self.top_idx == -1
```

## Queue
It is a close “cousin” of the stack, as a queue is a collection of objects that are inserted and removed according to the first-in, first-out (FIFO) principle. Queue supports the following operations:
- enqueue : add element to the back of the queue
    - Time complexity: O(1)
- dequeue: remove and return element from the head of the queue
    - Time complexity: O(1)
- first: return the first element of the queue
    - Time complexity: O(1)
- is_empty: return True if queue is empty
    - Time complexity: O(1)
- length: return the length of the queue
    - Time complexity: O(1)  
  
In python we can use [list, queue.Queue, collection.deque](https://docs.python.org/3/library/queue.html) for queue. We can implement Queue by using circular array.

## Double-Ended Queues
We next consider a queue-like data structure that supports insertion and deletion at both the front and the back of the queue. Such a structure is called a double-ended queue, or deque (pronounced “deck” to avoid confusion). The deque abstract operations:
- add-first: add element to the front
    - Time complexity: O(1)
- add-last: add element to the back
    - Time complexity: O(1)  
- delete-first: remove and return the first element
    - Time complexity: O(1)  
- delete-last: remove and return the last element
    - Time complexity: O(1)  
- first: return first element
    - Time complexity: O(1)  
- last: return last element
    - Time complexity: O(1)  
- is_empty: return True if empty
    - Time complexity: O(1)  
- len: return the number of elements in deque
    - Time complexity: O(1) 

Python implementation can be found in [collection.deque](https://docs.python.org/3/library/collections.html#collections.deque). We can implement deque by using circular array.








