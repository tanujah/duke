package duke.task;


public class todo extends  task{
    protected  String by;

    /**
     * todo class constructor
     * @param description description for the task
     */
    public todo(String description) {
        super(description);

    }

    /**
     * returning the string
     * @return the description value along with the symbol
     */
    @Override
    public  String toString(){
        return "[T] "+super.toString();
    }

    /**
     * function  returns the string output as per the requirements for storing the data in the file
     * @return
     */
    @Override
    public String forFile() {
        return "T | "+((super.isDone)?"1":"0")+" | "+super.description;
    }
}
