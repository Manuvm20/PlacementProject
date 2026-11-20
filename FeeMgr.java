public class FeeMgr{
    private StuMgr sm;

    //gets the student manager so it can find students
    public FeeMgr(StuMgr sm){
        this.sm=sm;
    }

    //marks fee as paid, only if the student has a room and hasnt paid already
    public void pay(String id) throws StuNotFound{
        Stu s=sm.find(id);
        if(!s.hasRoom()){
            System.out.println("No room given so no fee to pay");
            return;
        }
        if(s.isPaid()){
            System.out.println("Fee already paid for "+s.getName());
            return;
        }
        s.pay();
        System.out.println("Fee of Rs."+s.getFee()+" paid for "+s.getName());
    }

    //shows students who have a room but havent paid, and the total due
    public void showDue(){
        double total=0;
        for(Stu s:sm.getAll()){
            if(s.hasRoom()&&!s.isPaid()){
                System.out.println(s);
                total+=s.getFee();
            }
        }
        if(total==0)
            System.out.println("No pending fees");
        else
            System.out.println("Total pending: Rs."+total);
    }
}
