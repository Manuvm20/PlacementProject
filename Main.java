public class Main{
    //creates all managers, shows the menu in a loop and catches our custom exceptions
    public static void main(String[] args){
        StuMgr sm=new StuMgr();
        RoomMgr rm=new RoomMgr(sm);
        FeeMgr fm=new FeeMgr(sm);
        CompMgr cm=new CompMgr(sm);
        boolean run=true;

        System.out.println("===== College Hostel Management System =====");
        while(run){
            menu();
            int ch=Input.num("Enter choice: ");
            try{
                switch(ch){
                    case 1:{
                        String id=Input.text("Student ID: ");
                        String name=Input.text("Name: ");
                        String ph=Input.text("Phone: ");
                        String course=Input.text("Course: ");
                        if(sm.add(id,name,ph,course))
                            System.out.println("Student added");
                        else
                            System.out.println("Student with this ID already exists");
                        break;
                    }
                    case 2:
                        sm.showAll();
                        break;
                    case 3:
                        System.out.println(sm.find(Input.text("Student ID: ")));
                        break;
                    case 4:
                        rm.showFree();
                        break;
                    case 5:{
                        String id=Input.text("Student ID: ");
                        int rno=Input.num("Room no: ");
                        rm.allot(id,rno);
                        break;
                    }
                    case 6:
                        rm.vacate(Input.text("Student ID: "));
                        break;
                    case 7:
                        fm.pay(Input.text("Student ID: "));
                        break;
                    case 8:
                        fm.showDue();
                        break;
                    case 9:{
                        String id=Input.text("Student ID: ");
                        String text=Input.text("Complaint: ");
                        cm.add(id,text);
                        break;
                    }
                    case 10:
                        cm.showPending();
                        break;
                    case 11:
                        cm.solveNext();
                        break;
                    case 12:
                        cm.showSolved();
                        break;
                    case 0:
                        run=false;
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }catch(StuNotFound|RoomNotFound|RoomFull e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        Input.close();
    }

    //prints the menu options
    static void menu(){
        System.out.println();
        System.out.println("1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Search student");
        System.out.println("4. Show free rooms");
        System.out.println("5. Allot room");
        System.out.println("6. Vacate room");
        System.out.println("7. Pay fee");
        System.out.println("8. Pending fees");
        System.out.println("9. Register complaint");
        System.out.println("10. Pending complaints");
        System.out.println("11. Solve next complaint");
        System.out.println("12. Solved complaints");
        System.out.println("0. Exit");
    }
}
