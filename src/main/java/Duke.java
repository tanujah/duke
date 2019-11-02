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
        task[] myTaskList;

        // Create an array:
        myTaskList = new  task[10];

        while (!line.equals("bye"))
        {
//            list[count] = line;
            //splitting the input string for white spaces
            String[] arrOfStr = line.split(" ");
            //adding switch statement for input string
            switch (arrOfStr[0]){
                case "list": //printing all list elements
                    for (int a = 1; a <= count; a++){
                        System.out.println(a+". "+myTaskList[a-1].getStatusIcon()+" " + myTaskList[a-1].description);
                    }
                    break;
                case "done":
                    int number = Integer.parseInt(arrOfStr[1]);
                    myTaskList[number-1].isDone = true;
                    System.out.println("Nice! I have marked this task as done:");
                    System.out.println(myTaskList[number-1].getStatusIcon()+" "+myTaskList[number-1].description);
                    break;
                default:
                    System.out.println("added: " + line);
                    myTaskList[count] = new task(line);
                    count++;
                    break;
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}