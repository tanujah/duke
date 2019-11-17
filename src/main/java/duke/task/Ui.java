package duke.task;

import java.util.Scanner;

public class Ui {
    String fullcommand;

    /**
     *
     * @return string :-  read lines which user inputs
     */

    public String readCommand(){
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        return line;
    }

    /**
     * function just for showing loading error
     */
    public void showLoadingError(){
        System.out.println("Problem with loading");
    }

    /**
     * Shows the welcome message
     */
    public void welcomeMessage(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    public  void showLine(){
        System.out.println("________________________________________________________");
    }

    /**
     *
     * @param message
     * print the error message which is sent.
     */
    public void  showError(String message){
        System.out.println(message);
    }

    /**
     *
     * @param task print the task
     */
    public  void  showMessage(task task){
        System.out.println(task.toString());
    }

    /**
     *
     * @param task
     * @param num
     * print message even ever a new task is added
     */
    public  void  addedTask(task task, int num){
        System.out.println("Got it. I've added this task");
        this.showMessage(task);
        System.out.println("Now you have " +num+ " tasks in the list.");

    }

    /**
     * Print the list of all task
     * @param task whic is a tasklist type
     */
    public void showlist(TaskList task){
        int length = task.length();
        System.out.println("Here are the tasks in your list:");
        for(int i =0; i< length;i++){
            System.out.println((i+1)+"."+task.myTaskList.get(i).toString());
        }
    }

    /**
     * print bye message
     */
    public  void  byeMessage(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * print done message
     * @param task
     */
    public  void  doneMessage(task task){
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(task.toString());
    }

    /**
     * print the delete message
     * @param task
     * @param num
     */
    public  void deleteMessage(task task, int num){
        System.out.println("Nice! I've removed this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " +(num-1)+ " tasks in the list.");
    }
}
