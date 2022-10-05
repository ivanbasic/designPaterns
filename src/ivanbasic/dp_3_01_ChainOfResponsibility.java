package ivanbasic;

// In the following usage example, the successors are set as follows:
// Manager -> Director -> Vice President -> President
public class dp_3_01_ChainOfResponsibility implements Demonstration {

    public void demonstration() {

        PurchasePower manager = new ManagerPPower();
        PurchasePower director = new DirectorPPower();
        PurchasePower visePresident = new VicePresidentPPower();
        PurchasePower president = new PresidentPPower();

        manager.setSuccessor(director);
        director.setSuccessor(visePresident);
        visePresident.setSuccessor(president);

        for (int ii = 1; ii <= 80; ii += 10) {
            System.out.println("\nREQUEST $" + ii);

            manager.processRequest(new PurchaseRequest(ii, "General"));
        }


    }
}

abstract class PurchasePower {
    protected static final double BASE = 1;
    protected PurchasePower successor;

    abstract protected double getAllowable();

    abstract protected String getRole();

    public void setSuccessor(PurchasePower successor) {
        this.successor = successor;
    }

    //the main engine, I think.
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < this.getAllowable()) {
            System.out.println(this.getRole() + " will approve $" + request.getAmount());
        } else if (successor != null) {
            System.out.println(this.getRole() + " will NOT approve this. Forward to successor.");
            successor.processRequest(request);
        } else {
            System.out.println("Nobody will approve $" + request.getAmount());
        }
    }
}


//Four implementations of the abstract class above: Manager, Director, Vice President, President
class ManagerPPower extends PurchasePower {
    protected double getAllowable() {
        return BASE * 10;
    }

    protected String getRole() {
        return "Manager";
    }
}

class DirectorPPower extends PurchasePower {
    protected double getAllowable() {
        return BASE * 20;
    }

    protected String getRole() {
        return "Director";
    }
}

class VicePresidentPPower extends PurchasePower {
    protected double getAllowable() {
        return BASE * 40;
    }

    protected String getRole() {
        return "Vice President";
    }
}

class PresidentPPower extends PurchasePower {
    protected double getAllowable() {
        return BASE * 60;
    }

    protected String getRole() {
        return "President";
    }
}

//The following code defines the PurchaseRequest class that keeps the request data in this example.
class PurchaseRequest {

    private double amount;
    private String purpose;

    public PurchaseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}


