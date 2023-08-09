# Recursion

## Introduction
Let f(x) be a function that is defined in the following way: f(x) = { x + f(x-1) if x > 0; 1 if x <= 0 }. Actually, f(x) is applied as part of its own definition. We call to such function a recursive function. In computer since, such functions are very usefull to describe a repetition. For example, see a Python implementation of the Factorial Function:

```python
def factorial(n: int) -> int:
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)
```

## When To Use Recursion
Can we replace any recursive algorithm by its iterative equivalent? [Yes](https://stackoverflow.com/questions/931762/can-every-recursion-be-converted-into-iteration). Is a recursive solution is more expensive than an iterative approach? [Depends](https://www.quora.com/Is-recursion-faster-than-loops). In general-purpose languages like Java, Python, C++, recursive functions are usually slower. So when to use a recursive solution? Recursions are more expressive, usually provide a cleaner solution with less code. In addition, recursive solutions can be parallelized on multicore machines.   

## Binary Search
A classic recursive algorithm is Binary-Search. Binary-Search is used to efficiently locate a target value within a sorted sequence of n elements.
```python
def binary_search(data: list, target: int, low: int, high: int) -> bool:
    if low > high:
        return False
    else:
        mid = (high + low) // 2
        if data[mid] == target:
            return True
        elif:
            if target < data[mid]:
                return binary_search(data, target, low, mid - 1)
            else:
                return binary_search(data, target, mid + 1, high)

```
We observe that a constant number of primitive operations are executed at each recursive call of a Binary-Search. Hence, the running time is proportional to the number of recursive calls performed - log<sub>2</sub>n

