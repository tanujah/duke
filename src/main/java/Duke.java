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
        String time = null;
        String[] toExtaction = null;
        String des =  null;
        // Create an array:
        myTaskList = new  task[10];

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
                    for (int a = 1; a <= count; a++){
                        System.out.print(a+" ");myTaskList[a-1].taskprint();
                    }
                    break;
                case "done":
                    int number = Integer.parseInt(toExtaction[1]);
                    myTaskList[number-1].isDone = true;
                    System.out.println("Nice! I have marked this task as done:");
                    myTaskList[number-1].taskprint();
                    break;
                case "todo":
                    des= toExtaction[1];
                    myTaskList[count] = new task(des,'T');
                    System.out.println("Got it. I have added this task:");
                    myTaskList[count].taskprint();
                    count++;
                    System.out.println("Now you have "+count+" task in the list");
                    break;
                case "deadline":
                    String[] split= toExtaction[1].split("/by",2);
                    des = split[0];
                    time = split[1];
                    myTaskList[count] = new task(des,'D');
                    myTaskList[count].settime(time);
                    System.out.println("Got it. I have added this task:");
                    myTaskList[count].taskprint();
                    count++;
                    System.out.println("Now you have "+count+" task in the list");
                    break;
                case "event":
                    String[] split1= toExtaction[1].split("/at",2);
                    des = split1[0];
                    time = split1[1];
                    myTaskList[count] = new task(des,'E');
                    myTaskList[count].settime(time);
                    System.out.println("Got it. I have added this task:");
                    myTaskList[count].taskprint();
                    count++;
                    System.out.println("Now you have "+count+" task in the list");
                    break;
                default:
                    System.out.println("something went wrong");
                    break;
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
