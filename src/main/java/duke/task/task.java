package duke.task;

public  class task {

    protected String description;
    public boolean isDone;

    public task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public  String toString()  {
        return getStatusIcon() + " "+this.description;
    }

    public String forFile() {
        System.out.println("this function is calling");
        return  null;
    }
}
