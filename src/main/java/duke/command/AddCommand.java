package duke.command;

import duke.task.*;

import java.time.LocalDateTime;

public class AddCommand extends Command {
    public  int type;
    public String des;
    public  String time;
    public LocalDateTime localtime;
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {

        switch (type) {
            case 1:
                todo e = new todo(des);
                task.addTasktoList(e);
                ui.addedTask(e,task.length());
                break;
            case 2:
                Deadline D  = new Deadline(des,time,localtime);
                task.addTasktoList(D);
                ui.addedTask(D,task.length());
                break;
            default:
                Events E = new Events(des,time,localtime);
                task.addTasktoList(E);
                ui.addedTask(E,task.length());
                break;
        }

        storage.updateFile(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * AddCommand constructor when sending type, descritption , time as in string and time in LocalDateTime
     * @param type
     * @param des
     * @param time
     * @param localtime
     */
    public AddCommand(int type, String des, String time,LocalDateTime localtime) {
        this.type = type;
        this.des = des;
        this.time = time;
        this.localtime= localtime;
    }

    /**
     * Constructor with only type and description
     * @param type
     * @param des
     */
    public AddCommand(int type, String des) {
        this.type = type;
        this.des = des;
        this.time= null;
    }
}
