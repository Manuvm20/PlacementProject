import java.util.ArrayList;

public abstract class Room{
    private int rno;
    private ArrayList<String> ids=new ArrayList<>();

    //sets the room number
    public Room(int rno){
        this.rno=rno;
    }

    //how many students can stay, each room type gives its own answer
    public abstract int cap();
    //yearly fee, each room type gives its own answer
    public abstract double fee();
    //name of the room type like Single or Double
    public abstract String type();

    //true when no more students can be added
    public boolean isFull(){
        return ids.size()>=cap();
    }

    //adds a student id to the room, RoomMgr checks isFull() before calling this
    public void add(String id){
        ids.add(id);
    }

    //removes a student id when they leave the room
    public void remove(String id){
        ids.remove(id);
    }

    //returns the room number
    public int getRno(){
        return rno;
    }

    //returns how many beds are free
    public int free(){
        return cap()-ids.size();
    }

    //room details in one line
    public String toString(){
        return "Room "+rno+" | "+type()+" | Fee: Rs."+fee()+" | Free beds: "+free()+"/"+cap();
    }
}
