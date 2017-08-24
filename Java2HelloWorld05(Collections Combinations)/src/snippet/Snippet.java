package snippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import printing.BWCartridge;
import printing.Printer;

/*
 *Combining collection with map is pretty useful
 * */

public class Snippet {

	public static void main(String args[]) {

		Printer<BWCartridge> printer = new Printer<BWCartridge>(true,
				"MYPRINTER", new BWCartridge());

		Map<String, List<Integer>> testScores = new HashMap<String, List<Integer>>();

		List<Integer> nehaScores = new ArrayList<Integer>();

		nehaScores.add(90);
		nehaScores.add(95);
		nehaScores.add(97);

		testScores.put("Neha", nehaScores);

		List<Integer> snehaScores = new ArrayList<Integer>();

		snehaScores.add(80);
		snehaScores.add(85);
		snehaScores.add(87);

		testScores.put("Sneha", snehaScores);
		
		List<Integer> srilekhaScores = new ArrayList<Integer>();
		
		srilekhaScores.add(70);
		srilekhaScores.add(75);
		srilekhaScores.add(77);
		
		testScores.put("Srilekha", srilekhaScores);
		
		printScores("Neha", testScores);
		printScores("Sneha", testScores);
		printScores("Srilekha", testScores);

	}
	
	public static void printScores(String studentName, Map<String, List<Integer>> scoresMap){
		List<Integer> scores = scoresMap.get(studentName);
		System.out.println("Students name : " + studentName);
		System.out.println("Marks");
		for (int score : scores){
			System.out.println("        " + score);
		}
	}
}

