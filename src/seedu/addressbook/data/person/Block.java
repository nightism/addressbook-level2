package seedu.addressbook.data.person;

/**
 * Represents a Person's block name.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */

public class Block {
	private final String value;
	
	public Block (String blockName) {
		this.value = blockName;
	}
	
	public String getBlock () {
		return this.value;
	}
}