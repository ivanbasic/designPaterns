package ivanbasic;

public class dp_3_09_Strategy implements Demonstration {
	public void demonstration() {
		
		aContext con = new aContext( new Walk() );
		con.executeStrategy();
 
		con.changeStrategy( new Run());
		con.executeStrategy();		
		con.executeStrategy();		
		
		con.changeStrategy( new Fly());		
		con.executeStrategy();
		con.executeStrategy();
		con.executeStrategy();
		
	}

}

class aContext {
	private aStrategy aSt;

	aContext(aStrategy aSt) {
		System.out.println("aContext constructor");
		changeStrategy(aSt);
	}

	void changeStrategy(aStrategy aSt) {
		System.out.println("\nchange strategy to "+aSt);		
		this.aSt = aSt;
	}

	void executeStrategy() {
		aSt.operation();
	}

}

interface aStrategy {
	void operation();
}

class Walk implements aStrategy {
	public void operation() {
		System.out.println("Walk");
	}
}

class Run implements aStrategy {
	public void operation() {
		System.out.println("Run");
	}
}

class Fly implements aStrategy {
	public void operation() {
		System.out.println("Fly");
	}
}