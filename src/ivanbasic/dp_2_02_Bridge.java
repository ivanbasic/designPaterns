package ivanbasic;

import java.util.List;

// BRIDGE
// Decouple an abstraction from its implementation so that the two can vary independently

public class dp_2_02_Bridge implements dp_Demo {
    public void main(String[] args) {
        List<Abstraction> abstractions =
                List.of(
                        new RefinedAbstractionI(new ConcreteImplementorA()),
                        new RefinedAbstractionI(new ConcreteImplementorB()),
                        new RefinedAbstractionI(new ConcreteImplementorC()),

                        new RefinedAbstractionJ(new ConcreteImplementorA()),
                        new RefinedAbstractionJ(new ConcreteImplementorB()),
                        new RefinedAbstractionJ(new ConcreteImplementorC())
                );

        System.out.println("Number of abstractions: "+abstractions.size() );
    }
}

// ABSTRACTION
abstract class Abstraction {
    Implementor impl;

    Abstraction(Implementor impl) {
        this.impl = impl;
        System.out.println("New: " + operation());
    }

    abstract String operation();

}

class RefinedAbstractionI extends Abstraction {

    RefinedAbstractionI(Implementor impl) {
        super(impl);
    }

    String operation() {
        return "RefinedAbstractionI " + this.impl.operationImp();
    }
}

class RefinedAbstractionJ extends Abstraction {
    RefinedAbstractionJ(Implementor impl) {
        super(impl);
    }

    String operation() {
        return "RefinedAbstractionJ " + this.impl.operationImp();
    }

}

// IMPLEMENTATION
interface Implementor {
    String operationImp();
}

class ConcreteImplementorA implements Implementor {
    public String operationImp() {
        return "ConcreteImplementorA";
    }
}

class ConcreteImplementorB implements Implementor {
    public String operationImp() {
        return "ConcreteImplementorB";
    }
}

class ConcreteImplementorC implements Implementor {
    public String operationImp() {
        return "ConcreteImplementorC";
    }
}
