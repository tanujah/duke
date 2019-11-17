public class todo extends  task{
    protected  String by;
    public todo(String description) {
        super(description);

    }

    @Override
    public  String toString(){
        return "[T] "+super.toString();
    }
}