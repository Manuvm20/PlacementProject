public class SRoom extends Room{
    //passes the room number to the Room class
    public SRoom(int rno){
        super(rno);
    }

    //single room has only one bed
    @Override
    public int cap(){
        return 1;
    }

    //costs more as there is no sharing
    @Override
    public double fee(){
        return 60000;
    }

    //name of this room type
    @Override
    public String type(){
        return "Single";
    }
}
