package ivanbasic;

public class dp_1_03_AbstractFactory implements dp_Demo {
    public void main(String[] args) {

        InterfaceAbstractFactory interfaceAbstractFactory;

        interfaceAbstractFactory = new ConcreteFactory1();
        interfaceAbstractFactory.createProductA();
        interfaceAbstractFactory.createProductB();
        interfaceAbstractFactory.createProductC();

        interfaceAbstractFactory = new ConcreteFactory2();
        interfaceAbstractFactory.createProductA();
        interfaceAbstractFactory.createProductB();
        interfaceAbstractFactory.createProductC();

    }
}

// List of product's:  A,B,C.
interface AbstractProductA {}
interface AbstractProductB {}
interface AbstractProductC {}

// AbstractFactory
interface InterfaceAbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
    AbstractProductC createProductC();
}


//Factory 1
class ConcreteFactory1 implements InterfaceAbstractFactory {

    ConcreteFactory1() {
        System.out.println("Creating Factory 1");
    }

    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    public AbstractProductB createProductB() {
        return new ProductB1();
    }

    public AbstractProductC createProductC() {
        return new ProductC1();
    }
}

// product implementations for Factory 1
class ProductA1 implements AbstractProductA {
    ProductA1() {
        System.out.println("a Windows button");
    }
}

class ProductB1 implements AbstractProductB {
    ProductB1() {
        System.out.println("a Windows scroll");
    }
}

class ProductC1 implements AbstractProductC {
    ProductC1() {
        System.out.println("a Windows panel");
    }
}


//Factory 2
class ConcreteFactory2 implements InterfaceAbstractFactory {
    ConcreteFactory2() {
        System.out.println("Creating Factory 2");
    }

    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    public AbstractProductB createProductB() {
        return new ProductB2();
    }

    public AbstractProductC createProductC() {
        System.out.println("There is no a Linux panel");
        return null;
    }
}

// product implementations for Factory 2
class ProductA2 implements AbstractProductA {
    ProductA2() {
        System.out.println("a Linux button");
    }
}

class ProductB2 implements AbstractProductB {
    ProductB2() {
        System.out.println("a Linux scroll");
    }
}

 