/*
Intent
Compose objects into tree structures to represent part-whole hierarchies. 
Composite lets clients treat individual objects and compositions of objects uniformly.  

Participants
• Component (Graphic)
- declares the interface for objects in the composition.
- implements default behavior for the interface common to all classes, as appropriate.
- declares an interface for accessing and managing its child components.
- (optional) defines an interface for accessing a component's parent in the recursive structure, and implements it if that's appropriate.

• Leaf (Rectangle, Line, Text, etc)
- represents leaf objects in the composition.A leaf has no children.
- defines behavior for primitive objects in the composition.

• Composite (Picture)
- defines behavior for components having children.
- stores child components.
- implements child-related operations in the Component interface

*/

package ivanbasic;

import java.util.ArrayList;
import java.util.List;

public class dp_2_03_Composite implements dp_Demo {
    public void main(String[] args) {

        Graphic rectangle1 = new Rectangle("1,1", "5");
        Graphic rectangle2 = new Rectangle("2,2", "10");
        Graphic rectangle3 = new Rectangle("3,3", "15");
        Graphic rectangle4 = new Rectangle("4,4", "20");
        Graphic rectangle5 = new Rectangle("5,5", "25");
        Graphic rectangle6 = new Rectangle("6,6", "30");

        Graphic line1 = new Line("10,10", "100,10");
        Graphic line2 = new Line("20,10", "200,10");
        Graphic line3 = new Line("30,10", "300,10");
        Graphic line4 = new Line("40,10", "400,10");

        Graphic text1 = new Text("a cat");
        Graphic text2 = new Text("a dog");
        Graphic text3 = new Text("a flower");
        Graphic text4 = new Text("the end");

        Graphic picture1 = new Picture("the Hole Picture #1");
        Graphic picture2 = new Picture("the Picture of the components #2");
        Graphic picture3 = new Picture("the Picture of the components #3");
        Graphic picture4 = new Picture("the Picture of the components #4");

        picture2.add(rectangle1, rectangle2, rectangle3, line1, line2);
        picture3.add(rectangle4, rectangle5, rectangle6, line3, line4);
        picture4.add(text1, text2, text3, picture3);
        picture1.add(picture2, picture4, text4);

        picture1.draw(0);

    }

}

interface Graphic {
    void draw(int level);

    // to show my knowledge of Variable Arguments (Varargs) in Java
    // and that I know to use default in an interface
    default void add(Graphic... graphics) {
    }


    //to show hierarchy. lower level goes more to the right.
    default String repeatedBlank(int level) {
        // java 06? return new String(new char[level]).replace("\0", "    ");
        // java 11: ". ".repeat( 7 )  <=> Seven period-with-space pairs: . . . . . . .

        return " ".repeat(level * 4);
    }
}

class Rectangle implements Graphic {
    private String position;
    private String size;

    public Rectangle(String pp, String ss) {
        this.size = ss;
        this.position = pp;
    }

    public void draw(int level) {
        System.out.println(repeatedBlank(level) + "Rectangle. position " + position + " size " + size);
    }
}

class Line implements Graphic {
    private String pointA;
    private String pointB;

    public Line(String aa, String bb) {
        this.pointA = aa;
        this.pointB = bb;
    }

    public void draw(int level) {
        System.out.println(repeatedBlank(level) + "Line. from " + pointA + " to " + pointB);
    }
}

class Text implements Graphic {
    private String text;

    public Text(String tt) {
        this.text = tt;

    }

    public void draw(int level) {
        System.out.println(repeatedBlank(level) + "Text. " + text);
    }

}


class Picture implements Graphic {
    private String name;
    private List<Graphic> children = new ArrayList<Graphic>();

    public Picture(String ss) {
        this.name = ss;
    }

    public void draw(int level) {
        System.out.println(repeatedBlank(level) + "Composite. " + name + ". Number of children: " + children.size());
        for (Graphic ch : children) {
            ch.draw(level + 1);
        }

    }


    public void add(Graphic... graphics) {
        for (Graphic grafic : graphics) {
            children.add(grafic);
        }
    }

}
