package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline  extends  task{
    protected  String by;
    protected LocalDateTime time;
    public Deadline(String description, String by,LocalDateTime time) {
        super(description);
        this.by = by;
        this.time = time;
    }
    @Override
    public  String toString(){
        DateTimeFormatter format =DateTimeFormatter.ofPattern("MMM d yyyy hh:mm");
        return "[D] "+super.toString()+" (by: "+time.format(format)+ ")";
    }
    @Override
    public  String forFile(){

        return "D | "+((super.isDone)?"1":"0")+" | "+super.description+"|"+by;
    }
}
