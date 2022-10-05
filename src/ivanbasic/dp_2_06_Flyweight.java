/*

I changed a little bit original gang of 4 example, using example from "Known Uses"
Known Uses...document editor called Doc...hence a character's intrinsic state consists of 
the character code and its style information (an index into a style table)
In the Sample Code given earlier, style information is made extrinsic, 
leaving the character code as the only intrinsic state.

*/

package ivanbasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Client
public class dp_2_06_Flyweight implements Demonstration {
	public void demonstration() {
		
		FontFactory factory = new FontFactory();
		List<Glyph> document = new ArrayList<Glyph>();

		String head = "HEADING 1, SOMETHING IMPORTANT";
		for ( char ch: head.toCharArray() ) {
			Glyph gl = new Character(factory.getFont("Arial"), 12, "bold", ch);
			document.add(gl);
		}

		String line1 = "The quick brown fox jumps over the lazy dog  is an English-language pangram—a sentence that contains all of the letters of the English alphabet.";
		for (  char ch: line1.toCharArray()) {
			Glyph gl = new Character(factory.getFont("Courier"), 10, "normal", ch);
			document.add(gl);
		}
		
		String line2 = "I would like to say thank you on behalf of the group and ourselves and I hope we’ve passed the audition.";
		for (  char ch: line2.toCharArray()) {
			Glyph gl = new Character(factory.getFont("Arial"), 10, "normal", ch);
			document.add(gl);
		}		
		
		for (int ii=0; ii<=100; ii++ ) {	
			document.add( new Row() );			
			document.add( new Column() );
			document.add( new PictureOrSomethingElse() );					
		}
		

		System.out.println("Glyphs      =" + document.size());
		System.out.println("Shared fonts=" + factory.size());
	}
}

// Flyweight (Glyph) 
interface Glyph {
	void draw();
}

// ConcreteFlyweight (Character) storage for intrinsic (light) state
class Character implements Glyph {
	Font font;
	int size;
	String style;
	char letter;

	Character(Font font, int size, String style, char letter) {
		this.font = font;
		this.size = size;
		this.style = style;
		this.letter = letter;
	}

	public void draw() {
	}
}

// extrinsic (heavy) state 
class Font {
	String key;
	String memoryDemandingData;
	
	Font(String key) {
		System.out.println("Wait a moment, reading a new font, name=" + key);
		
		this.key=key;
		this.memoryDemandingData="101010101000000111111";
	}
}

// FlyweightFactory
class FontFactory {
	HashMap<String, Font> hashMap = new HashMap<String, Font>();

	Font getFont(String key) {
		Font toReturn;
		if (hashMap.containsKey(key)) {
			toReturn = hashMap.get(key);
		} else {
			toReturn = new Font(key);
			this.hashMap.put(key, toReturn);
		}
		return toReturn;
	}

	int size() {
		return hashMap.size();
	}

}

// UnsharedConcreteFlyweight (Row, Column)
class Row implements Glyph {
	public void draw() {
	}
}

class Column implements Glyph {
	public void draw() {
	}
}
class PictureOrSomethingElse implements Glyph {
	public void draw() {
	}
}

 
 
