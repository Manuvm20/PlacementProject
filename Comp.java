public class Comp{
    private static int next=1;
    private int no;
    private String id,desc;
    private boolean done;

    //makes a new complaint, next is static so every complaint gets a new number
    public Comp(String id,String desc){
        no=next;
        next++;
        this.id=id;
        this.desc=desc;
        done=false;
    }

    //marks the complaint as solved
    public void resolve(){
        done=true;
    }

    //returns the complaint number
    public int getNo(){
        return no;
    }

    //complaint details in one line
    public String toString(){
        return "#"+no+" | Student: "+id+" | "+desc+" | "+(done?"Resolved":"Pending");
    }
}
