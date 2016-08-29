package seedu.addressbook.data.person;

public class Unit {
	private final String value;
	
	public Unit (String unitName) {
		this.value = unitName;
	}
	
	public String getUnit () {
		return this.value;
	}
}
