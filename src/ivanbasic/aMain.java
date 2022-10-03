package ivanbasic;

import java.util.Set;

public class aMain {
    final static int CHOOSE_DEMO_ORDINAL = 0;   //zero for all

    public static void main(final String[] dummy) {
        callAllDemosUsingReflection(CHOOSE_DEMO_ORDINAL);
    }

    public static void callAllDemosUsingReflection(final int demoOrdinal) {

        System.out.println("Design Patterns, DEMOs, dynamic call (reflection)");
        final Set<Class> classes = new AccessingAllClassesInPackage().findAllClassesUsingClassLoader("ivanbasic");
        int demoCounter = 1;

        for (final Class aClass : classes) {
            try {
                Object objDemo = Class.forName(aClass.getName()).getConstructor().newInstance();
                dp_Demo dp_demo = (dp_Demo) objDemo;
                if (demoOrdinal == 0 || demoOrdinal == demoCounter) {
                    dp_demo.demoHeaderAndMain(demoCounter);
                }
                demoCounter++;
            } catch (final Exception e) {
                // not instance of demo
            }
        }
    }

}

interface dp_Demo {
    void main(String[] args);

    default void demoHeaderAndMain(int demoCounter) {
        String className = this.getClass().getName()
                .replace("ivanbasic.dp_", "")
                .replace("_", ".");

        System.out.println("");
        System.out.println("===============================================================");
        System.out.println("Demo#" + demoCounter + " " + className);
        System.out.println("===============================================================");

        this.main(null);
    }

}

