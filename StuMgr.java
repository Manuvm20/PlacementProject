import java.util.*;

public class StuMgr{
    private HashMap<String,Stu> map=new HashMap<>();

    //adds a new student, returns false if the id already exists
    public boolean add(String id,String name,String ph,String course){
        if(map.containsKey(id))
            return false;
        map.put(id,new Stu(id,name,ph,course));
        return true;
    }

    //finds a student by id using the hashmap, throws StuNotFound if not there
    public Stu find(String id) throws StuNotFound{
        Stu s=map.get(id);
        if(s==null)
            throw new StuNotFound("No student found with ID "+id);
        return s;
    }

    //prints all the students
    public void showAll(){
        if(map.isEmpty()){
            System.out.println("No students added yet");
            return;
        }
        for(Stu s:map.values())
            System.out.println(s);
    }

    //gives all students so FeeMgr can go through them
    public Collection<Stu> getAll(){
        return map.values();
    }
}
