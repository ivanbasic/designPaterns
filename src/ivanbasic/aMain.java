package ivanbasic;

import java.util.List;

public class aMain {
    final static int CHOOSE_DEMO_ORDINAL = 0; // Zero for all

    public static void main(final String[] dummy) {
        callAllDemosUsingReflection(CHOOSE_DEMO_ORDINAL);
    }


    public static void callAllDemosUsingReflection(final int demoOrdinal) {

        System.out.println("Design Patterns, DEMOs, dynamic call using reflection");
        final List<String> classes = new AccessingAllClassesInPackage().getClassNamesSorted("ivanbasic");
        int demoCounter = 1;

        for (final String className : classes) {
            try {
                Object objDemo = Class.forName( className).getConstructor().newInstance();
                dp_Demo dp_demo = (dp_Demo) objDemo;
                if (demoOrdinal == 0 || demoOrdinal == demoCounter) {
                    dp_demo.HeaderAndMain(demoCounter);
                }
                demoCounter++;
            } catch (final Exception e) {
                // the current class is not the instance of demo interface
            }
        }
    }

}

interface dp_Demo {
    void main(String[] args);

    default void HeaderAndMain(int demoCounter) {
        String className = this.getClass().getName().replace("ivanbasic.dp_", "").replace("_", ".");

        System.out.println("");
        System.out.println("===============================================================");
        System.out.println("Demo#" + demoCounter + " " + className);
        System.out.println("===============================================================");

        this.main(null);
    }

}
