package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable
 */

public class Contact {
	
    public final String value;
    private boolean isPrivate;

    public Contact(String contact, boolean isPrivate, 
    		String constaints, String validationRegex) throws IllegalValueException {
    	
        this.isPrivate = isPrivate;
        
        if (!isValidContact(contact, validationRegex)) {
            throw new IllegalValueException(constaints);
        }
        
        this.value = contact;
    }

    /**
     * Returns true if a given string is a valid contact string.
     */
    public static boolean isValidContact(String test, String validationRegex) {
        return test.matches(validationRegex);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
}
