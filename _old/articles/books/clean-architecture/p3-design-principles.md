# Design Principles
The SOLID principles tell us how to arrange data and functions into classes. Here classes are not necessarily OOP classes. Here, class is simply a grouping of data and functions, for example it can be module.  

## The Single Responsibility Principle
The Single Responsibility Principle tells us that any class is responsible for one actor only. For example if we have an Employee class with two methods: create() and calculate_salary(), and we have an HR actor that uses create() method and an CFO actor that uses calculate_salary() method, than Employee class is clear violation of the Single Responsibility Principle. 
The idea behind SRP is that different actors have different flows. And it is likely that different actors will require the change of the same class for different reasons. 

## The Open-Closed Principle
The main idea behind the Open-Closed Principle is that any software artifact should be open for extension but closed for modification. For example, think about a system that loads shops data from the file and shows shops on the Map. Now we have to support a Table View, where all shops are shown as a list of names and addresses. 
The essential insight here is that it is a good idea to separate responsibilities: the loading the data from the file data, and the presentation of that data into different views.

## The Liskov Substitution Principle
The LSP principle defines that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application. Think about [strategy pattern](https://en.wikipedia.org/wiki/Strategy_pattern).

## The Interface Segregation Principle
The ISP principle defines that states that a client should not be exposed to methods it doesn't need. In such cases in statically typed languages like Java we should introduce a new interface which contains only required subset of methods
<em>Depending on something that carries baggage that you don’t need can cause you troubles that you didn’t expect</em>

## The Dependency Inversion Principle
The Dependency Inversion Principle (DIP) tells us that the most flexible systems are those in which source code dependencies refer only to abstractions, not to concretions.
In a statically typed language, like Java, this means that the use, import, and include statements should refer only to source modules containing interfaces, abstract classes, or some other kind of abstract declaration