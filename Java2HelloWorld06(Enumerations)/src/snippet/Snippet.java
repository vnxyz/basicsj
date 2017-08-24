package snippet;

import printing.ColorCartridge;
import printing.Printer;

/*
 *Enumerations in Java
 *
 *Enumeration is exact listing of all elements of a set.
 *
 *Eg:
 *Months of the year --> finite set all 12 months
 *Going through all of the months is we could enumerate through them.
 *enumeration in java is a type that we're going to declare 
 *that is going to have all the members that belongs to that set.
 *
 *Why Enumeration?
 *
 *1. Way of naming things.
 *		It is really easy to identify things in an enumeration.
 *		We dont have to come with string, integer or something to name something.
 *		Because it allows you put all the names of one thing at one place to access something.
 *		
 *2. Typesafety
 *		We get type safety along with it. Month. 
 *		Ctrl + space gives the list of available enumeration and there is no scope of wrong inputs
 *
 *3. Limits input		
 *		as the input given is restricted the algorithm becomes easy. 
 *		There is no need to check or validate the input.
 *
 *4. Groups things in a set
 *
 *5. Iterable
 *
 *Use enumeration wherever possible
 *
 * */

public class Snippet {

	public static void main(String args[]) {
		// 01.
		/*
		 * We will use enumeration to have cartridges of different colors
		 */
		Printer<ColorCartridge> printer = new Printer<ColorCartridge>(true,
				"MYPRINTER", ColorCartridge.GREEN);
		

		//05.
		/*
		switch (printer.getCartridge()) {
		case BLUE:
			System.out.println("Blue");
			break;
		case RED:
			System.out.println("Red");
			break;
		case GREEN:
			System.out.println("Green");
			break;
		case YELLOW:
			System.out.println("Yellow");
			break;
		}
		*/
		
		//09.
		/*
		printer.loadPaper(5);
		printer.print(3);
		printer.outputPage(2);
		printer.outputPage(1);
		*/
		
		//10. 
		/*How to iterate through */
		for(ColorCartridge cartridge: ColorCartridge.values()){
			System.out.println(cartridge.printColor());
		}
		
	}
}
/*
 * 
 * ENUM Classes:
 * 
 * --> Values method
 * --> Constructor
 * --> Members
 * --> Use as a singleton
 * 
 * So, one thing that's really unique about enumerations in Java is that they are actually full, 
 * functional classes. And, a little hard to understand why would they do this in Java? 
 * But, once you start using this functionality, you'll find that enumerations in Java really
 *  are the best because having them being full-fledged classes really 
 * adds some convenience that you can't get when enumerations are just represented as integers. 
 * 
 * (So, I have a diagram here and you can see here that we have a diagram of weekdays 
 * if we created a weekdays enumeration and what it would look like conceptually. 
 * And, you can see that the weekdays enumeration that we created would inherit from 
 * basically an enum class. There's actually a class defined in Java that defines an enum. 
 * And then, each weekday in that enumeration would actually inherit from the weekdays 
 * or it's a type of weekdays. And so, you would have your Monday, Tuesday, Wednesday, 
 * Thursday, and so on. But, these are all classes and I'm showing a class diagram here 
 * to kind of emphasize that point. And this is really, when you see an enumeration, this 
 * is what it looks like. )
 * 
 * In a lot of other programming languages, if you looked at an 
 * enumeration, an enumeration would really just be a way of seeing an integer. 
 * A way of naming an integer. 
 * 
 * And, that's not the case in Java. 
 * You cannot cast a Java enumeration to an integer. 
 * So, the enum class itself, it is kind of handy in Java. 
 * 
 * It gives us a values method that lets us iterate through all the enumerations. 
 * So, any enumeration class that you declare in Java, you can call .values on it and 
 * it will give you an iterable list of every value that's in that enumeration, 
 * which is really useful for going through and checking through an enumeration 
 * or mapping an enumeration to something else. 
 * 
 * Of course, enumeration has constructor or, 
 * by default, you wouldn't even see the constructor, but you can add a constructor. 
 * And when you do that, you basically declare an enumeration and you pass in whatever 
 * parameters in that declaration of each enumeration in the enum type. 
 * It also can have members. And, one really convenient thing that you can use an enumeration 
 * for in Java is a simple singleton. Now, it's not going to be a complicated application 
 * of a singleton. If you're familiar with a singleton pattern, it's basically a pattern
 *  that says you can only have one of a certain thing. But, an enum class really works 
 *  very nicely for this. You don't have to write guard clauses and all. 
 *  The code to implement a singleton, you can just declare an enumeration and use that 
 *  as your singleton in Java.
 */
