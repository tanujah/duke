package duke.task;

import duke.task.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TaskList {


    public List<task> myTaskList ;

    /**
     * Tasklist constructor which takes the list of task which are already in the data file
     * @param incomingList
     */
    public TaskList(List<task> incomingList) {
        myTaskList = new ArrayList<>();
        for (task temp : incomingList) {
            myTaskList.add(temp);
        }
    }

    /**
     * default constructor
     */
    public TaskList() {
        myTaskList = new ArrayList<>();
    }

    /**
     * returns the length of task elements present in the list
     * @return
     */
    public int length(){
        return myTaskList.size();
    }

    /**
     * adding task to the arraylist
     * @param e task
     */
    public  void addTasktoList(task e){
        this.myTaskList.add(e);
    }

    /**
     * Remove task from the list
     * @param e
     */
    public void removeTaskfromList(int e){
        this.myTaskList.remove(e);
    }
}
