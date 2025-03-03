import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Class contains methods to read and write from text files.
 */
public class FileStorage {
    /** Stores path directory for file. */
    private static String Pathway;
    /** Reference to BufferedReader. */
    private BufferedReader brFileRead;
    /** ArrayList to store user inputs. */
    private static ArrayList<Task> userList;

    /**
     * Initializes the directory of file based on user inputs.
     *
     * @param pathway String containing the directory of file
     */
    FileStorage(String pathway) {
        this.Pathway = pathway;
    }

    /**
     * Reads in data as string from text file.
     */
    public ArrayList<Task> docReader() {
        // Processing stored file
        try {
            String textFromFile;

            userList = new ArrayList<Task>();
            this.brFileRead = new BufferedReader(new FileReader(Pathway));

            while ((textFromFile = brFileRead.readLine()) != null) {
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

        return userList;
    }


    /**
     * Writes data as string to text file.
     */
    public static void docWriter(ArrayList<Task> userList) {
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
