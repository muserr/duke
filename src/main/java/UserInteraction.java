// Displaying dialogue with user
public class UserInteraction {

    private static String lines = "__________________________________________________\n";

    public void greeting() {
        // Introductory greeting
        String greet = "Hello! I'm Duke.\n" + "What can I do for you?\n";
        System.out.print(lines + greet + lines);
    }

    public void farewell() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(bye);
        System.out.print(lines);
    }

    public void printLines() {
        System.out.println(lines);
    }

}
