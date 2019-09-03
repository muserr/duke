import java.io.*;
import java.util.ArrayList;

public class FileStorage {

    private static String Pathway;
    // private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private BufferedReader brFileRead;

    // Declare userList as a static variable
    private static ArrayList<Task> userList;

     FileStorage(String pathway) {
         this.Pathway = pathway;
     }

    /**
     * Reading in lines from Text.file
     */
    public ArrayList<Task> docReader(){
        // Processing stored file
        try {
            String textFromFile;

            userList = new ArrayList<Task>();
            this.brFileRead = new BufferedReader(new FileReader(Pathway));

            while ((textFromFile = brFileRead.readLine()) != null) {
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

        return userList;
    }


    /**
     * Writing lines to Text file
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
