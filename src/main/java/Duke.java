import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static ArrayList<Task> userList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String lines = "__________________________________________________\n";
        String greet = "Hello! I'm Duke.\n" + "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!";

        // Introductory greeting
        System.out.print(lines + greet + lines);

        while (s.hasNext()) {
            // Obtain inputs from users as a string
            String userInputs = s.nextLine();

            // The limit is extremely important here
            String[] userInputsArray = userInputs.split(" ", 2);
            String userControl = userInputsArray[0];

            if (userControl.equals("bye")) {
                System.out.println(bye);
                System.out.print(lines);
                break;

            } else if (userControl.equals("list")) {
                System.out.println("Here are the tasks in your list:");

                for (int i = 0; i < userList.size(); ++i) {
                    Task currentTask = userList.get(i);

                    // New modifications to the display
                    System.out.println(i + 1
                            + "."
                            + currentTask.toString()
                    );
                }

            } else if (userControl.equals("done")) {
                // Accounting for 1 base index position
                int taskIndex = Integer.parseInt(userInputsArray[1]) - 1;
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
                // For other tasks i.e. Deadline, Todo, Event
                String[] commands = {"deadline", "event", "todo"};

                Task work;

                // Different commands
                if (userControl.equals("deadline")) {
                    // For case of event
                    String[] keyPhrase = userInputsArray[1].split(" /by ");

                    work = new Deadline(keyPhrase[0], keyPhrase[1]);

                    userList.add(work);
                    System.out.print("Got it. I've added this task:\n ");
                    System.out.println(work.toString());
                    System.out.println("Now you have " + userList.size() + " tasks in the list.");

                } else if (userControl.equals("event")) {
                    // For case of deadline
                    String[] keyPhrase = userInputsArray[1].split(" /at ");

                    work = new Event(keyPhrase[0], keyPhrase[1]);

                    userList.add(work);
                    System.out.print("Got it. I've added this task:\n ");
                    System.out.println(work.toString());
                    System.out.println("Now you have " + userList.size() + " tasks in the list.");

                } else if (userControl.equals("todo")) {

                    // Exception handling
                    try {
                        work = new Todo(userInputsArray[1]);
                        userList.add(work);

                        System.out.print("Got it. I've added this task:\n ");
                        System.out.println(work.toString());
                        System.out.println("Now you have " + userList.size() + " tasks in the list.");

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("OOPS!!! The description of a todo cannot be empty.");
                    }

                } else {
                    // For invalid inputs
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }

            }

            System.out.print(lines);
        }

    }
}

