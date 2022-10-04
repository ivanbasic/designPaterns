package ivanbasic;

public class dp_2_04_Decorator implements dp_Demo {
    public void main(String[] args) {

        Decorator d1 = new DecoratedComponent1(new C1());
        d1.operation();

        Decorator d2 = new DecoratedComponent2(new C2());
        d2.operation();

    }
}

interface MyComponent {
    void operation();
}

class C1 implements MyComponent {
    public void operation() {
        System.out.println("op 1");
    }
}

class C2 implements MyComponent {
    public void operation() {
        System.out.println("op 2");
    }
}


// Gang of 4 about  Decorator: 
// a) maintains a reference to a Component object and 
// b) defines an interface that conforms to Component's interface.

//b
class Decorator implements MyComponent {
    //a)
    protected MyComponent com;

    public Decorator(MyComponent xCom) {
        this.com = xCom;
    }

    public void operation() {
        com.operation();
    }

}

class DecoratedComponent1 extends Decorator {
    public DecoratedComponent1(MyComponent xCom) {
        super(xCom);
    }

    String addedState;
}

class DecoratedComponent2 extends Decorator {
    public DecoratedComponent2(MyComponent xCom) {
        super(xCom);
    }

    public void operation() {
        com.operation();
    }

    public void addedBehavior() {
        System.out.println("added behavior");
    }
}

