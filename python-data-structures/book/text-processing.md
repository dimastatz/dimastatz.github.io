# Text Processing

## Abundance of Digitized Text
Processing, indexing, analyzing, and archiving texts are usual tasks for software applications. Dealing with data volumes of PB and more are regular today. So we need efficient algorithms to deal with texts. Character strings are fair representation of text. For example, in python text can be represented by a [str](https://docs.python.org/3/library/stdtypes.html#text-sequence-type-str) class.

## Pattern-Matching Algorithms
In the classic pattern-matching problem, we are given a text string T of length n and a pattern string P of length m, and want to find whether P is a substring of T. If so, we may want to find the lowest index j within T at which P begins, such that T[j:j+m] equals P, or perhaps to find all indices of T at which pattern P begins.  

### Brute Force
In Brute-Force we find all possible solutions. The brute force runs  with the Time Complexity of 
O(nm), where n is the length of text T and m is the length of pattern P.
```Python
def find_brute(T, P):
    n, m = len(T), len(P) 
    for i in range(n−m+1):
        k = 0
        while k < m and T[i + k] == P[k]: 
            k += 1 
            if k == m:
                return i 
    return −1
```
### The Boyer-Moore Algorithm
[TBD]

### The Knuth-Morris-Pratt Algorithm
[TBD]

## Dynamic Programming
Dynamic Programming is the optimization technique that solves the [overlapping subproblems](https://en.wikipedia.org/wiki/Overlapping_subproblems). For example, consider the [Fibonacci](https://en.wikipedia.org/wiki/Fibonacci_number) number implementation:
```python
def fb(n: int) -> int:
    if n <= 1:
        return n
    else:
        return fb(n-1) + fb(n-2)
```
For fb5 the subproblem fb2 will be recalculated three times. The runtime complexity of such a solution is O(2^n). By using Dynamic Programming, we can optimize it. Generally speaking, we can apply dynamic programming if the problem has the following properties:
- Simple subproblems: we can break the global problems into subproblems
- Subproblem optimization: the optimal solution to the global problem is a composition of the optimal subproblems solutions
- Subproblem overlap: the solution to the global problem contains solutions for overlapping subproblems.   
  
Clearly, Fibonacci numbers problem has all these properties.  Here are four steps to deal with Dynamic Programming
- Design a recursive solution - [Top-Down](https://en.wikipedia.org/wiki/Top-down_and_bottom-up_design)
- Identify overlapping subproblems
- Use [memoization](https://en.wikipedia.org/wiki/Memoization) technique
- Design a [Bottom-Up](https://en.wikipedia.org/wiki/Top-down_and_bottom-up_design) solution 

## Text Compression and the Greedy Method

## Tries