package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {
	
	@Before
	public void setUp() {
		;
	}
	
	/* 
	 * Tests for Utils.isAnyNull ====================
	*/
	
	@Test
	public void isAnyNull_passInEmptyInput() {
		assertFalse(Utils.isAnyNull());
	}
	
	@Test 
	public void isAnyNull_passInAllNotNull() {
		assertFalse(Utils.isAnyNull(new Object()));
		assertFalse(Utils.isAnyNull(new Object(), 
									new Object(), 
									new Object()));
		assertFalse(Utils.isAnyNull(new Object(), 
									new Object(), 
									new Integer(2)));
	}
	
	@Test
	public void isAnyNull_passInSomeNull() {
		assertTrue(Utils.isAnyNull(null,
									new Object(),
									new Object()));
		assertTrue(Utils.isAnyNull(new Object(),
									null,
									new Object(),
									null));
		assertTrue(Utils.isAnyNull(new Object(),
									new Object(),
									new Integer(2),
									null));
	}
	
	@Test
	public void isAnyNull_passInAllNull() {
		assertTrue(Utils.isAnyNull(null, null, null, null));
		assertTrue(Utils.isAnyNull(null, null, null));
		assertTrue(Utils.isAnyNull(null, null));
	}
	
	@Test
	public void isAnyNull_passOneNull() {
		Object test = null;
		assertTrue(Utils.isAnyNull(test));
	}
	
	/* 
	 * Tests for Utils.elementsAreUnique ====================
	*/
	
	@Test 
	public void elementsAreUnique_passInEmptyArrayList() {
		Collection<String> collection = new ArrayList<String>();		
		assertTrue(Utils.elementsAreUnique(collection));
	}
	
	@Test 
	public void elementsAreUnique_passInOneElementArrayList() {
		Collection<String> collection = new ArrayList<String>();
		
		collection.add("1");

		assertTrue(Utils.elementsAreUnique(collection));
	}
	
	@Test 
	public void elementsAreUnique_passInUniqueArrayList() {
		Collection<String> collection = new ArrayList<String>();
		
		collection.add("1");
		collection.add("2");
		collection.add("3");
		
		assertTrue(Utils.elementsAreUnique(collection));
	}
	
	@Test 
	public void elementsAreUnique_passInRepeatitiveArrayList() {
		Collection<String> collection = new ArrayList<String>();
		
		collection.add("1");
		collection.add("1");
		collection.add("1");
		collection.add("1");
		collection.add("1");
		
		assertFalse(Utils.elementsAreUnique(collection));
	}
	
	@Test 
	public void elementsAreUnique_passInArrayListWithOneRepeat() {
		Collection<String> collection = new ArrayList<String>();
		
		collection.add("1");
		collection.add("2");
		collection.add("3");
		collection.add("4");
		collection.add("5");
		collection.add("1");
		
		assertFalse(Utils.elementsAreUnique(collection));
	}
}




















