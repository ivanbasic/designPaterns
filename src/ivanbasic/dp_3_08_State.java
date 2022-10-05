package ivanbasic;

public class dp_3_08_State implements Demonstration {
    public void demonstration() {

        Context context = new Context(new StateGreen(), "the Rest of the data");
        context.ChangeState(new StateBlue());
        context.ChangeState(new StateRed());
    }
}


class Context {
    private State state;
    private String theRestOfTheData;

    Context(State st, String ss) {
		System.out.println("Constructor, setting the state and the rest of the data.");
        ChangeState(st);
        theRestOfTheData = ss;
    }

    void ChangeState(State st) {
        this.state = st;

        System.out.println();
        System.out.println("For current state, the operations are:");
        Operation1();
        Operation2();
        Operation3();

    }

    public void Operation1() { state.Operation1(); };
    public void Operation2() { state.Operation2(); };
    public void Operation3() { state.Operation3(); };
}


interface State {
    void Operation1();
    void Operation2();
    void Operation3();
}

class StateBlue implements State {
    public void Operation1() { System.out.println("StateBlue 1"); };
    public void Operation2() { System.out.println("StateBlue 2"); };
    public void Operation3() { System.out.println("StateBlue 3"); };
}

class StateRed implements State {
    public void Operation1() { System.out.println("StateRed 1"); };
    public void Operation2() { System.out.println("StateRed 2"); };
    public void Operation3() { System.out.println("StateRed 3"); };
}

class StateGreen implements State {
    public void Operation1() { System.out.println("StateGreen 1"); };
    public void Operation2() { System.out.println("StateGreen 2"); };
    public void Operation3() { System.out.println("StateGreen 3"); };
}

	
