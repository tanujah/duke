package duke.command;

import duke.Exception.DukeException;
import duke.task.TaskList;
import duke.task.Storage;
import duke.task.Ui;

public class DeleteCommand extends Command {
    public int number;
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {

        if(number >= task.length())
            throw  new DukeException("☹ OOPS!!! Please enter a lesser number");


        ui.deleteMessage(task.myTaskList.get(this.number),task.length());
        task.removeTaskfromList(this.number);
        storage.updateFile(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public DeleteCommand(int num) {
            if(num <= 0)
                throw new DukeException("☹ OOPS!!! Please enter a higher number");
            this.number= num;
    }
}
