package duke.command;

import duke.task.TaskList;
import duke.task.Storage;
import duke.task.Ui;


public class ByeCommand extends Command {


    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        ui.byeMessage();

    }

    @Override
    public boolean isExit() {
        return true;
    }
}
