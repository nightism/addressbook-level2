package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
	
	public final String SYMBOL_ADD = "+";
	public final String SYMBOL_DELETE = "-";
	
	private Person owner;
	private Tag tag;
	private boolean status;
	
	public Tagging(Person owner, Tag tag, boolean status) {
		this.owner = owner;
		this.tag = tag;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return (this.status ? this.SYMBOL_ADD : this.SYMBOL_DELETE)
				+ this.owner.getName().toString() 
				+ this.tag.toString();
	}
}
