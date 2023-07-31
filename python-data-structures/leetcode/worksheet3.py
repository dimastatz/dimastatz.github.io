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


    def heappop(self):
        poped = self.heap[self.front]
        self.heap[self.front] = self.heap[self.size + self.front]
        self.size -= 1
        
        pos = self.front
        while self.size + self.front > pos * 2:
            left = self.heap[pos * 2]
            right = self.heap[pos * 2 + 1] if  self.size + self.front > pos * 2 + 1 else None
            if right and right < left:
                self.heap[pos], self.heap[pos*2 + 1] = self.heap[pos*2 + 1], self.heap[pos]
                pos = pos*2 + 1
            else:
                self.heap[pos], self.heap[pos*2] = self.heap[pos*2], self.heap[pos]
                pos = pos*2
        return poped


    def print_heap(self):
        return self.heap[self.front + 1: self.front + self.size + 1] 


import heapq

heap1 = []
heap2 = MinHeap(10)

for i in [7, 9, 10, 3, 2]:
    print(i)
    heapq.heappush(heap1, i)
    heap2.heappush(i)
    print(heap1, heap2.print_heap())

