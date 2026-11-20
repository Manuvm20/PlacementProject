//stores details of one student
//all fields are private so they can only be changed using methods (encapsulation)
public class Stu{
    private String id,name,ph,course;
    private int rno;//0 means no room given yet
    private double fee;//yearly fee of the room
    private boolean paid;

    public Stu(String id,String name,String ph,String course){
        this.id=id;
        this.name=name;
        this.ph=ph;
        this.course=course;
        rno=0;
        fee=0;
        paid=false;
    }

    //called when a room is given, fee depends on the room type
    public void setRoom(int rno,double fee){
        this.rno=rno;
        this.fee=fee;
        paid=false;//new room so new fee to pay
    }

    //called when student leaves the room
    public void clearRoom(){
        rno=0;
        fee=0;
        paid=false;
    }

    public void pay(){
        paid=true;
    }

    public boolean hasRoom(){
        return rno!=0;
    }

    public String getId(){return id;}
    public String getName(){return name;}
    public int getRno(){return rno;}
    public double getFee(){return fee;}
    public boolean isPaid(){return paid;}

    public String toString(){
        String r=hasRoom()?""+rno:"Not allotted";
        String f;
        if(!hasRoom())
            f="-";
        else if(paid)
            f="Paid";
        else
            f="Pending (Rs."+fee+")";
        return id+" | "+name+" | "+ph+" | "+course+" | Room: "+r+" | Fee: "+f;
    }
}
