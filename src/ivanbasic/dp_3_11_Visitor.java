package ivanbasic;

// ivan basic, 11.10.2017 Visitor(s) and Element(s)

// -----------------------------------------------------------------
interface Element {
    void accept(Visitor visitor);
}

class Aplle implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Banana implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// -----------------------------------------------------------------
interface Visitor {
    void visit(Element element);
}

class Sun implements Visitor {
    public void visit(Element element) {
        System.out.println("Visitor=Sun, element=" + element);
    }
}

class Rain implements Visitor {
    public void visit(Element element) {
        System.out.println("Visitor=Rain, element=" + element);
    }
}

public class dp_3_11_Visitor implements Demonstration {
    public void demonstration() {
        Element aplle = new Aplle();
        Element banana = new Banana();

        Visitor sun = new Sun();
        Visitor rain = new Rain();

        aplle.accept(sun);
        aplle.accept(rain);

        banana.accept(sun);
        banana.accept(rain);
        banana.accept(rain);

    }
}
