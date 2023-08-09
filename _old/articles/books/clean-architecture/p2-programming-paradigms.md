# Starting with the Bricks: Programming Paradigms

## Paradigm Overview
The idea behind any programming paradigm is to simplify the creation of software programs. For example, structure programming introduces if/then/else and do/while/until instead of [GOTO](https://en.wikipedia.org/wiki/Goto) statement to simplify the flow control in software programs. 
Programming Paradigm imposes certain rules on the software programs structure. 

## Structured Programming
<em>The Structured Programming paradigm imposes discipline on a direct transfer of control.</em>  

Any program can be constructed from three simple structures:
    - Sequence: describes the program flow step by step
    - Selection: creates branches in the flow by using if/then/else
    - Iteration: repeats any sequences multiple times by using do/while/until

Importance: this paradigm is important in Software Architecture, because on every level, from small piece of code to the large component we strive to create testable units. 


## Object-Oriented Programming
Object-Oriented Programming imposes discipline on indirect transfer of control.

Importance: the unique characteristic of the OO is the ability to create plugin Architecture by using inversion of control.


## Functional Programming
<em>The Functional Programming paradigm imposes discipline upon assignment.</em>

All race conditions, deadlocks, and concurrent update problems are due to mutable variables. The Functional Programming paradigm solves it by forcing immutable variables and pure functions. 

Importance: this paradigm is important when working on Architecture of Distributed Systems.  
