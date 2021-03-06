//import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
//import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Utils {
	static long startTime, endTime;
	public static final int COUNT = 30; // count of elements in list
	public static final String SOME_STRING = "some string";

	/*------------------addElementToList------------------*/
	public static void addElement(List<String> list) {
		list.clear();

		List<Long> times = new LinkedList<Long>();
		times.clear();

		for (int i = 0; i < COUNT; i++) {
			startTime = System.nanoTime();
			list.add(SOME_STRING + i);
			endTime = System.nanoTime();

			times.add(endTime - startTime);
		}

		long min = 0, max = 0, total = 0;
		for (Long time : times) {
			total += time;
			max = (time > max) ? time : max;
			min = (time < min) ? time : min;
		}
		System.out.println("min time of adding 1 element: " + min
				+ " ns\nmax time of adding 1 element: " + max
				+ " ns\naverage time of adding 1 element: " + total
				/ list.size() + " ns\n\n" + "Totaltime of adding "
				+ list.size() + " elements : " + total + " ns");
		// Utils.printList(list);
	}

	/*------------------addElementToTreeSet------------------*/
	public static void addElement(TreeSet<String> set) {
		set.clear();

		List<Long> times = new LinkedList<Long>();
		times.clear();
		// Random random = new Random(30);

		for (int i = 0; i < COUNT; i++) {
			startTime = System.nanoTime();
			// set.add(SOME_STRING + random.nextInt(31));
			set.add(SOME_STRING + i);
			endTime = System.nanoTime();

			times.add(endTime - startTime);
		}

		long min = 0, max = 0, total = 0;
		for (Long time : times) {
			total += time;
			max = (time > max) ? time : max;
			min = (time < min) ? time : min;
		}
		System.out.println("min time of adding 1 element: " + min
				+ " ns\nmax time of adding 1 element: " + max
				+ " ns\naverage time of adding 1 element: " + total
				/ set.size() + " ns\n\n" + "Totaltime of adding " + set.size()
				+ " elements : " + total + " ns");
		// Utils.printSet(set);
	}

	/*------------------addElementToHashSet------------------*/
	public static void addElement(HashSet<String> set) {
		set.clear();

		List<Long> times = new LinkedList<Long>();
		times.clear();
		// Random random = new Random(30);

		for (int i = 0; i < COUNT; i++) {
			startTime = System.nanoTime();
			// set.add(SOME_STRING + random.nextInt(31));
			set.add(SOME_STRING + i);
			endTime = System.nanoTime();

			times.add(endTime - startTime);
		}

		long min = 0, max = 0, total = 0;
		for (Long time : times) {
			total += time;
			max = (time > max) ? time : max;
			min = (time < min) ? time : min;
		}
		System.out.println("min time of adding 1 element: " + min
				+ " ns\nmax time of adding 1 element: " + max
				+ " ns\naverage time of adding 1 element: " + total
				/ set.size() + " ns\n\n" + "Totaltime of adding " + set.size()
				+ " elements : " + total + " ns");
		// Utils.printSet(set);
	}

	/*------------------addElementToHashMap------------------*/
	public static void addElement(HashMap<Integer, String> hmap) {
		hmap.clear();

		List<Long> times = new LinkedList<Long>();
		times.clear();

		for (int i = 0; i < COUNT; i++) {
			startTime = System.nanoTime();
			hmap.put(i, SOME_STRING + i);
			endTime = System.nanoTime();

			times.add(endTime - startTime);
		}

		long min = 0, max = 0, total = 0;
		for (Long time : times) {
			total += time;
			max = (time > max) ? time : max;
			min = (time < min) ? time : min;
		}
		System.out.println("min time of adding 1 element: " + min
				+ " ns\nmax time of adding 1 element: " + max
				+ " ns\naverage time of adding 1 element: " + total
				/ hmap.size() + " ns\n\n" + "Totaltime of adding "
				+ hmap.size() + " elements : " + total + " ns");
		// Utils.printMap(hmap);
	}
	
	/*------------------addElementToTreeMap------------------*/
	public static void addElement(TreeMap<Integer, String> tmap) {
		tmap.clear();

		List<Long> times = new LinkedList<Long>();
		times.clear();

		for (int i = 0; i < COUNT; i++) {
			startTime = System.nanoTime();
			tmap.put(i, SOME_STRING + i);
			endTime = System.nanoTime();

			times.add(endTime - startTime);
		}

		long min = 0, max = 0, total = 0;
		for (Long time : times) {
			total += time;
			max = (time > max) ? time : max;
			min = (time < min) ? time : min;
		}
		System.out.println("min time of adding 1 element: " + min
				+ " ns\nmax time of adding 1 element: " + max
				+ " ns\naverage time of adding 1 element: " + total
				/ tmap.size() + " ns\n\n" + "Totaltime of adding "
				+ tmap.size() + " elements : " + total + " ns");
		 // Utils.printMap(tmap);
	}

	/*------------------findElementInList------------------*/
	public static void findElement(List<String> list, String requiredElement) {

		startTime = System.nanoTime();
		for (String elem : list) {
			if (elem.equals(requiredElement)) {
				endTime = System.nanoTime();
				// System.out.println("Element is founded: " + elem + "\n");
			}
		}
		System.out.println("Total time of element searching: "
				+ (endTime - startTime) + " ns");
		// Utils.printList(list);
	}

	/*------------------findElementTreeSet------------------*/
	public static void findElement(TreeSet<String> set, String requiredElement) {

		startTime = System.nanoTime();
		for (String elem : set) {
			if (elem.equals(requiredElement)) {
				endTime = System.nanoTime();
				// System.out.println("Element is founded: " + elem + "\n");
			}
		}
		System.out.println("Total time of element searching: "
				+ (endTime - startTime) + " ns");
		// Utils.printSet(set);
	}

	/*------------------findElementHashSet------------------*/
	public static void findElement(HashSet<String> set, String requiredElement) {

		startTime = System.nanoTime();
		for (String elem : set) {
			if (elem.equals(requiredElement)) {
				endTime = System.nanoTime();
				// System.out.println("Element is founded: " + elem + "\n");
			}
		}
		System.out.println("Total time of element searching: "
				+ (endTime - startTime) + " ns");
		// Utils.printSet(set);
	}

	/*------------------findElementHashMap------------------*/
	public static void findElement(HashMap<Integer, String> hmap,
			String requiredElement) {

		startTime = System.nanoTime();
		for (Entry<Integer, String> entry : hmap.entrySet()) {
			// System.out.println(entry.getKey() + " = " + entry.getValue());
			if (entry.getValue().equals(requiredElement)) {
				endTime = System.nanoTime();
				// System.out.println("Element is founded: " + entry.getValue()
				// + "\n");
			}
		}
		System.out.println("Total time of element searching: "
				+ (endTime - startTime) + " ns");
		// Utils.printMap(set);
	}
	
	/*------------------findElementTreeMap------------------*/
	public static void findElement(TreeMap<Integer, String> tmap, String requiredElement) {

		startTime = System.nanoTime();
		for (Entry<Integer, String> entry : tmap.entrySet()) {
			// System.out.println(entry.getKey() + " = " + entry.getValue());
			if (entry.getValue().equals(requiredElement)) {
				endTime = System.nanoTime();
				// System.out.println("Element is founded: " + entry.getValue()
				// + "\n");
			}
		}
		System.out.println("Total time of element searching: "
				+ (endTime - startTime) + " ns");
		// Utils.printMap(tmap);
	}

	/*------------------deleteElementFromList------------------*/
	public static void deleteElement(List<String> list) {

		Iterator<String> iter = list.listIterator();
		startTime = System.nanoTime();
		list.remove(5); // delete 5th element from list
		endTime = System.nanoTime();
		/*
		 * while (iter.hasNext()) { if (iter.next().equals(requiredElement)) {
		 * startTime = System.nanoTime(); iter.remove(); endTime =
		 * System.nanoTime(); } }
		 */
		System.out.println("Total time of element deleting: "
				+ (endTime - startTime) + " ns");
		// Utils.printList(list);
	}

	/*------------------deleteElementFromTreeSet------------------*/
	public static void deleteElement(TreeSet<String> set) {

		startTime = System.nanoTime();
		set.remove("some string15");
		endTime = System.nanoTime();

		System.out.println("Total time of element deleting: "
				+ (endTime - startTime) + " ns");
		// Utils.printSet(set);
	}

	/*------------------deleteElementFromHashSet------------------*/
	public static void deleteElement(HashSet<String> set) {

		startTime = System.nanoTime();
		set.remove("some string15");
		endTime = System.nanoTime();

		System.out.println("Total time of element deleting: "
				+ (endTime - startTime) + " ns");
		// Utils.printSet(set);
	}

	/*------------------deleteElementFromHashMap------------------*/
	public static void deleteElement(HashMap<Integer, String> hmap) {
		startTime = System.nanoTime();
		hmap.remove(15); //remove element"some string15"
		endTime = System.nanoTime();
		
		//Utils.printMap(hmap);

		System.out.println("Total time of element searching: "
				+ (endTime - startTime) + " ns");
		// Utils.printMap(set);
	}

	/*------------------deleteElementFromTreeMap------------------*/
	public static void deleteElement(TreeMap<Integer, String> tmap) {
		startTime = System.nanoTime();
		tmap.remove(15); //remove element"some string15"
		endTime = System.nanoTime();
		
		System.out.println("Total time of element searching: "
				+ (endTime - startTime) + " ns");
		// Utils.printMap(tmap);
	}
	
	/*------------------printList------------------*/
	public static void printList(List<String> list) {
		Iterator<String> iter = list.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("\n");
	}

	/*------------------printSet------------------*/
	public static void printSet(TreeSet<String> set) {
		Iterator<String> iterator = set.iterator();
		System.out.print("Tree set data: \n");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "\n");
		}
		System.out.println("\n");
	}

	/*------------------printMap------------------*/
	public static void printMap(Map<Integer, String> hmap) {
		Set<Map.Entry<Integer, String>> setvalue = hmap.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = setvalue.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> me = iterator.next();
			System.out.print(me.getKey() + " : ");
			System.out.print(me.getValue() + "\n");
		}
	}
}
