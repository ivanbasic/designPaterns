package ivanbasic;

import java.util.List;

public class aMain {
    final static int CHOOSE_DEMO_ORDINAL = 0; // Zero for all

    public static void main(final String[] args) {
        callAllDemosUsingReflection(CHOOSE_DEMO_ORDINAL);
    }

    public static void callAllDemosUsingReflection(final int demoOrdinal) {
        System.out.println("JAVA DESIGN PATTERNS");
        final List<String> classes = new AccessingAllClassesInPackage().getClassNamesSorted("ivanbasic");
        int demoCounter = 1;

        for (final String className : classes) {
            try {
                Object objDemo = Class.forName(className).getConstructor().newInstance();
                Demonstration demo = (Demonstration) objDemo;
                if (demoOrdinal == 0 || demoOrdinal == demoCounter) {
                    demo.HeaderAndDemonstration(demoCounter);
                }
                demoCounter++;
            } catch (final Exception e) {
                // the current class is not the instance of demo interface
            }
        }
    }

}

interface Demonstration {
    void demonstration();

    default void HeaderAndDemonstration(int demoCounter) {
        String className = this.getClass().getName().replace("ivanbasic.dp_", "").replace("_", ".");

        System.out.println("");
        System.out.println("===============================================================");
        System.out.println("Demo#" + demoCounter + " " + className);
        System.out.println("===============================================================");

        this.demonstration();
    }

}
