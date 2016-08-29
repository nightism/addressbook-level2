package seedu.addressbook.data.person;

public class Street {
	private final String value;
	
	public Street (String streetName) {
		this.value = streetName;
	}
	
	public String getStreet () {
		return this.value;
	}
}
