# Maps, Hash Tables, and Skip Lists

## Introduction
There are a lot of scenarios in software engineering when we need to map a key to a certain value. Consider a lookup table that maps countries to currencies, ip addresses to geo-locations, phone models to os names, etc. We note that the keys (the country names) are assumed to be unique, but the values (the currency units) are not necessarily unique

## Maps and Dictionaries
Python's [dict class](https://docs.python.org/3/tutorial/datastructures.html#dictionaries) represents an abstraction known as a dictionary in which unique keys are mapped to associated values. Consider the problem of counting the number of occurrences of words in a text.
```Python
def count_words(text: str) -> dict:
    d = {}
    for w in text.split(' '):
        count = d.get(w, 0)
        d[w] = count + 1
    return d
```

## Hash Tables
A simple implementation of Hash Tables is based on arrays. Array indices are keys of Hash Tables, and the array elements are values. We have two challenges in such a scenario. <strong>First</strong>, we may not wish to devote an array of length N if it is the case that N >> n. <strong>Second</strong>, Hash Table keys aren't necessarily integers.   
To solve these problems, we will use hash and compression functions
- Hash functions - map any key to an integer 
    - Bit Representation as Integer: any var with the size less or equal to the integer size can be mapped. In case when var is larger than the size of int, we can do XOR on all parts
    ```Python
    def hash_code(s):
        from operator import xor
        from functools import reduce
        return reduce(lambda x, y: xor(x, ord(y)), s, 0)
    ```
    - Polynomial HashCodes: the XOR method doesn't work for strings that consist of the same chars but in a different order. In this case we can use  polynomial hashcodes. The idea is to give for diffrent parts diffrent weights
    - Cyclic Shift HashCodes  
    ```Python
    def hash_code(s):
        mask = (1 << 32) − 1                   # limit to 32-bit integers
        h = 0
        for character in s:
            h = (h << 5 & mask) | (h >> 27)      # 5-bit cyclic shift of running sum
         h += ord(character)                  # add in value of next character
        return h
    ```
- Compression functions - in some cases, the hash function results can't be used immediately. Results can be negative or exceed the capacity of the underlying array. In such cases, we need compressions functions.
    - The Division Method - <strong>i mod N</strong>
    - The MAD (Multiply-Add-and-Divide) Method - <strong>((a*i + b) mod p)  mod N</strong>
    - Collision-Handling Schemes
        - Separate Chaining - use a secondary container. For example, the value of the Hash Table is a list of values
        - Open Addressing - 
            - Linear Probing - if h(k) = j and j is taken, try j+1
            - Quadratic Probing - h(k) + i^2 for i = 0...n  


## Sorted Maps
Consider a flights search engine that relies on the flights database. The database consists of Flights objects (origin, destination, date, time). The search engine returns a list of tuples for any (origin, destination, date) query. To implement such a behavior, we can use Sorted Maps. A Sorted Map M has the following methods:
- M[k]: return a value for the given key k
- M[k] = v: update the key k with the value v
- del M[k]: delete the key k from the map M
- M.getrange(from_key, to_key): return map item with the given key ranges
- M.gt(k): returns all items with the keys greater the k
- M.le(k): returns all items with the kyes less or equals to k

Sorted Map:
| Operation   | Complexity    |                      
| :---------: | :-----------: |
| len(M)      | O(1)          |
| k in M      | O(log n)      |
| M[k]        | O(n)/O(log v) | 
|             | ^ new/exist.. |
| del M[k]    | O(n)          |
| M.get_range | O(s + log(n)) |
| M.gt/M.le   | O(log n)      |


## Skip Lists
In simple words, Skip Lists allow search like in the sorted arrays and insert and delete like in linked lists. Sorted Maps can be imlemented using Skip Lists. 

Skip lists time complexity:
| Operation | Average       | Worst case      |
| :-------: | :-----------: | :-------------: |
| Space     | O(n)          | O(n long n)     |
| Search    | O(log n)      | O(n)            |
| Insert    | O(log n)      | O(n)            |
| Delete    | O(log n)      | O(n)            |

Skip Lists have simple internal structure comparing to the self balanced binary search trees ([AVL](https://en.wikipedia.org/wiki/AVL_tree), [Read Black](https://en.wikipedia.org/wiki/Red%E2%80%93black_tree)). And it can be used when building [concurrent data structure without locks](https://en.wikipedia.org/wiki/Non-blocking_algorithm). 
But when it comes to performance both AVL and Red Black trees provide much better performance for search, insert and delete.

## Sets, Multisets, and Multimaps
- A set is an unordered collection of elements, without duplicates, that typically supports efficient membership tests. In essence, elements of a set are like keys of a map, but without any auxiliary values.
- A multiset (also known as a bag) is a set-like container that allows duplicates.
- A multimap is similar to a traditional map, in that it associates values with keys; however, in a multimap the same key can be mapped to multiple values. For example, the index of this book maps a given term to one or more locations at which the term occurs elsewhere in the book.


