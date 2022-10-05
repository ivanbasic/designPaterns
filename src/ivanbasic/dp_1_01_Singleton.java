package ivanbasic;

// https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm

//Step 1, Create a Singleton Class.
class SingleObject {

   //create an object of SingleObject
   private static SingleObject instance = new SingleObject()  ;

   //make the constructor private so that this class cannot be instantiated
   private SingleObject(){ System.out.println("Singleton object created." ); }

   //Get the only object available
   public static SingleObject getInstance(){
	  System.out.println("getInstance called" ); 
      return instance;
   }

   public void showMessage(){
      System.out.println("Hello World from Singleton");
   }
}

//Step 2 Get the only object from the singleton class.
public class dp_1_01_Singleton implements Demonstration {
   public   void demonstration() {

      //illegal construct
      //Compile Time Error: The constructor SingleObject() is not visible
      //SingleObject object = new SingleObject();

	  System.out.println("Singleton demo started");

      //Get the only object available
      SingleObject object = SingleObject.getInstance();

      //show the message
      object.showMessage();
 
      
      
   }
}