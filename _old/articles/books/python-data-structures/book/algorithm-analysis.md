# Algorithm Analysis  

## Introduction
We want to write fast and memory-efficient software programs that solve engineering and business problems. But how can we measure the efficiency of the implementation? Let's say we have two programs A and B, that compute a [Fibonacci Number](https://en.wikipedia.org/wiki/Fibonacci_number), and we want to compare A and B from the run-time performance perspective. The simple approach is to gather experimental data by using the Python built-in time function:

```Python
from time import time, sleep
start_time = time()                  
# run algorithm
end_time = time()                    
elapsed = end_time - start_time 
``` 
The elapsed time is a decent representation of the efficiency, but it is dependent on the specific input, machine type, number of running processes, amount of free memory, etc. We need a method to measure the implementation efficiency without being dependent on specific hardware and input.  

##  Beyond Experimental Analysis
First, we define two terms - Data Structure and Algorithm. Simply put, a [Data Structure](https://en.wikipedia.org/wiki/Data_structure) is a way of organizing and accessing data in computer memory, and an [Algorithm](https://en.wikipedia.org/wiki/Algorithm) is a step-by-step procedure for performing some task. To analyze the running time of an algorithm without performing experiments, we perform analysis directly on a description of the algorithm by counting primitive operations like assigning a variable, performing an arithmetic operation, comparing, etc. To capture the order of growth of an algorithm's running time, we will associate, with each algorithm, a function f(n) that characterizes the number of primitive operations that are performed as a function of the input size n.

## The Seven Functions
The seven important functions for the algorithm analysis:
- The Constant Function: <em>f(n) = c</em>
- The Logarithm Function: <em>f(n) = log<sub>2</sub>n</em>
- The Linear Function: <em>f(n) = n</em>
- The N-Log-N Function: <em>f(n) = nlog<sub>2</sub>n</em>
- The Quadratic Function: <em>f(n) = n<sup>2</sup></em>
- The Polynomial Function: <em>f(n) = a + a<sub>2</sub>n<sup>2</sup> + a<sub>3</sub>n<sup>3</sup> +...+ a<sub>d</sub>n<sup>d</sup></em>
- The Exponential Function: <em>f(n) = b<sup>n</sup></em>

##  Big O Notation
The big-Oh notation allows us to say that a function f(n) is less than or equal to function g(n). For example, we can say that f(n) is O(g(n)) or f(n) is order of g(n).
The big-Oh notation is used widely to characterize running times and space bounds in terms of some parameter n.
For example, for the following code 
```python
def find_max(lst: list) -> int:
    biggest = lst[0]
    for x in lst:
        if x > biggest:
            biggest = x  
    return biggest
```
The algorithm 'find-max' runs in O(n) time.

## Simple Justification Techniques
Sometimes, we will want to make claims about an algorithm, such as showing that it is correct or that it runs fast. In math and logic, we have several justification techniques.
- [Deduction](https://en.wikipedia.org/wiki/Deduction_and_induction) is a top-down technique when we move from the common to the specific case. <em>All fruits are tasty. Apple is fruit. Apple is tasty</em> 
- [Induction](https://en.wikipedia.org/wiki/Deduction_and_induction) is the opposite of induction. We move from the down to the top by starting with the specific case and moving to the common. Specifically, we begin a justification by induction by showing that q(n) is true for n = 1 (and possibly some other values n = 2, 3,. . ., k, for some constant k). Then we justify that the inductive “step” is true for n > k, namely, we show “if q(j) is true for all j < n, then q(n) is true.”.
- [Loop Invariants](https://en.wikipedia.org/wiki/Loop_invariant). The final justification technique we discuss in this section is the loop invariant. To prove some statement L about a loop is correct, define L in terms of a series of smaller statements L0, L1, . . ., Lk, where:
    - The initial claim, L0, is true before the loop begins.
    - If Lj−1 is true before iteration j, then Lj will be true after iteration j.
    - The final statement, Lk, implies the desired statement L to be true.
- Counterexample. By using a specific example, we cannot prove that some claim is true. But we can use example to show that some rule is false. For example, the claim "every number of the form 2<sup>i</sup> − 1 is a prime, when i is an integer greater than 1" is false because 2<sup>4</sup> − 1 = 15 = 3 * 5.
- The “Contra” Attack. 
    - [Contradiciton](https://en.wikipedia.org/wiki/Proof_by_contradiction). We establish that a statement q is true by first supposing that q is false and then showing that this assumption leads to a contradiction (such as 2 ≠ 2 or 1 > 3).
    - [Contraposition](https://en.wikipedia.org/wiki/Contraposition). To justify the statement “if p is true, then q is true,” we establish that “if q is not true, then p is not true” instead. Logically, these two statements are the same, but the latter, which is called the contrapositive of the first, may be easier to think about. For example, the claim "Let a and b be integers. If ab is even, then a is even or b is even". To justify this claim, consider the contrapositive, “If a is odd and b is odd, then ab is odd.” 

## Example Loop Invariants
TBD
