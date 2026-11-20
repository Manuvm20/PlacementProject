public class DRoom extends Room{
    //passes the room number to the Room class
    public DRoom(int rno){
        super(rno);
    }

    //double room has two beds
    @Override
    public int cap(){
        return 2;
    }

    //cheaper as the room is shared
    @Override
    public double fee(){
        return 40000;
    }

    //name of this room type
    @Override
    public String type(){
        return "Double";
    }
}
