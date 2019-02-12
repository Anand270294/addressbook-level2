package seedu.addressbook.data.person;

public class Contact {
    private String value;
    private boolean isPrivate;

    public Contact(){
    }
    public String toString() {
        return value;
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setValue(String value){
        this.value = value;
    }

    public void setisPrivate(boolean isPrivate){
        this.isPrivate = isPrivate;
    }
}
