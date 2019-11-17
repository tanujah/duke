package duke.task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    protected  String path;
    String directory = System.getProperty("user.home");


    /**
     * loading the external file
     * if already data is present in the external file conver the string data to the task and add it to the tasklist
     * retrun the final list of task
     * @return
     */
    public List<task> load() {
        List<task> inputList = new ArrayList<>();
        try {

           //FileReader file = new FileReader(path);
           File file = new File(path);

           BufferedReader br = new BufferedReader(new FileReader(file));
           String st;
           while ((st = br.readLine()) != null){
               System.out.println(st);
               task task = null;
               task = Parser.parseInputFromExternalFile(st);
               inputList.add(task);
           }
       } catch (FileNotFoundException F) {
           System.out.println("FIle not found creating a new file");

       } catch (IOException e) {
           e.printStackTrace();
       }
       return  inputList;
    }

    /**
     * update the external file
     * tasklist is sent and the external file will be updated according to the input list sent
     * @param task
     */
    public void updateFile(TaskList task){
        File file = new File(path);
        FileWriter fr = null;
        try {
            fr= new FileWriter(file);
            for(int i = 0 ;i < task.length();i++){
                //String message = task.myTaskList.get(i).forFile();
                fr.write(task.myTaskList.get(i).forFile());
                fr.write(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Storage constructor which sets the path
     * @param path
     */
    public Storage(String path) {
        this.path = directory+File.separator+path;
    }
}
