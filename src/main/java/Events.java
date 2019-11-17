public class Events extends  task{
    protected  String by;
    public Events(String description, String by) {
        super(description);
        this.by=by;
    }

    @Override
    public  String toString(){
        return "[E] "+super.toString()+" (at: "+by+ ")";
    }
}