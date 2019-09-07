/**
 * Class containing functions for interactions with user.
 */
public class UserInteraction {
    /** Lines to symbolize end of current activity */
    private static String lines = "__________________________________________________\n";

    /**
     * Says hello to user.
     */
    public void greeting() {
        String greet = "Hello! I'm Duke.\n" + "What can I do for you?\n";
        System.out.print(lines + greet + lines);
    }

    /**
     * Says goodbye to user.
     */
    public void farewell() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(bye);
        System.out.print(lines);
    }

    /**
     * Prints lines to mark the end of current activity.
     */
    public void printLines() {
        System.out.println(lines);
    }
}
