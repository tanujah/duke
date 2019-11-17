package duke.task;

import duke.Exception.DukeException;
import duke.command.*;

import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser   {

    /**
     * Parsing the external file for the first time when the programme is loaded
     * it converts the input text and interpret accordingly
     * @param inputText
     * @return
     */
    public static task parseInputFromExternalFile(String inputText){
        String des;
        String time;
        String done;
        String[] split1 ={};

        try{
            split1= inputText.split("\\|");
        } catch (Exception e) {
            System.out.println("problem with split");
        }
        String switchcase = split1[0].trim();
        switch (switchcase){
            case "E":
                des = split1[2].trim();
                time = split1[3].trim();
                LocalDateTime now= LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));

                Events events = new Events(des,time,now);
                done = split1[1].trim();
                if(done.equals("1"))
                    events.isDone=true ;
                else
                    events.isDone=false;
                return  events;

            case "D":
                des = split1[2].trim();
                time = split1[3].trim();
                LocalDateTime now1= LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
                Deadline deadline = new Deadline(des,time,now1);

                done = split1[1].trim();
                if(done.equals("1"))
                    deadline.isDone=true ;
                else
                    deadline.isDone=false;
                return  deadline;

            case "T":
                des = split1[2].trim();
                todo todo = new todo(des);

                done = split1[1].trim();
                if(done.equals("1"))
                    todo.isDone=true ;
                else
                    todo.isDone=false;;
                return  todo;

        }
        return  null;
    }


    /**
     * it takes the input as string which is given by the use in the console
     * and try to extract meaning out of it and create task accordingly
     * @param fullCommand
     * @return
     */
    public static Command parse(String fullCommand) {
        if(fullCommand.equals("bye")){
            ByeCommand bye = new ByeCommand();
            return bye;
        }
        else if(fullCommand.equals("list")){
            listCommand list =new listCommand();
            return list;
        }
        else {
            String[] toExtaction1 = fullCommand.split(" ",2);
            switch ( toExtaction1[0]){
                case "list":
                    listCommand list = new listCommand();
                    return list;
                case "done":
                        if(toExtaction1.length==1){
                            throw new DukeException("☹ OOPS!!! Please enter number.");
                        }

                        try {
                            int number = Integer.parseInt(toExtaction1[1]);
                            doneCommand done = new doneCommand(number);
                            return  done;
                        } catch ( DukeException e)
                        {
                            throw new DukeException("☹ OOPS!!! Please validnumber.");
                        }

                case "todo":
                    try{
                        String des= toExtaction1[1];
                        AddCommand t = new AddCommand(1,des);
                        return t;
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");

                    }
                case "deadline":
                    try{
                        String temp =  toExtaction1[1];
                    } catch (ArrayIndexOutOfBoundsException e){
                        throw  new DukeException("☹ OOPS!!! The description of a Deadline cannot be empty.");

                    }
                    try{
                        String[] split= toExtaction1[1].split("/by",2);
                        String des = split[0];
                        String time = split[1];
                        LocalDateTime now;
                        try {
                            time = time.trim();
                            now= LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
                        } catch (DateTimeParseException e){
                            throw  new DukeException("☹ OOPS!!! Please enter the date and time in YYYY-MM-dd HHMM formate");
                        }
                        AddCommand D = new AddCommand(2,des,time,now);
                        return D;
                    } catch(ArrayIndexOutOfBoundsException e){
                        throw new DukeException("☹ OOPS!!! The time of a Deadline cannot be empty.");
                    }
                case "event":
                    try{
                        String temp= toExtaction1[1];
                    } catch (ArrayIndexOutOfBoundsException e){
                        throw  new  DukeException("☹ OOPS!!! The description of a event cannot be empty.");

                    }
                    try{
                        String[] split1= toExtaction1[1].split("/at",2);
                        String des1 =split1[0];
                        String time = split1[1];
                        LocalDateTime now;
                        try {
                            time = time.trim();
                            now= LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
                        } catch (DateTimeParseException e){
                            throw  new DukeException("☹ OOPS!!! Please enter the date and time in YYYY-MM-dd HHMM formate");
                        }
                        AddCommand E = new AddCommand(3,des1,time,now);
                        return  E;
                    } catch (ArrayIndexOutOfBoundsException e)
                    {
                        throw  new DukeException("☹ OOPS!!! The time of a event cannot be empty.");
                    }

                case "delete":
                    try {
                        int num = Integer.parseInt(toExtaction1[1]);
                        DeleteCommand delete = new DeleteCommand(num-1);
                        return  delete;
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        throw new  DukeException("☹ OOPS!!! The number must be specified for deletion.");

                    }
                default:
                    throw  new  DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }

    }
}
