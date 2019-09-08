import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the TaskList class.
 */
public class TaskListTest {
    @Test
    public void testAddTask() {
        TaskList taskList = new TaskList();
        ArrayList<Task> userList = new ArrayList<>();
        assertNotNull(userList);

        String taskDescription = "Submit thesis at school";
        Task todoWork = new Todo(taskDescription);

        // Adds contents of addTask.
        taskList.addTask(todoWork, userList);
        assertTrue(userList.size() == 1);
    }

    @Test
    public void testDeleteTask() {
        TaskList taskList = new TaskList();
        ArrayList<Task> userList = new ArrayList<>();

        Task todoWork = new Todo("Submit thesis at school");
        Task deadlineWork = new Deadline("Meet friends", "8am 12/12/12");

        taskList.addTask(todoWork, userList);
        taskList.addTask(deadlineWork, userList);
        assertTrue(userList.size() == 2);

        // Remove a task from the list
        taskList.deleteTask(0, userList);
        assertTrue(userList.size() == 1);

        assertTrue(userList.get(0) instanceof Task);
        assertTrue(userList.get(0) instanceof Deadline);
    }

    @Test
    public void testSetTaskComplete() {
        TaskList taskList = new TaskList();
        ArrayList<Task> userList = new ArrayList<>();

        Task todoWork = new Todo("Submit thesis at school");
        Task deadlineWork = new Deadline("Meet friends", "8am 12/12/12");

        taskList.addTask(todoWork, userList);
        taskList.addTask(deadlineWork, userList);

        String command = "done 1";

        // Task at index 1 should not be completed yet.
        assertTrue(todoWork.getStatusIcon() == "N");

        // Set index 1 to be complete.
        taskList.setTaskComplete(command.split(" "), userList);

        assertTrue(todoWork.getStatusIcon() == "Y");
    }
}
