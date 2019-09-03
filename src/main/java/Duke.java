import java.util.ArrayList;

public class Duke {
    //private static ArrayList<Task> userList = new ArrayList<>();

    private static final String Pathway = "E:\\Ben\\CS2113T_workspace\\duke\\data\\duke.txt";

    private static FileStorage storage;
    private static UserInteraction userInteraction;

    // Main function of Duke
    public static void main(String[] args) {
        dukeRun();
    }

    public static void dukeRun() {
        storage = new FileStorage(Pathway);
        Parser parser = new Parser(Pathway);
        userInteraction = new UserInteraction();
        userInteraction.greeting();
        // Processing instructions from the list, takes in an ArrayList
        parser.run(storage.docReader());
    }
}
