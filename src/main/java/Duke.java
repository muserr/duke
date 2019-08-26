import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static ArrayList<Task> userList = new ArrayList<>();

    private static final String Pathway = "F:\\JK\\CS2113T_workspace\\duke\\data\\duke.txt";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String lines = "__________________________________________________\n";
        String greet = "Hello! I'm Duke.\n" + "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!";

        // Introductory greeting
        System.out.print(lines + greet + lines);

        // Read in files from given pathway
        docReader();

        // Read in additional userInputs
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
                displayList();

            } else if (userControl.equals("done")) {
                taskDone(userInputsArray);

            } else {
                // For other tasks i.e. Deadline, Todo, Event
                if (userControl.equals("deadline")) {
                    // For case of event
                    String[] keyPhrase = userInputsArray[1].split(" /by ");

                    Deadline work = new Deadline(keyPhrase[0], keyPhrase[1]);
                    addSuccess(work);

                } else if (userControl.equals("event")) {
                    // For case of deadline
                    String[] keyPhrase = userInputsArray[1].split(" /at ");

                    Event work = new Event(keyPhrase[0], keyPhrase[1]);
                    addSuccess(work);

                } else if (userControl.equals("todo")) {

                    // Exception handling
                    try {
                        Todo work = new Todo(userInputsArray[1]);
                        addSuccess(work);

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

        // Writing contents of userList to file
        docWriter();
    }

    /**
     * When users requires content of list to be displayed
     */
    public static void displayList() {
        System.out.println("Here are the tasks in your list:");

        for (int i = 0; i < userList.size(); ++i) {
            Task currentTask = userList.get(i);

            // New modifications to the display
            System.out.println(i + 1
                    + "."
                    + currentTask.toString()
            );
        }
    }

    /**
     * For task that has been considered complete
     * @param userInputsArray Array consisting of string tokens
     */
    public static void taskDone(String[] userInputsArray) {
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
    }

    public static void addSuccess(Task job) {
        userList.add(job);
        System.out.print("Got it. I've added this task:\n ");
        System.out.println(job.toString());
        System.out.println("Now you have " + userList.size() + " tasks in the list.");
    }

    /**
     * Reading in lines from Text.file
     */
    public static void docReader() {
        // Processing stored file
        try {
            BufferedReader br = new BufferedReader(new FileReader(Pathway));
            String textFromFile;

            while ((textFromFile = br.readLine()) != null) {
                // System.out.println(textFromFile);

                // Parse text into Task readable objects
                String[] textArray = textFromFile.split("\\|");

                // Trim values from textArray
                for (int i = 0; i < textArray.length; ++i) {
                    textArray[i] = textArray[i].trim();
                }

                if (textArray[0].equals("todo")) {
                    // todo | boolean | description
                    Task tempTask = new Todo(textArray[1], textArray[2]);
                    userList.add(tempTask);

                } else if (textArray[0].equals("event")) {
                    // event | boolean | description | at | destination
                    Task tempTask = new Event(textArray[1], textArray[2], textArray[4]);
                    userList.add(tempTask);

                } else if (textArray[0].equals("deadline")) {
                    // deadline | boolean | description | by | date
                    Task tempTask = new Deadline(textArray[1], textArray[2], textArray[4]);
                    userList.add(tempTask);
                }

            }

        } catch (IOException e) {
            System.out.println("\n!!!!!!Enter a valid file name!!!!!!\n");
        }
    }

    /**
     * Writing lines to Text file
     */
    public static void docWriter() {
        // Obtain user inputs and write to file
        try {
            // False to override the file
            Writer fileWriter = new FileWriter(Pathway, false);

            for (Task userTask : userList) {
                StringBuilder sb = new StringBuilder();

                sb.append(userTask.lineWriter()).append(System.lineSeparator());
                fileWriter.write(sb.toString());
            }

            fileWriter.close();

        } catch (IOException e) {
            System.out.println("!!! FILE NOT PRESENT !!!");
        }
    }
}
