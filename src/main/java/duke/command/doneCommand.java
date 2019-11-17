package duke.command;

import duke.Exception.DukeException;
import duke.task.TaskList;
import duke.task.Storage;
import duke.task.Ui;

public class doneCommand extends Command {
    public int number;

    /**
     * Executes done command. Task will be marked as done
     * @param task
     * @param ui
     * @param storage
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        System.out.println("number sent"+ this.number + " total length is "+task.length());
        if( task.length() < this.number){
            throw new DukeException("☹ OOPS!!! Please enter a lesser number");
        }
        else{
            task.myTaskList.get(number-1).isDone = true;
            ui.doneMessage(task.myTaskList.get(number-1));
            storage.updateFile(task);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * constructor which initialize the number for which task is going to be marked done
     * @param number
     */
    public doneCommand(int number) {
        this.number = number;
    }
}
