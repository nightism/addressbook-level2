package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }
    
    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if ...
     */
	public boolean isSimilar(Name other) {
		if (other == null) {
			// other is null
			return false;
		} else {
			String thisName = this.toString().toLowerCase();
			String otherName = other.toString().toLowerCase();

			Set<String> allWorldsInThisName = new HashSet<String>(Arrays.asList(thisName.split(" ")));
			Set<String> allWorldsInOtherName = new HashSet<String>(Arrays.asList(otherName.split(" ")));

			if (allWorldsInThisName.containsAll(allWorldsInOtherName)) {
				return true;
			} else if (allWorldsInOtherName.containsAll(allWorldsInThisName)) {
				return true;
			} else {
				return isOverlapped(allWorldsInThisName, allWorldsInOtherName);
			}
		}
	}

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    /**
	 * Returns true if there is overlap between 2 sets
	*/
	private boolean isOverlapped(Set<String> setOne, Set<String> setTwo) {
		int sizeOfOne = setOne.size();

		setOne.removeAll(setTwo);
		if (setOne.size() < sizeOfOne) {
			return true;
		} else {
			return false;
		}
	}

}
