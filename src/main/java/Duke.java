import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static ArrayList<Task> userList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

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
                System.out.println("Here are the tasks in your list:");

                for (int i = 0; i < userList.size(); ++i) {
                    Task currentTask = userList.get(i);
                    System.out.println(i + 1
                            + ".["
                            + currentTask.getStatusIcon()
                            + "] "
                            + currentTask.getStatusDescription()
                    );
                }
            } else if (userInputs.toLowerCase().substring(0, 4).equals("done")) {
                // Your input will be "done index_position (1 base)"
                String task = userInputs.substring(5);

                // Accounting for 1 base index position
                int taskIndex = Integer.parseInt(task) - 1;
                Task currentTask = userList.get(taskIndex);

                // Setting task status as complete
                currentTask.setComplete();

                // Display result back to user
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("["
                        + currentTask.getStatusIcon()
                        + "] "
                        + currentTask.getStatusDescription()
                );

            } else {
                // Default initialization of tasks as incomplete
                Task newUserTask = new Task(userInputs);
                userList.add(newUserTask);

                // Displaying user inputs back to user
                System.out.println("added: " + userInputs);
            }

            System.out.print(lines);
        }
    }

}

