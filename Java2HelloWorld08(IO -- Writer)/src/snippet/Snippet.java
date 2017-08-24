package snippet;
/*
 * About I/O in Java
 * 
 * Basic idea is streams. Stream is like pipe through which data flows. 
 * Stream might flow in or out of the program.
 * So basically we can have input or output. 
 * 
 * The pipes that carry data can be of different types.
 * 
 * Stream might carry some characters or a character stream, bytes. 
 * 
 * A stream might be connected to different data sources. 
 * A stream might be connected to a database or a file or a network 
 * and they could be implemented in different protocols. 
 * 
 * But, the basic idea is this is kind of abstract concept of a stream or 
 * a pipe and that allows you to read from an input stream or write to an output stream. 
 * 
 * 
 * Decorator Pattern
 * 
 * Streams are implemented using decorator pattern.
 * It works like Russian doll i.e. smaller doll inside of a  bigger doll and so on.
 * 
 * This is how things are wrapped in streams. 
 * So we might have multiple streams wrapped in other streams.
 * 
 * This complicates things because it is something we are not used to.
 * But, this even simplifies things because without this decorator pattern you will need 
 * all different kinds of streams to do different things.
 * 
 * 
 * Hierarchy
 * 
 * Object 
 * 	--> Input Stream	--|
 * 						  |-->	Byte level streams
 * 	--> Output Stream	--|
 * 	
 * 	--> Reader 			--|
 * 						  |-->	Text based stream
 * 	--> Writer			--|
 * There are many streams that inherit from input and output stream and all these streams write bytes i.e. raw data, whereas reader and writer are text based streams which are designed to read ASCII characters and strings.
 *
 * So all the streams in java inherit from either input output streams or 
 * reader writer streams.
 * 
 * All the classes are abstract so we need to extend them.
 * 
 * Java streams extend these input output reader streams to implement different kinds of specialized streams.
 * 
 * */

//01.
/*
 * Let's connect to a file with print method in printer class
 * */

import printing.ColorCartridge;
import printing.Printer;

public class Snippet {

	public static void main(String args[]) {
		Printer<ColorCartridge> printer = new Printer<ColorCartridge>(true,
				"MYPRINTER", ColorCartridge.GREEN);
		printer.loadPaper(5);
		printer.print(3);
		printer.outputPage(2);
				
	}
}