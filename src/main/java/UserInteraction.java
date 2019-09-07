/**
 * Class containing functions for interactions with user.
 */
public class UserInteraction {

    private static String lines = "__________________________________________________\n";

    /**
     * Introductory greeting towards user.
     */
    public void greeting() {
        String greet = "Hello! I'm Duke.\n" + "What can I do for you?\n";
        System.out.print(lines + greet + lines);
    }

    /**
     * Farewell greeting towards user.
     */
    public void farewell() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(bye);
        System.out.print(lines);
    }

    /**
     * Method printing lines marking next activity.
     */
    public void printLines() {
        System.out.println(lines);
    }
}
