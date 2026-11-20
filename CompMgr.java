import java.util.ArrayList;

public class CompMgr{
    private CQueue q=new CQueue();
    private ArrayList<Comp> solved=new ArrayList<>();
    private StuMgr sm;

    //gets the student manager so only registered students can complain
    public CompMgr(StuMgr sm){
        this.sm=sm;
    }

    //checks the student exists and adds the complaint to the back of the queue
    public void add(String id,String text) throws StuNotFound{
        sm.find(id);
        Comp c=new Comp(id,text);
        q.enq(c);
        System.out.println("Complaint #"+c.getNo()+" registered");
    }

    //prints pending complaints, oldest first
    public void showPending(){
        if(q.isEmpty()){
            System.out.println("No pending complaints");
            return;
        }
        System.out.println("Pending complaints ("+q.size()+"), oldest first:");
        q.show();
    }

    //solves the oldest complaint first and moves it to the solved list
    public void solveNext(){
        Comp c=q.deq();
        if(c==null){
            System.out.println("No complaints to solve");
            return;
        }
        c.resolve();
        solved.add(c);
        System.out.println("Solved: "+c);
    }

    //prints all solved complaints
    public void showSolved(){
        if(solved.isEmpty()){
            System.out.println("No solved complaints yet");
            return;
        }
        for(Comp c:solved)
            System.out.println(c);
    }
}
