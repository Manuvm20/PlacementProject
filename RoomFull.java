public class RoomFull extends Exception{
    //custom exception thrown when a room has no free bed
    public RoomFull(String msg){
        super(msg);
    }
}
