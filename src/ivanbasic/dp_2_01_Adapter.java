package ivanbasic;

public class dp_2_01_Adapter implements Demonstration {
    public void demonstration() {

        // wrong !
		// program to interfaces, not implementations
		/*
		T1 t1 = new T1();
		T2 t2 = new T2();
		T3 t3 = new T3();		
		Adapter aa = new Adapter();
		*/

        Target t1 = new T1();
        Target t2 = new T2();
        Target t3 = new T3();
        Target aa = new Adapter();

        t1.request();
        t2.request();
        t3.request();
        aa.request();


    }
}

//interface
interface Target {
    void request();
}

//classes implement target interface without problem.
class T1 implements Target {
    public void request() {
        System.out.println("REQUEST from T1");
    }
}

class T2 implements Target {
    public void request() {
        System.out.println("REQUEST from T2");
    }
}

class T3 implements Target {
    public void request() {
        System.out.println("REQUEST from T3");
    }
}


// problematic old class. We don't wont to touch it.
class Adaptee {
    public void specificRequest() {
        System.out.println("SPECIFIC REQUEST from Adaptee");
    }
}

// Adapter. implements target  without changing problematic class
class Adapter implements Target {
    Adaptee ee;

    Adapter() {
        ee = new Adaptee();
    }

    //implemented method
    public void request() {
        ee.specificRequest();
    }

}

