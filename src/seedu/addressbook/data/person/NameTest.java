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
			;
		}
	}
	
	@Test
	public void isSimilar_nullName() {
		assertFalse(name.isSimilar(null));
	}
}
