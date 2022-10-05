package ivanbasic;

public class dp_3_10_Template implements Demonstration {
	public void demonstration() {

		Template t1= new NiceTemplate();
		t1.templateMethod();

		Template t2= new BadTemplate();
		t2.templateMethod();		
		
	}
}

// AbstractClass
interface Template {
	
	// defines abstract primitive operations
	void measure();
	void cut();
	void eat(); 		
 
	
	// implements a template method defining the skeleton of an algorithm	
	default void templateMethod() {
		System.out.println("\n>>Measure 3 times, cut once<< template implemented");
		for (int ii=0; ii<3; ii++  )  
			measure();
		cut();
		eat();
	}
}


// ConcreteClass 1 implements the primitive operations
class NiceTemplate implements Template {
	public void measure() { System.out.println("measure");	}
	public void cut() {
		System.out.println("cut");		
	}
	public void eat() {
		System.out.println("eat");		
	}
}

// Concrete Class 2 implements the primitive operations
class BadTemplate implements Template {
	public void measure() {	}
	public void cut() {	}
	public void eat() {
		System.out.println("just eat");		
	}
}


