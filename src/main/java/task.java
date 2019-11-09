public class task {
    protected String description;
    protected boolean isDone;
    protected  char typeTask;
    private  String time;

    public task(String description, char type) {
        this.description = description;
        this.isDone = false;
        this.typeTask = type;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public  void settime(String time){
        this.time= time;
    }
    public  void  taskprint(){
        if(this.typeTask == 'D'){
            System.out.println("["+this.typeTask+"] "+this.getStatusIcon()+ " "+this.description+" /by "+this.time);
        } else if(this.typeTask =='E')
        {
            System.out.println("["+this.typeTask+"] "+this.getStatusIcon()+ " "+this.description+"/at"+this.time);
        }
        else{
            System.out.println("["+this.typeTask+"] "+this.getStatusIcon()+ " "+this.description);
        }
    }
}

