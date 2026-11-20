public class CQueue{
    private class Node{
        Comp data;
        Node next;

        //one node of the linked list, holds a complaint and link to the next node
        Node(Comp data){
            this.data=data;
            next=null;
        }
    }

    private Node front,rear;
    private int size;

    //our own queue using linked list, front is the oldest and rear is the newest
    public CQueue(){
        front=null;
        rear=null;
        size=0;
    }

    //adds a complaint at the back, if queue is empty the new node is both front and rear
    public void enq(Comp c){
        Node n=new Node(c);
        if(rear==null){
            front=n;
            rear=n;
        }else{
            rear.next=n;
            rear=n;
        }
        size++;
    }

    //removes the oldest complaint from the front (FIFO), rear becomes null if queue gets empty
    public Comp deq(){
        if(front==null)
            return null;
        Comp c=front.data;
        front=front.next;
        if(front==null)
            rear=null;
        size--;
        return c;
    }

    //true if there are no complaints
    public boolean isEmpty(){
        return front==null;
    }

    //number of complaints in the queue
    public int size(){
        return size;
    }

    //prints all complaints from front to rear without removing them
    public void show(){
        Node cur=front;
        while(cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }
    }
}
