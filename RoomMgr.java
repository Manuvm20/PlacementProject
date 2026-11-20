import java.util.ArrayList;

public class RoomMgr{
    private ArrayList<Room> rooms=new ArrayList<>();
    private StuMgr sm;

    //adds the rooms the hostel starts with, list is Room type but holds SRoom and DRoom objects
    public RoomMgr(StuMgr sm){
        this.sm=sm;
        rooms.add(new SRoom(101));
        rooms.add(new SRoom(102));
        rooms.add(new DRoom(201));
        rooms.add(new DRoom(202));
        rooms.add(new DRoom(203));
    }

    //finds a room by number, throws RoomNotFound if it doesnt exist
    public Room find(int rno) throws RoomNotFound{
        for(Room r:rooms)
            if(r.getRno()==rno)
                return r;
        throw new RoomNotFound("Room "+rno+" does not exist");
    }

    //prints only the rooms that have a free bed
    public void showFree(){
        boolean found=false;
        for(Room r:rooms){
            if(!r.isFull()){
                System.out.println(r);
                found=true;
            }
        }
        if(!found)
            System.out.println("All rooms are full");
    }

    //gives a room to a student, fee is taken from the room type
    public void allot(String id,int rno) throws StuNotFound,RoomNotFound,RoomFull{
        Stu s=sm.find(id);
        Room r=find(rno);
        if(s.hasRoom()){
            System.out.println(s.getName()+" already has room "+s.getRno()+", vacate it first");
            return;
        }
        if(r.isFull())
            throw new RoomFull("Room "+rno+" is already full");
        r.add(id);
        s.setRoom(rno,r.fee());
        System.out.println("Room "+rno+" given to "+s.getName()+". Fee: Rs."+r.fee());
    }

    //removes a student from their room, message is printed before clearRoom() makes room no 0
    public void vacate(String id) throws StuNotFound,RoomNotFound{
        Stu s=sm.find(id);
        if(!s.hasRoom()){
            System.out.println(s.getName()+" does not have a room");
            return;
        }
        Room r=find(s.getRno());
        r.remove(id);
        System.out.println(s.getName()+" left room "+s.getRno());
        s.clearRoom();
    }
}
