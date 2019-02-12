package seedu.addressbook.commands;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list according to user preference. "
            + "List can be sorted by name, email or address.\n"
            + "Parameters: Type of sort[name/email/address]\n"
            + "Example: " + COMMAND_WORD
            + " name";

    public static final String MESSAGE_SUCCESS = "The list is sorted!";
    public static final String MESSAGE_INVALID_ARGUMENT = "Invalid Argument produced; please use valid arguments";
    public static final String MESSAGE_ERROR_UNSORTABLE = "Bruh the list is empty man.......";

    private String type;

    public SortCommand(String type){
        this.type = type.trim();
    }

    @Override
    public CommandResult execute(){
        if(type.equals("name") || type.equals("email") || type.equals("address")) {
            boolean isSorted = addressBook.sort(this.type);

            if(isSorted){
                return new CommandResult(MESSAGE_SUCCESS);
            }else{
                return new CommandResult(MESSAGE_ERROR_UNSORTABLE);
            }
        }else{
            return new CommandResult(MESSAGE_INVALID_ARGUMENT);
        }
    }
}
