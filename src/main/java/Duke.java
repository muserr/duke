import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> userList = new ArrayList<String>();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String lines = "________________________________________\n";
        String greet = "Hello! I'm Duke.\n" + "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!";

        System.out.println("Hello from\n" + logo);

        // Introductory greeting
        System.out.print(lines + greet + lines);

        while (s.hasNext()) {
            // Obtain inputs from users as a string
            String userInputs = s.nextLine();

            if (userInputs.toLowerCase().equals("bye")) {
                System.out.println(bye);
                System.out.print(lines);
                break;
            } else if (userInputs.toLowerCase().equals("list")) {
                for (int i = 0; i < userList.size(); ++i) {
                    System.out.println(i + 1 + ". " + userList.get(i));
                }
            } else {
                userList.add(userInputs);

                // Displaying user inputs back to user
                System.out.println("added: " + userInputs);
            }

            System.out.print(lines);
        }
    }
}
