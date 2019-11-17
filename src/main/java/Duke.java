import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        String[] list  = new String[100];
        String line;
        Scanner in = new Scanner(System.in);
        int count = 0;
        line = in.nextLine();

        String time = null;
        String[] toExtaction = null;
        String des =  null;

        // Create an array:
        ArrayList<task> myTaskList = new ArrayList<task>();
        while (!line.equals("bye"))
        {
            String switchCase = null;
//            list[count] = line;
            if(line == "list"){
                switchCase = "list";
            } else{
                String[] toExtaction1 = line.split(" ",2);
                toExtaction  = toExtaction1;
                switchCase = toExtaction[0];
            }

            switch (switchCase){
                case "list":
                    System.out.println("Here are the tasks in your list:");
                    straightline();
                    for (int a = 1; a <= count; a++){
                        System.out.println(a+" "+ myTaskList.get(a - 1).toString());
                    }
                    straightline();
                    break;
                case "done":
                    int number = Integer.parseInt(toExtaction[1]);
                    try{
                        if(number > count)
                            throw  new DukeException("☹ OOPS!!! The number must be less than count.");
                    } catch (DukeException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    myTaskList.get(number - 1).isDone = true;
                    System.out.println("Nice! I have marked this task as done:");
                    System.out.println(myTaskList.get(number - 1).toString());
                    break;

                case "todo":
                    try{
                        if(toExtaction.length == 1){
                            throw new DukeException ("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        des = toExtaction[1] ;
                        task task = new todo(des);
                        myTaskList.add(task);
                        System.out.println("Got it. I have added this task:");
                        System.out.println(myTaskList.get(count).toString());
                        count++;
                        System.out.println("Now you have "+count+" task in the list");
                        break;
                    }
                    catch(DukeException e ){
                        System.out.println(e.getMessage());
                        break;
                    }


                case "deadline":
                    try{
                        if(toExtaction.length ==1)
                            throw  new DukeException("☹ OOPS!!! The description of a Deadline cannot be empty.");
                    } catch (DukeException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    try{
                        String[] split= toExtaction[1].split("/by",2);
                        if(split.length ==1)
                            throw  new DukeException("☹ OOPS!!! The time of a Deadline cannot be empty.");
                        des = split[0];
                        time = split[1];
                        task deadline = new Deadline(des,time);
                        myTaskList.add(deadline);
                        System.out.println("Got it. I have added this task:");
                        System.out.println(myTaskList.get(count).toString());
                        count++;
                        System.out.println("Now you have "+count+" task in the list");

                    } catch(DukeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "event":
                    try{
                        if(toExtaction.length==1)
                            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                    } catch (DukeException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    try {
                        String[] split1 = toExtaction[1].split("/at", 2);
                        if(split1.length ==1)
                            throw  new DukeException("☹ OOPS!!! The time of a Event cannot be empty.");
                        des = split1[0];
                        time = split1[1];

                        task events = new Events(des, time);
                        myTaskList.add(events);
                        System.out.println("Got it. I have added this task:");
                        System.out.println(myTaskList.get(count).toString());
                        count++;
                        System.out.println("Now you have " + count + " task in the list");
                    }
                    catch(DukeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "delete":
                    int num = Integer.parseInt(toExtaction[1]);
                    try{
                        if(num > count)
                            throw  new DukeException("☹ OOPS!!! The number must be less than count.");
                    } catch (DukeException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(myTaskList.get(num - 1).toString());
                    myTaskList.remove(num-1);
                    System.out.println("Now you have "+ myTaskList.size() +" tasks in the list.");
                    count--;
                    break;

                default:
                    try {
                        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    } catch (DukeException e){
                        System.out.println(e.getMessage());
                    }
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }


    public static void straightline(){
        System.out.println("_______________________________________________________");
    }
}