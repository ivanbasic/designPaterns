package ivanbasic;

public class dp_1_05_Prototype implements dp_Demo {
    public void main(String[] args) {
        System.out.println("Prototype demo ");

        Prototype p1 = new Person("Smith");
        Prototype p2 = p1.clone();

        System.out.println("Original person: "+p1);
        System.out.println("Cloned person: "+p2);

    }

}


interface Prototype {
    Prototype clone();
}

class Person implements Prototype {
    public String name;

    Person(String name) {
        this.name = name;
    }


    public Prototype clone() {
        return new Person(this.name);
    }

    public String toString() {
        return "This person is named " + name;
    }
}
	
	
 



