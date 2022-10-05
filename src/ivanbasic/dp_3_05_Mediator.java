package ivanbasic;

import java.util.ArrayList;

public class dp_3_05_Mediator implements dp_Demo {
    public void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Colleague alice = new ConcreteColleague(mediator, "Alice");
        Colleague bob = new ConcreteColleague(mediator, "Bob");
        Colleague cindy = new ConcreteColleague(mediator, "Cindy");

        alice.send("Hello");
        bob.send("Hi");
        cindy.send("Good Morning");
    }
}

interface Mediator {
    void sendToAll(String message, Colleague sender);
    void add(Colleague cc);
}

class ConcreteMediator implements Mediator {
    private ArrayList<Colleague> colleagues = new ArrayList();

    public void add(Colleague cc) {
        this.colleagues.add(cc);
    }

    public void sendToAll(String message, Colleague sender) {
        System.out.println("\nMessage from " + sender.name);
        for (Colleague cc : colleagues) {
            if (cc != sender) {
                cc.receive(message);
            }
        }
    }
}

abstract class Colleague {
    String name;
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
    abstract void send(String message);
    abstract void receive(String message);
}

class ConcreteColleague extends Colleague {
    ConcreteColleague(Mediator mm, String name) {
        super(mm);
        this.name = name;
        this.getMediator().add(this);

    }

    void send(String message) {
        this.getMediator().sendToAll(message, this);
    }
    void receive(String message) {
        System.out.println(this.name + "  received message: " + message);
    }

}

