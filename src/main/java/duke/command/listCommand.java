package duke.command;

import duke.task.TaskList;
import duke.task.Storage;
import duke.task.Ui;

public class listCommand extends Command {


    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        ui.showlist(task);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
