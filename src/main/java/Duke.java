import duke.Exception.DukeException;
import duke.command.Command;
import duke.task.TaskList;
import duke.task.Parser;
import duke.task.Storage;
import duke.task.Ui;

public class Duke {

    private Storage storage;
    private Ui ui;
    private TaskList tasks;

    /**
     *
     * @param filePath  the path of the file where the data is going to store
     */

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Main programme which runs continuously until user enters bye command
     *
     */
    private void run() {
        ui.welcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }

}
