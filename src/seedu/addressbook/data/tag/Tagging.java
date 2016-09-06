package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

public class Tagging {
	
	public final String SYMBOL_ADD = "+";
	public final String SYMBOL_DELETE = "-";
	
	private ReadOnlyPerson owner;
	private Tag tag;
	private boolean status;
	
	public Tagging(ReadOnlyPerson owner, Tag tag, boolean status) {
		this.owner = owner;
		this.tag = tag;
		this.status = status;
	}
	
	public ReadOnlyPerson getOwner() {
		return this.owner;
	}
	
	public Tag getTag() {
		return this.tag;
	}
	
	public void reverseStatus() {
		this.status = !this.status;
	}
	
	@Override
	public String toString() {
		return (this.status ? this.SYMBOL_ADD : this.SYMBOL_DELETE)
				+ this.owner.getName().toString() 
				+ this.tag.toString();
	}
	
	public static ArrayList<Tagging> preprocessExistingTags(UniquePersonList persons) {
		ArrayList<Tagging> taggings = new ArrayList<Tagging>();
		for(Person p : persons) {
			UniqueTagList thisTagList = p.getTags();
			for(Tag t : thisTagList) {
				taggings.add(new Tagging(p, t, true));
			}
		}
		return taggings;
	}
}














