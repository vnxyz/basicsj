package snippet;

import java.util.LinkedList;
import java.util.Queue;

import printing.BWCartridge;
import printing.Printer;
/*
 *
 * 1.
 * 
 * Set: set of unique item
 * no two are same
 * 
 * 
 * 03. Queue 
 * It is special kind of list that has some extra properties.
 * It is an ordered list. Most of the queues are list.
 * It is generally used for processing. 
 * It is usually processed in FIFO --> First in First out
 * 
 * */


public class Snippet {

	public static void main(String args[]){
		
		Printer<BWCartridge> printer = new Printer<BWCartridge>(true, "MYPRINTER", new BWCartridge());
		
		//02.
		//Set<Integer> mySet = new HashSet<Integer>();
		/*mySet.add(1);	mySet.add(2);	mySet.add(1);	
		 * --> output of mySet.size() is 2 because it is set
		 * but if it is a list then it is 3
		 **/
		
		//04.
		Queue<String> myQueue = new LinkedList<String>();
		
		//offer is similar to add, but offer wont throw an exception if queue is full
		myQueue.offer("a");
		myQueue.offer("b");
		myQueue.offer("c");
		//peek is used to check the top item in queue. it doesnt remove anything but just checks.
		while(myQueue.peek() != null)
		{
			//poll out the first item in it
			System.out.println(myQueue.poll());
		}
		
	}
}

