package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.lang.String;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact{

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must in the format : a/BLOCK, STREET, UNIT, POSTAL CODE ";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Class Implementation of BLOCK, STREET, UNIT, POSTAL CODE
     * The address string will be split into the sub-address members
     */
     private Block blk;
     private Street street;
     private Unit unit;
     private PostalC postalC;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;

        splitAddress(value);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    /**
     * Splits the address into the sub address BLOCK,STREET,UNIT,POSTAL CODE and
     * initialize the class objects associated with the sub-address accordingly
     * @param address
     */
    public void splitAddress(String address){
        String[] subAddress = address.split(", ");

        blk = new Block(subAddress[0]);
        street = new Street(subAddress[1]);
        unit = new Unit(subAddress[2]);
        postalC = new PostalC(subAddress[3]);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
