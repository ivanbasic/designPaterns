by Ivan Basic
15.08.2017
03.10.2022

Re-writing original design patterns by Gang of Four using Java 11
I have always tried to create all the examples on my own.
If that is not the case, I used "other references" below for help.

Reference:
    Design Patterns, Elements of Reusable Object-Oriented Software by Gang of Four
    https://en.wikipedia.org/wiki/Design_Patterns
Other References:
    https://en.wikipedia.org/wiki/Software_design_pattern
    https://www.tutorialspoint.com/design_pattern/
    https://sourcemaking.com/design_patterns
    https://www.javatpoint.com/design-patterns-in-java
Other other:
    https://www.baeldung.com/java-find-all-classes-in-package

Manual:
1 Open README.txt (this file, list of the all design patterns)
2 Open CONSOLE.txt (console output, logs for all the demos)
3 Open any dp_X_Y_name.java example (all classes for one demo in one file)


JAVA DESIGN PATTERNS:

1    CREATIONAL
1.01 singleton        - Ensure a class only has one instance
1.02 Factory Pattern  - Define an interface for creating an object
                        Product, ConcreteProduct; Creator, ConcreteCreator, FactoryMethod()
1.03 Abstract Factory - Provide an interface for creating family of related  objects
                        AbstractFactory createA(),B(), ConcreteFactory1 , ConcreteFactory2;
                        AbstractProductA, ProductA1, ProductA2;
                        AbstractProductB, ProductB1, ProductB2
1.04 Builder Pattern  - Separate the construction of a complex object from its representation
                        a Director Construct(); Builder BuildPart(); ConcreteBuilder; Product
                        b Product, iner class ProductBuilder build()
1.05 Prototype        - Clone
                        interface Prototype {  Prototype  clone(); }


2    STRUCTURAL
2.01 Adapter          - Adapting an interface into another according to client expectation.
                        Target request(), T1,T2,T3 Adapter<>----Adaptee;
2.02 Bridge           - Decouple an abstraction from its implementation so that the two can vary independently.
                        Abstraction oper(){impl.operImp } A1,A2... ;     <>--- Implementor I1,I2...;
2.03 Composite        - Allowing clients to operate on hierarchy of objects.
2.04 Decorator        - Adding functionality to an object dynamically.
2.05 Facade           - Providing an interface to a set of interfaces.
2.06 Flyweight        - Reusing an object by sharing it.
2.07 proxy            - Representing another object.

3    BEHAVIORAL
3.01 Chain of Resp    - tree of responsibility
3.02 Command          - interface Command
3.03 Interpreter      - EBNF
3.04 Iterator         - for each
3.05 Mediator         - set of objects Colleague send() receive(), Mediator sendToAll()
3.06 Memento          - save and restore object's state
3.07 Observer         - Subject and its Observer's
3.08 State            - Allow an object to alter its behavior when its internal state changes
                        Context <>---interface state, state.operation's()
3.09 Strategy         - Context,<>---interface strategy.operation()
3.10 Template Method  - abstract class, skeleton of an algorithm
3.11 Visitor          - Visitor(s) and Element(s)