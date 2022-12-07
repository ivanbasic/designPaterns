package ivanbasic;

public class dp_1_04_BodyBuilder implements Demonstration {
    public void demonstration() {
        Body body1 = Body.builder("extraABS")
                .arms("extraARMS")
                .legs("extraLEGS")
                .shoulders("extraSHOULDERS")
                .build();

        Body body2 = Body.builder("extraABS!")
                .build();

        // TODO: hm. should not be null?
        Body body3 = Body.builder(null)
                .build();

        System.out.println("body1=" + body1);
        System.out.println("body2=" + body2);
        System.out.println("body3=" + body3);

    }
}

//target class to build
class Body {
    //required
    private String abs;
    //optional
    private String legs;
    private String arms;
    private String shoulders;

    //a very elegant (and hidden) constructor, just one parameter.
    private Body(BodyBuilder builder) {
        this.abs = builder.abs;
        this.legs = builder.legs;
        this.arms = builder.arms;
        this.shoulders = builder.shoulders;
    }

    //a public method which START a build process.
    public static BodyBuilder builder(String abs) {
        return new BodyBuilder(abs);
    }

    public String toString() {
        return abs + " " + legs + " " + arms + " " + shoulders;
    }

    //inner builder-class
    static class BodyBuilder {
        //required
        private final String abs;
        //optional
        private String legs;
        private String arms;
        private String shoulders;

        //required = constructor
        public BodyBuilder(String abs) {
            this.abs = abs;
        }

        //optional= setters
        public BodyBuilder legs(String legs) {
            this.legs = legs;
            return this;
        }
        public BodyBuilder arms(String arms) {
            this.arms = arms;
            return this;
        }
        public BodyBuilder shoulders(String shoulders) {
            this.shoulders = shoulders;
            return this;
        }

        //the END of process, build!
        public Body build() {
            return new Body(this);
        }

    }

}

