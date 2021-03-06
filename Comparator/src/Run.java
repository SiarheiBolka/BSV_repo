import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Run {

	public static void main(String[] args) {
		String requiredElement = "some string20";

		/* ArrayList */
		List<String> arrList = new ArrayList<String>();
		System.out.println("***** ArrayList ******\n");
		Utils.addElement(arrList);

		Utils.findElement(arrList, requiredElement);
		Utils.deleteElement(arrList);

		/* LinkedList */
		List<String> linkList = new LinkedList<String>();
		System.out.println("\n***** LinkedList ******\n");
		Utils.addElement(linkList);
		Utils.findElement(linkList, requiredElement);
		Utils.deleteElement(linkList);

		/* TreeSet */
		TreeSet<String> treeSet = new TreeSet<String>();
		System.out.println("\n***** TreeSet ******\n");
		Utils.addElement(treeSet);
		Utils.findElement(treeSet, requiredElement);
		Utils.deleteElement(treeSet);

		/* HashSet */
		HashSet<String> hashSet = new HashSet<String>();
		System.out.println("\n***** HashSet ******\n");
		Utils.addElement(hashSet);
		Utils.findElement(hashSet, requiredElement);
		Utils.deleteElement(hashSet);

		/* HashMap */
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		System.out.println("\n***** HashMap ******\n");
		Utils.addElement(hashMap);
		Utils.findElement(hashMap,requiredElement);
		Utils.deleteElement(hashMap);

		/* TreeMap */
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		System.out.println("\n***** TreeMap ******\n");
		Utils.addElement(treeMap);
		Utils.findElement(treeMap,requiredElement);
		Utils.deleteElement(treeMap);

		System.out.println("\nEnd");

	}

}
