package ivanbasic;

public class dp_1_02_Factory implements Demonstration {
    public void demonstration() {
        ConcreteCreator1 cc = new ConcreteCreator1();

        Product p11 = cc.FactoryMethod(1);
        Product p21 = cc.FactoryMethod(2);
        Product p31 = cc.FactoryMethod(3);

        ConcreteProduct1 p12 = (ConcreteProduct1) cc.FactoryMethod(1);
        ConcreteProduct2 p22 = (ConcreteProduct2) cc.FactoryMethod(2);
    }
}

// products
interface Product {}
class ConcreteProduct1 implements Product {}
class ConcreteProduct2 implements Product {}

// factories
interface Creator {
    public Product FactoryMethod(int ii);
}

class ConcreteCreator1 implements Creator {
    public Product FactoryMethod(int ii) {
        if (ii == 1) {
            System.out.println("Creating ConcreteProduct1");
            return new ConcreteProduct1();
        }
        if (ii == 2) {
            System.out.println("Creating ConcreteProduct2");
            return new ConcreteProduct2();
        }

        System.out.println("Creating nothing");
        return null;
    }
}