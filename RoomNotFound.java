public class RoomNotFound extends Exception{
    //custom exception thrown when a room number does not exist
    public RoomNotFound(String msg){
        super(msg);
    }
}
