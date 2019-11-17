package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Ui;

public abstract class Command {

    /**
     * abstract method execute . takes tasklist as input, UI for userinterface , storage for storing
     * @param task
     * @param ui
     * @param storage
     */
    public abstract void execute(TaskList task, Ui ui, Storage storage);
    public abstract  boolean isExit();
}
