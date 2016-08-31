package seedu.addressbook.ui;

/**
 * Formatting text for display
 */

public class Formatter {
	
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
	private static final String LINE_PREFIX = "|| ";
	
	/** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    public String linePrefix() {
    	return this.LINE_PREFIX;
    }
    
    public String lineSeperator() {
    	return this.LS;
    }
    
    public String divider(){
    	return this.DIVIDER;
    }
    
    public String indexedItemFormat() {
    	return this.LINE_PREFIX;
    }
    
    public int indexOffset() {
    	return this.DISPLAYED_INDEX_OFFSET;
    }
    
    public String commentLineFormat() {
    	return this.COMMENT_LINE_FORMAT_REGEX;
    }
    
}











