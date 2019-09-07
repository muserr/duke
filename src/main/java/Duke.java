/**
 * Main class of Duke program.
 */
public class Duke {
    /** Pathway for file storage */
    private static final String Pathway = "E:\\Ben\\CS2113T_workspace\\duke\\data\\duke.txt";

    //private static final String Pathway = "D:\\Ben\\CS2113T_workspace\\duke\\data\\duke.txt";
    /** Reference for FileStorage */
    private static FileStorage storage;
    /** Reference for UserInteraction */
    private static UserInteraction userInteraction;

    /**
     * Processes the main function of Duke.
     *
     * @param args Obtains input from command line
     */
    public static void main(String[] args) {
        dukeRun();
    }

    /**
     * Initiates the start of Duke program.
     */
    public static void dukeRun() {
        storage = new FileStorage(Pathway);
        Parser parser = new Parser(Pathway);
        userInteraction = new UserInteraction();
        userInteraction.greeting();
        // Processing instructions from the list, takes in an ArrayList
        parser.run(storage.docReader());
    }
}
