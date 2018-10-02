import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;


public class LinkedListUnitTesting
{   
    /*
     * Initialize using my addFirst method in their class file.
     */
    private static MyLinkedList init()
    {
	MyLinkedList myll = new MyLinkedList();
	myll.jaddFirst(7);
	myll.jaddFirst(3);
	myll.jaddFirst(5);
	myll.jaddFirst(3);
	myll.jaddFirst(1);
	return myll;
    }

    /*
     * toString() Actual/Expected output text
     */
    private static void ae(MyLinkedList myll, String key)
    {
	System.out.print("Actual  : ");
	System.out.println(myll);
	System.out.print("Expected: ");
	System.out.println(key);
    }

    /*
     * toString() Pass/Fail
     */
    private static boolean check(MyLinkedList myll, String key)
    {
	if (myll.toString().equals(key))
	    {
		return true;
	    }
	else
	    {
		System.out.println("\tFAILED");
		return false;
	    }
    }

    /*
     * String Actual/Expected output text
     */
    private static void strae(String result, String key)
    {
	System.out.print("Actual  : ");
	System.out.println(result);
	System.out.print("Expected: ");
	System.out.println(key);
    }

    /*
     * String Pass/Fail
     */
    private static boolean strCheck(String result, String key)
    {
	if (result.equals(key))
	    {
		return true;
	    }
	else
	    {
		System.out.println("\tFAILED");
		return false;
	    }
    }

    /*
     * int Actual/Expected output text
     */
    private static void intae(int result, int key)
    {
	System.out.print("Actual  : ");
	System.out.println(result);
	System.out.print("Expected: ");
	System.out.println(key);
    }

    /*
     * int Pass/Fail
     */
    private static boolean intCheck(int result, int key)
    {
	if (result == key)
	    {
		return true;
	    }
	else
	    {
		System.out.println("\tFAILED");
		return false;
	    }
    }
    
