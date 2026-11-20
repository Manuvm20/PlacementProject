import java.util.Scanner;

public class Input{
    static Scanner sc=new Scanner(System.in);

    //reads a line of text, asks again if it is empty
    static String text(String msg){
        String s="";
        while(s.isEmpty()){
            System.out.print(msg);
            s=sc.nextLine().trim();
        }
        return s;
    }

    //reads a number, whole line is read and converted so typing "abc" doesnt crash the program
    static int num(String msg){
        while(true){
            System.out.print(msg);
            try{
                return Integer.parseInt(sc.nextLine().trim());
            }catch(NumberFormatException e){
                System.out.println("Enter a valid number");
            }
        }
    }

    //closes the scanner at the end
    static void close(){
        sc.close();
    }
}
