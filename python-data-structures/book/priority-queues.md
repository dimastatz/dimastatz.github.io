# Priority Queues

## Introduction
A Queue is a basic concept in software engineering. When we haven't enough resources to supply at once, we create a waiting list. As a simple approach, we create a queue that is managed by a [FIFO](https://en.wikipedia.org/wiki/FIFO_(computing_and_electronics)) principle. By using a FIFO principle, each new item goes to the back of the queue. Once there is an available resource, items are fetched from the head of the queue and served. Sometimes, not all queue items are equal. Some items are more important and should get resources as soon as possible. 

## The Priority Queue Abstract Data Type
A Priority Queue P is defined in the following way:
- P.add(k, v) - inserts and item with the key k and value v
- P.min() - returns a tuple (k,v) with the minimal key k
- P.remove_min() - performs P.min() and remove the element from the queue  
- P.is_empty() - check of P is empty
- len(P) - returns the number of items in queue

Sorted and Unsorted lists implementation of Priority Queues:
| Operation | Sorted Queues | Unsorted Queues |
| :-------: | :-----------: | :-------------: |
| add       | O(n)          | O(1)            |
| min       | O(1)          | O(n)            |
| rem_min   | O(1)          | O(n)            |
| is_empty  | O(1)          | O(1)            |
| len       | O(1)          | O(1)            |

Both implementations have at least one operation with the time complexity of O(n). The question is it possible to create a data structure that can do all of these operations more efficiently.


## Heaps
Heaps are [complete binary trees](https://www.programiz.com/dsa/complete-binary-tree) for which every parent node has a value less than or equal to any of its children.
Heaps implementation of Priority Queues:
| Operation | Sorted Queues | Unsorted Queues | Heaps     |
| :-------: | :-----------: | :-------------: | :---:     |
| add       | O(n)          | O(1)            | O(log(n)) |
| min       | O(1)          | O(n)            | O(1)      |
| rem_min   | O(1)          | O(n)            | O(log(n)) |
| is_empty  | O(1)          | O(1)            | O(1)      |
| len       | O(1)          | O(1)            | O(1)      |

Here is a array-based implementation of Heap 
```Python
class MinHeap:
    def __init__(self, max_size: int) -> None:
        self.max_size = max_size
        self.size, self.front = 0, 0
        self.heap = [None] * self.max_size 

    def heappush(self, element):
        if self.max_size <= self.size:
            raise OverflowError('heap size exceeded')

        self.size += 1
        self.heap[self.size + self.front] = element
        
        current = self.size + self.front

        while current > self.front + 1 and self.heap[current] < self.heap[current // 2]:
            self.heap[current], self.heap[current // 2] = self.heap[current // 2], self.heap[current]
            current = current // 2
```


## Python heapq
Heapq module in Python implements a heap queue, aka Priority Queue. This implementation uses arrays for which heap[k] <= heap[2*k+1] and heap[k] <= heap[2*k+2] for all k, counting elements from zero. The interesting property of a heap is that its smallest element is always the root, heap[0].
```Python
import heapq

data = [7, 8, 2, 1, 4, 5]

# list to heap in-place, in linear time.
heapq.heapify(data)
print(data) # [1, 4, 2, 8, 7, 5]

# Push to heap, maintaining the heap invariant.
heapq.heappush(data, 3)
print(data) # [1, 4, 2, 8, 7, 5, 3]

heapq.heappush(data, 0)
print(data) # [0, 1, 2, 4, 7, 5, 3, 8]

# Pop and return the smallest item from the heap
print(heapq.heappop(data)) # 0
print(data) # [1, 4, 2, 8, 7, 5, 3]

# Pop and return the smallest item from the heap, and also push the new item.
print(heapq.heapreplace(data, 10)) # 1
print(data) # [2, 4, 3, 8, 7, 5, 10]

print(heapq.nlargest(3, data)) # [10, 8, 7]
print(heapq.nsmallest(3, data)) # [2, 3, 4]
```


## Sorting with a Priority Queue
Heap Sort can be implemented as follows:
```Python
def heap_sort(lst: list) -> list:
    import heapq
    sorted_res = []
    heapq.heapify(lst)

    while lst:
        res.append(heapq.heappop(lst))
    
    return res    
```
Heap Sort runs in O(n*log(n)) since heappop runs in O(log(n))


## Adaptable Priority Queues