    public static void main(String[] args)
    {
	int correct = 0;
	int exception = 10;
	
	/*
	 * 1. boolean add(E e) 
	 */
	System.out.println("\n\n\t1. ADD");
	try
	    {
		//Inits
		final String key = "[1, 3, 5, 3, 7, last, newlast]";
		MyLinkedList myll = init();
		
		//Tests
		boolean try1 = myll.add("last");
		boolean try2 = myll.add("newlast");

		//Checks
		ae(myll, key);
		if (check(myll, key) && try1 && try2)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("Add exception: " + e.getMessage());
		exception--;
	    }
	
	/*
	 * 2. void add(int index, E element)
	 */
	System.out.println("\n\n\t2. ADD INDEX");
	try
	    {
		//Inits
		final String key = "[1, 3, 5, I3, I4, 3, 7]";
		final String exKey = "[class java.lang.IndexOutOfBoundsException]";
		MyLinkedList myll = init();
		
		//Tests
		myll.add(3, "I3");
		myll.add(4, "I4");

		//Checks
		ae(myll, key);
		if (check(myll, key))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }

		//Exceptions
		System.out.println("Checking Exception Types");
		String exTypes = Arrays.toString(myll.getClass().getMethod("add", int.class, Object.class).getExceptionTypes());
		strae(exTypes, exKey);
		if (!strCheck(exTypes, exKey))
		    exception--;
		else
		    System.out.println("\tPASSED");
	    }
	catch(Exception e)
	    {
		System.out.println("Add at index exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 3. boolean addAll(Collection<? extends E> c)
	 */
	System.out.println("\n\n\t3. ADD COLLECTION");
	try
	    {
		//Inits
		final String key = "[1, 3, 5, 3, 7, One, Two]";
		final String exKey = "[class java.lang.NullPointerException]";
		MyLinkedList myll = init();
		ArrayList<Object> x = new ArrayList<>();
		x.add("One");
		x.add("Two");
		
		//Tests
		boolean try1 = myll.addAll(x);

		//Checks
		ae(myll, key);
		if (check(myll, key) && try1)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }

		//Exceptions
		System.out.println("Checking Exception Types");
		String exTypes = Arrays.toString(myll.getClass().getMethod("addAll", Collection.class).getExceptionTypes());
		strae(exTypes, exKey);
		if (!strCheck(exTypes, exKey))
		    exception--;
		else
		    System.out.println("\tPASSED");
	    }
	catch(Exception e)
	    {
		System.out.println("Add collection exception: " + e.getMessage());
		e.printStackTrace();
		exception--;
	    }

	/*
	 * 4. boolean addAll(int index, Collection<? extends E> c) 
	 */
	System.out.println("\n\n\t4. ADD COLLECTION INDEX");
	try
	    {
		//Inits
		final String key = "[1, 3, 5, 3, One, Two, 7]";
		final String exKey = "[class java.lang.NullPointerException, class java.lang.IndexOutOfBoundsException]";
		MyLinkedList myll = init();
		ArrayList<Object> x = new ArrayList<>();
		x.add("One");
		x.add("Two");
		
		//Tests
		boolean try1 = myll.addAll(4, x);

		//Checks
		ae(myll, key);
		if (check(myll, key) && try1)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }

		//Exceptions
		System.out.println("Checking Exception Types");
		String exTypes = Arrays.toString(myll.getClass().getMethod("addAll", int.class, Collection.class).getExceptionTypes());
		strae(exTypes, exKey);
		if (!strCheck(exTypes, exKey))
		    exception--;
		else
		    System.out.println("\tPASSED");
	    }
	catch(Exception e)
	    {
		System.out.println("Add collection index 4 exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 5. void addFirst(E e) 
	 */
	System.out.println("\n\n\t5. ADDFIRST");
	try
	    {
		//Inits
		final String key = "[First?, Second?, 1, 3, 5, 3, 7]";
		MyLinkedList myll = init();
		
		//Tests
		myll.addFirst("Second?");
		myll.addFirst("First?");

		//Checks
		ae(myll, key);
		if (check(myll, key))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("AddFirst exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 6. void addLast(E e)
	 */
	System.out.println("\n\n\t6. ADDLAST");
	try
	    {
		//Inits
		final String key = "[1, 3, 5, 3, 7, Second last?, Last?]";
		MyLinkedList myll = init();
		
		//Tests
		myll.addLast("Second last?");
		myll.addLast("Last?");

		//Checks
		ae(myll, key);
		if (check(myll, key))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("AddLast exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 7. void clear()
	 */
	System.out.println("\n\n\t7. CLEAR");
	try
	    {
		//Inits
		final String key = "[]";
		MyLinkedList myll = init();
		
		//Tests
		myll.clear();

		//Checks
		ae(myll, key);
		if (check(myll, key) && myll.size() == 0)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("Clear exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 8. boolean contains(Object o)
	 */
	System.out.println("\n\n\t8. CONTAINS");
	try
	    {
		//Inits
		final String key = "[zero, 1, 3, 5, 3, 7]";
		MyLinkedList myll = init();
		myll.jaddFirst("zero");
		
		//Tests
		if (myll.contains("zero") && myll.contains(7) && !myll.contains(2) && !myll.contains("seven"))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
		else
		    {
			System.out.println("\tFAILED");
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("Contains exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 9. boolean containsAll(Collection<?> c)
	 */
	System.out.println("\n\n\t9. CONTAINS ALL");
	try
	    {
		//Inits
		final String key = "[First, 1, 3, 5, 3, 7, Last]";
		MyLinkedList myll = init();
		myll.jaddFirst("First");
		myll.jaddLast("Last");
		ArrayList<Object> x = new ArrayList<>();
		x.add("Last");
		x.add("First");
		
		//Tests
		if (myll.containsAll(x))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
		else
		    {
			System.out.println("\tFAILED");
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("Contains all exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 10. boolean equals(Object o)
	 */
	System.out.println("\n\n\t10. EQUALS");
	try
	    {
		//Inits
		MyLinkedList myll = init();
		MyLinkedList myll2 = init();
		ArrayList<Object> x = new ArrayList<>();
		
		//Tests
		boolean try1 = myll.equals(myll2);
		boolean try2 = myll.equals(x);

		//Checks
		if (try1 && !try2)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
		else
		    {
			System.out.println("\tFAILED");
		    }

		//Exceptions
	    }
	catch(Exception e)
	    {
		System.out.println("Equals exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 11. Object get(int index)
	 */
	System.out.println("\n\n\t11. GET");
	try
	    {
		//Inits
		final String key = "[1, 3, 5, 3, 7]";
		final String exKey = "[class java.lang.IndexOutOfBoundsException]";
		MyLinkedList myll = init();
		
		//Tests
		Object one = myll.get(0);
		Object two = myll.get(4);

		//Checks
		ae(myll, key);
		if (check(myll, key) && (int)one == 1 && (int)two == 7)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }

		//Exceptions
		System.out.println("Checking Exception Types");
		String exTypes = Arrays.toString(myll.getClass().getMethod("get", int.class).getExceptionTypes());
		strae(exTypes, exKey);
		if (!strCheck(exTypes, exKey))
		    exception--;
		else
		    System.out.println("\tPASSED");
	    }
	catch(Exception e)
	    {
		System.out.println("Get exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 12. int hashCode()
	 */
	System.out.println("\n\n\t12. HASHCODE");
	try
	    {
		//Inits
		//final int key = 29646950; //221269490 //1092522821 //1252169911 All are different?
		MyLinkedList myll = init();
		
		//Tests
		int result = myll.hashCode();

		//Checks
		System.out.println("\tPASSED");
		correct++;
	    }
	catch(Exception e)
	    {
		System.out.println("Hashcode exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 13. int indexOf(Object o)
	 */
	System.out.println("\n\n\t13. INDEXOF");
	try
	    {
		//Inits
		final int key1 = 0;
		final int key2 = 4;
		MyLinkedList myll = init();
		
		//Tests
		int try1 = myll.indexOf((Object)1);
		int try2 = myll.indexOf((Object)7);
		int try3 = myll.indexOf((Object)99);

		//Checks
		intae(try1, key1);
		intae(try2, key2);
		if (intCheck(try1, key1) && intCheck(try2, key2) && try3 == -1)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("IndexOf exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 14. boolean isEmpty()
	 */
	System.out.println("\n\n\t14. ISEMPTY");
	try
	    {
		//Inits
		MyLinkedList myll = init();
		MyLinkedList myll2 = new MyLinkedList();
		
		//Tests
		boolean try1 = myll.isEmpty();
		boolean try2 = myll2.isEmpty();

		//Checks
		if (!try1 && try2)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
		else
		    {
			System.out.println("\tFAILED");
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("IsEmpty exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 15. Iterator<E> iterator()
	 */
	System.out.println("\n\n\t15. ITERATOR");
	try
	    {
		//Inits
		final String key = "13537";
		MyLinkedList myll = init();
		Iterator<Object> iterator = myll.iterator();
		String result = "";
		
		//Tests
		while(iterator.hasNext())
		    result += iterator.next();

		//Checks
		strae(result, key);
		if (strCheck(result, key))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("Iterator exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 16. int lastIndexOf(Object o)
	 */
	System.out.println("\n\n\t16. LASTINDEXOF");
	try
	    {
		//Inits
		final int key = 5;
		MyLinkedList myll = init();
		myll.jaddLast(3);
		
		//Tests
		int result = myll.lastIndexOf(3);

		//Checks
		intae(result, key);
		if (intCheck(result, key))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("LastIndexOf exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 17. Object remove(int index)
	 */
	System.out.println("\n\n\t17. REMOVE INDEX");
	try
	    {
		//Inits
		final String key = "[5, 3]";
		final String exKey = "[class java.lang.IndexOutOfBoundsException]";
		MyLinkedList myll = init();
		
		//Tests
		Object one = myll.remove(0);
		Object seven = myll.remove(3);
		Object three = myll.remove(0);

		//Checks
		ae(myll, key);
		if (check(myll, key) && (int)one == 1 && (int)seven == 7 && (int)three == 3)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }

		//Exceptions
		System.out.println("Checking Exception Types");
		String exTypes = Arrays.toString(myll.getClass().getMethod("remove", int.class).getExceptionTypes());
		strae(exTypes, exKey);
		if (!strCheck(exTypes, exKey))
		    exception--;
		else
		    System.out.println("\tPASSED");
	    }
	catch(Exception e)
	    {
		System.out.println("Remove exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 18. boolean remove(Object o)
	 */
	System.out.println("\n\n\t18. REMOVE OBJECT");
	try
	    {
		//Inits
		final String key = "[3, 3]";
		MyLinkedList myll = init();
		
		//Tests
		boolean try1 = myll.remove((Object)1);
		boolean try2 = myll.remove((Object)7);
		boolean try3 = myll.remove((Object)5);
		boolean try4 = myll.remove((Object)2);

		//Checks
		ae(myll, key);
		if (check(myll, key) && try1 && try2 && try3 && !try4)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("Remove exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 19. boolean removeAll(Collection c)
	 */
	System.out.println("\n\n\t19. REMOVEALL");
	try
	    {
		//Inits
		final String key = "[5]";
		MyLinkedList myll = init();
		myll.jaddFirst(1);
		myll.jaddLast(7);
		ArrayList<Object> x = new ArrayList<>();
		x.add(3);
		x.add(1);
		x.add(7);
		
		//Tests
		boolean try1 = myll.removeAll(x);

		//Checks
		ae(myll, key);
		if (check(myll, key) && try1)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("Remove exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 20. boolean retainAll(Collection c)
	 */
	System.out.println("\n\n\t20. RETAINALL");
	try
	    {
		//Inits
		final String key = "[First, Last]";
		MyLinkedList myll = init();
		myll.jaddFirst("First");
		myll.jaddLast("Last");
		ArrayList<Object> x = new ArrayList<>();
		x.add("First");
		x.add("Last");
		
		//Tests
		boolean try1 = myll.retainAll(x);

		//Checks
		ae(myll, key);
		if (check(myll, key) && try1)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("RetainAll exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 21. Object set(int index, Object element)
	 */
	System.out.println("\n\n\t21. SET");
	try
	    {
		//Inits
		final String key = "[1, 3, Middle, 3, 7]";
		final int key2 = 5;
		final String exKey = "[class java.lang.IndexOutOfBoundsException]";
		MyLinkedList myll = init();
		
		//Tests
		Object removed = myll.set(2, "Middle");

		//Checks
		ae(myll, key);
		intae((int)removed, key2);
		if (check(myll, key) && (int)removed == 5)
		    {
			System.out.println("\tPASSED");
			correct++;
		    }

		//Exceptions
		System.out.println("Checking Exception Types");
		String exTypes = Arrays.toString(myll.getClass().getMethod("set", int.class, Object.class).getExceptionTypes());
		strae(exTypes, exKey);
		if (!strCheck(exTypes, exKey))
		    exception--;
		else
		    System.out.println("\tPASSED");
	    }
	catch(Exception e)
	    {
		System.out.println("Set exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 22. int size()
	 */
	System.out.println("\n\n\t22. SIZE");
	try
	    {
		//Inits
		final int key = 5;
		MyLinkedList myll = init();
		
		//Tests
		int size = myll.size();

		//Checks
		intae(size, key);
		if (intCheck(size, key))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }
	    }
	catch(Exception e)
	    {
		System.out.println("Size exception: " + e.getMessage());
		exception--;
	    }

	/*
	 * 23. List<Object> subList(int fromIndex, int toIndex)
	 */
	System.out.println("\n\n\t23. SUBLIST");
	try
	    {
		//Inits
		final String key = "[3, 5]";
		final String exKey = "[class java.lang.IndexOutOfBoundsException]";
		MyLinkedList myll = init();
		
		//Tests
		String result = myll.subList(1, 3).toString();

		//Checks
		strae(result, key);
		if (strCheck(result, key))
		    {
			System.out.println("\tPASSED");
			correct++;
		    }

		//Exceptions
		System.out.println("Checking Exception Types");
		String exTypes = Arrays.toString(myll.getClass().getMethod("subList", int.class, int.class).getExceptionTypes());
		strae(exTypes, exKey);
		if (!strCheck(exTypes, exKey))
		    exception--;
		else
		    System.out.println("\tPASSED");
	    }
	catch(Exception e)
	    {
		System.out.println("SubList exception: " + e.getMessage());
		exception--;
	    }

	System.out.println("\n\nNumber correct: " + correct);
	System.out.println("Total points: " + correct * 3);
	System.out.println("Exception handling points: " + exception);
    }
}
