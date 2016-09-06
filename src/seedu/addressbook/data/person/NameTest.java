package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	
	private Name name;
	
	@Before
	public void setUp() throws IllegalValueException {
		try {
			name = new Name("John Watson");	
		} catch (IllegalValueException e){
			fail("set up is invalid");
		}
	}
	
	@Test
	public void isSimilar_nullName() {
		assertFalse(name.isSimilar(null));
	}
	
	@Test
	public void isSimilar_sameName() {
		try {
			assertTrue(name.isSimilar(new Name("John Watson")));
		} catch (IllegalValueException e) {
			fail("new name is invalid");
		}
	}
	
	@Test
	public void isSimilar_sameNameCaseInsensitive() {
		try {
			assertTrue(name.isSimilar(new Name("JOhN WaTsOn")));
			assertTrue(name.isSimilar(new Name("JohN wAtSOn")));
			assertTrue(name.isSimilar(new Name("jOHn waTSOn")));
			assertTrue(name.isSimilar(new Name("john watson")));
			assertTrue(name.isSimilar(new Name("JOHN WATSON")));
		} catch (IllegalValueException e) {
			fail("new name is invalid");
		}
	}
	
	@Test
	public void isSimilar_sameNameCaseInsensitiveDifferentOrder() {
		try {
			assertTrue(name.isSimilar(new Name("WaTsOn JOhN")));
			assertTrue(name.isSimilar(new Name("watson john")));
			assertTrue(name.isSimilar(new Name("john WATSON")));
		} catch (IllegalValueException e) {
			fail("new name is invalid");
		}
	}
	
}



















