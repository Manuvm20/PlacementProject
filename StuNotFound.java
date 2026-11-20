public class StuNotFound extends Exception{
    //custom exception thrown when a student id is not in the records
    public StuNotFound(String msg){
        super(msg);
    }
}
