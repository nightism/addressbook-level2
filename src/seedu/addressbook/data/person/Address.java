package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    private static final int ADDRESS_INDEX_BLOCK = 0;
    private static final int ADDRESS_INDEX_STREET = 1;
    private static final int ADDRESS_INDEX_UNIT = 2;
    private static final int ADDRESS_INDEX_POSTAL = 3;
    
    //public final String value;
    public final String[] addressComponents;
    private boolean isPrivate;
    
    // four components of the address line
    public final Block blockName;
    public final Street streetName;
    public final Unit unitNumber;
    public final PostalCode postalCode;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        //this.value = address;
        
        this.addressComponents = address.split(", ");
        if (!isValidAddress(this.addressComponents)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.blockName = new Block(addressComponents[ADDRESS_INDEX_BLOCK]);
        this.streetName = new Street(addressComponents[ADDRESS_INDEX_STREET]);
        this.unitNumber = new Unit(addressComponents[ADDRESS_INDEX_UNIT]);
        this.postalCode = new PostalCode(addressComponents[ADDRESS_INDEX_POSTAL]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    
    public static boolean isValidAddress(String[] test) {
    	return test.length == 4 ;
    	
    }

    @Override
    public String toString() {
        return this.blockName.getBlock() + ", "
        		+ this.streetName.getStreet() + ", "
        		+ this.unitNumber.getUnit() + ", "
        		+ this.postalCode.getPostalCode();
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public String getValue() {
    	return this.toString();
    }

}