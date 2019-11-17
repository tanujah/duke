package duke.task;

import java.time.LocalDateTime;

public class Events extends task {
    protected  String by;
    protected LocalDateTime time;
    public Events(String description, String by, LocalDateTime time) {
        super(description);
        this.by = by;
        this.time=time;
    }

    @Override
    public  String toString(){
        return "[E] "+super.toString()+" (at: "+by+ ")";
    }

    @Override
    public  String forFile(){
        return "E | "+((super.isDone)?"1":"0")+" | "+super.description+"|"+by;
    }
}
