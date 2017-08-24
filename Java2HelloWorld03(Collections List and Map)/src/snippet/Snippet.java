package snippet;

import printing.BWCartridge;
import printing.Printer;
//01. What is Collection?
/*
 * 1.Group of objects
 * 2.Different kinds of grouping
 * 		(i)		Uniqueness
 * 		(ii)	Order
 * 		(iii)	Process
 * 		(iv)	Mapping
 * 
 * 02. Most of the collections implement an interface called Collection
 * 	Eg: Set, List, Queue
 * and this collection uses generics to work on any type.
 * 
 * Maps are a unique kind of collection. They have keys.
 * 
 * List 
 * 
 * List is one of the widely used language
 * it is ordered and sequential 
 * and can have duplicates
 * 
 *06.  Map
 * 
 * maps some key to a value
 *
 * 11.
 * 
 * Set: set of unique item
 * no two are same
 * 
 * */


public class Snippet {

	public static void main(String args[]){
		
		Printer<BWCartridge> printer = new Printer<BWCartridge>(true, "MYPRINTER", new BWCartridge());
		printer.loadPaper(10);
		printer.print(10);
		//09.list --> commenting below for map
		//printer.outputPage();
		//10.
		printer.outputPage(5);
		
	}
}

