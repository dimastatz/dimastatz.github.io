# Sorting and Selection

## Introduction
Sorting algorithms put elements of the input into an order. Efficient sorting is important for [search](https://en.wikipedia.org/wiki/Search_algorithm) and [merge](https://en.wikipedia.org/wiki/Merge_algorithm) algorithms. The output of sorting satisfies two conditions: output is in [monotonic](https://en.wikipedia.org/wiki/Monotonic_function) order, and is a [permutation](https://en.wikipedia.org/wiki/Permutation) of the input.  

## Merge Sort
Merge Sort creates a binary tree with the heigh=<em>log(n)</em>. Each level of the binary tree is sorted and merged to the sorted output. Merge sort is a [divide and conquer](https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm) algorithm and most implementations produce a [stable sort](https://en.wikipedia.org/wiki/Sorting_algorithm#Stability).
```Python
def merge_sort(s: list) ->list:
    if len(s) < 2:
        return s
    else:
        mid = len(s) // 2
        left = merge_sort(s[0:mid])
        right = merge_sort(s[mid:])
        return merge(left, right)
``` 
| Operation | Worst case |      
| :-------: | :--------: |
| space     | O(n)       |
| time      | O(log n)   |


## Quick Sort
Quick Sort is similar to the Merge Sort in a way that it relies on [divide and conquer](https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm). On each step, Quick Sort calculates a pivot point. Elements that are less than the pivot point are moving to the left, and elements that are greater than the pivot point are moving to the right. Quick Sort has the time complexity of O(n) in the worst case. For example, think about sorted arrays as an input to Quick Sort. 

| Operation | Worst case |      
| :-------: | :--------: |
| space     | O(log n)   |
| time      | O(n^2)       |


## Comparing Sorting Algorithms

| Name      | Time      | Space   | Notes                                     |
| :-------: | :-------: | :-----: | :---------------------------------------: |
| insertion | O(n^2)    | O(1)    | A bit faster then select-sort             |
| selection | O(n^2)    | O(1)    | Simple implementation                     |
| heap      | O(nlog n) | O(1)    | Great in small and avg sequences          |
| merge     | O(nlog n) | O(n)    | Highly parallelizable. Python sorting     |
| quick     | O(n^2)    | O(logn) |                                           |
| bucket    | O(n+k)    | O(n+k)  | Assumes uniform distribution of int keys  |
| radix     | O(n*k)    | O(n+k)  |                                           |


## Python Built-in Sorting
Python has two ways for sorting. The first one is by using [sort](https://docs.python.org/3/tutorial/datastructures.html) function of the list class. This is in place sorting:
```Python
nums = [(1, 'a'), (2, 'b'), (3, 'a'), (4, 'b')]
nums.sort() # nums = [(1, 'a'), (1, 'b'), (2, 'b'), (3, 'a'), (4, 'b')]
nums.sort(reverse=True) # nums = [(4, 'b'), (3, 'a'), (2, 'b'), (1, 'b'), (1, 'a')]
nums.sort(key=lambda x: x[1]) # nums = [(3, 'a'), (1, 'a'), (4, 'b'), (2, 'b'), (1, 'b')]
nums.sort(key=lambda x: (x[1], x[0])) # nums = [(1, 'a'), (3, 'a'), (1, 'b'), (2, 'b'), (4, 'b')]
```
This method reordering the elements of the list by using [<](https://docs.python.org/3/library/operator.html) operator. Python also has more general [sorted](https://docs.python.org/3/howto/sorting.html) function. It can be used with any sequence and it is immutable. This function return the sorted version of the inyt sequence
```Python
sorted('green') # -> ['e', 'e', 'g', 'n', 'r']
nums = [1, 3, 2]
sorted(nums) # -> [1, 2, 3] and nums=[1, 3, 2]
```

## Selection
Selecting the k-th smallest(largest) element from an unsorted collection of n comparable elements is known as the selection problem. We can solve this problem by sorting the collection and then indexing into the sorted sequence at index k − 1. This approach would take O(nlogn) time. This problem is also can be solved by using [prune-and-search](https://en.wikipedia.org/wiki/Prune_and_search) or [decrease-and-conquer](https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm) techniques. For example the [selection algorithm](https://en.wikipedia.org/wiki/Selection_algorithm) with the time complexity of O(n). 
