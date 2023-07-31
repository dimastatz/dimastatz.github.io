# Python Bitwise Operators

## Introduction
On low-cost processors, typically, bitwise operations are faster than division, several times faster than multiplication, and sometimes significantly faster than addition.

## Bitwise operation 
| Operator    | Description   | Example       |     
| :---------: | :-----------: | :-----------: |
| &           | AND           | 2 & 3 = 2     | 
| |           | OR            | 2 & 3 = 3     |
| ~           | NOT           | ~ 3 = -4      | 
| ^           | XOR           | 2 ^ 3 = 1     |
| >>          | Right shift   | 2 >> 1 = 1    |
| <<          | Left shift    | 3 << 1 = 6    |

## Bitwise add
```Python
def add(x, y):
    if y == 0:
        return x
    else:
        return add(x ^ y, (x & y) << 1)
```

## Bitwise subtract
```Python
def subtract(x, y):
    if y == 0:
        return x
    else:
        return subtract(x ^ y, ((~x) & y) << 1)
```

## Bitwise divide 
[TBD]

## Bitwise multiply
[TBD]
