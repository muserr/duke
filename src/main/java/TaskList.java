import java.util.ArrayList;

public class TaskList {

    /**
     * When users requires content of list to be displayed
     */
    public void displayList(ArrayList<Task> userList) {
        System.out.println("Here are the tasks in your list:");
        displayTasks(userList);
    }

    public void displaySearch(String keyword, ArrayList<Task> userList){
        ArrayList<Task> searchList = new ArrayList<Task>();

        for (Task taskQuery : userList) {
            // Find task by substring
            if (taskQuery.descriptionSearch(keyword)) {
                searchList.add(taskQuery);
            }
        }
        System.out.println("Here are the matching tasks in your list for \"" + keyword + "\":");
        displayTasks(userList);
    }

    public void displayTasks(ArrayList<Task> list) {
        for (int i = 0; i < list.size(); ++i) {
            Task currentTask = list.get(i);

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
    public static void taskDone(String[] userInputsArray, ArrayList<Task> userList) {
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

    public static void addSuccess(Task job, ArrayList<Task> userList) {
        userList.add(job);
        System.out.print("Got it. I've added this task:\n ");
        System.out.println(job.toString());
        System.out.println("Now you have " + userList.size() + " tasks in the list.");
    }

    public static void deleteTask(int index, ArrayList<Task> userList) throws IndexOutOfBoundsException {
        String info = userList.get(index).toString();
        userList.remove(index);
        System.out.print("Noted. I've removed this task:\n ");
        System.out.println(info);
        System.out.println("Now you have " + userList.size() + " tasks in the list.");
    }
}
