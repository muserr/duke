import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to parse and tokenize user commands.
 */
public class Parser {
    private static Scanner s = new Scanner(System.in);

    private FileStorage fs;
    private TaskList taskList;
    private UserInteraction userInteraction;

    /**
     * Constructor to create new objects for FileStorage,
     * TaskList and UserInteraction.
     *
     * @param pathway String containing the directory of file
     */
    Parser(String pathway) {
        fs = new FileStorage(pathway);
        taskList = new TaskList();
        userInteraction = new UserInteraction();
    }

    /**
     * Method reading and interpreting user inputs.
     *
     * @param userList List containing tasks from user
     */
    public void run(ArrayList<Task> userList) {

        // Read in additional userInputs
        while (s.hasNext()) {
            // Obtain inputs from users as a string and trim
            String userInputs = s.nextLine().trim();

            // The limit of 2 is extremely important here
            String[] userInputsArray = userInputs.split(" ", 2);
            String userControl = userInputsArray[0];

            try {
                if (userControl.equals("bye")) {
                    userInteraction.farewell();
                    break;

                } else if (userControl.equals("list")) {
                    taskList.displayList(userList);

                } else if (userControl.equals("done")) {
                    taskList.taskDone(userInputsArray, userList);

                } else if (userControl.equals("delete")) {
                    try {
                        int indexForDeletion = Integer.parseInt(userInputsArray[1]) - 1;

                        taskList.deleteTask(indexForDeletion, userList);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Please enter a valid index");
                    }

                } else if (userControl.equals("find")) {
                    try {
                        // Finding by keyword
                        String keyword = userInputsArray[1];

                        // Searching and displaying values
                        taskList.displaySearch(keyword, userList);

                    } catch (NullPointerException | IndexOutOfBoundsException e) {
                        System.out.println("Your search keyword cannot be empty");
                    }

                } else {
                    // For other tasks i.e. Deadline, Todo, Event
                    if (userControl.equals("deadline")) {
                        // For case of event
                        String[] keyPhrase = userInputsArray[1].split(" /by ");
                        Deadline work = new Deadline(keyPhrase[0], keyPhrase[1]);

                        taskList.addSuccess(work, userList);

                    } else if (userControl.equals("event")) {
                        // For case of deadline
                        String[] keyPhrase = userInputsArray[1].split(" /at ");
                        Event work = new Event(keyPhrase[0], keyPhrase[1]);

                        taskList.addSuccess(work, userList);

                    } else if (userControl.equals("todo")) {
                        // Exception handling
                        try {
                            Todo work = new Todo(userInputsArray[1]);
                            taskList.addSuccess(work, userList);

                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("OOPS!!! The description of a todo cannot be empty.");
                        }

                    } else {
                        // For invalid inputs
                        throw new IllegalArgumentException();
                    }

                    // Automatically save data into a file
                    fs.docWriter(userList);

                }
            } catch (IllegalArgumentException e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

            userInteraction.printLines();
        }
    }
}
