# Array-Based Sequences

## Introduction
In computer science, an array data structure, or simply an array, is a data structure consisting of a collection of elements (values or variables), each identified by at least one array index or key. An array is stored such that the position of each element can be computed from its index tuple by a mathematical formula

## Low Level Arrays
The primary memory of a computer is composed of bits of information, and those bits are typically grouped into larger units that depend upon the precise system architecture. Such a typical unit is a byte (8 bits). Each byte of memory is associated with a unique number that serves as its address (random access memory - RAM). A group of related variables can be stored one after another in a contiguous portion of the computer's memory. Such a representation called an [array](https://en.wikipedia.org/wiki/Array_data_structure). For example, see the code of initializing the compacted array of integers


## Python's Array-Based Types
Python has the following built in array-based sequences: [list](https://docs.python.org/3/glossary.html#term-list), [tuple](https://docs.python.org/3/library/stdtypes.html?highlight=tuple#tuple) and [str](https://docs.python.org/3/library/stdtypes.html?highlight=str#str). There is significant commonality between these classes, most notably: each supports indexing to access an individual element of a sequence, using a syntax such as seq[k], and each uses a low-level concept known as an [array](https://docs.python.org/3/library/array.html) to represent the sequence. Primary support for arrays is in a module named array. That module defines a class, also named array, providing compact storage for arrays of primitive data types. Array class constructor requires a type code as a first parameter, which is a character that designates the type of data that is stored in the array.
```python
from array import array
primes = array(‘i’, [2, 3, 5, 7, 11, 13, 17, 19])
```
Python's list class uses a form of dynamic arrays for its storage. The following code appends elements to a list, and the reserved capacity is eventually exhausted. In that case, the class requests a new, larger array from the system and initializes the new array so that its prefix matches that of the existing smaller array. 
```python
import sys
data = []
for k in range(n):
    data.append(k)
    print('{} {}'.format(len(data), sys.getsizeof(data)))
```
The nonmutating behaviors of the list class are precisely those that are supported by the tuple class. Tuples are typically more memory efficient than lists because they are immutable; therefore, there is no need for an underlying dynamic array with surplus capacity.
```python
x = tuple(i for i in range(10))
print(x[0])
x[0] = 1 # wrong, tuple is immutable
```
Python strings are compacted immutable array-based sequences
```python
letters = ''.join(c for c in document if c.isalpha())
letters[0] = 'a' # wrong, string is immutable
for c in letters:
    print(c, type(c))
```

## Array Complexity
- Peek O(1)
- Mutate in dynamic arrays:
    - Beginning O(n)
    - End O(1) [ammortized](https://en.wikipedia.org/wiki/Amortized_analysis)
    - Middle O(n)
