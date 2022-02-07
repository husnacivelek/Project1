import java.util.Random;


public class DoubleNode {
    public String student;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(String student){
        this.student = student;
        prev = null;
        next = null;
    }

    public boolean setDirection(){
        Random r = new Random();

        return r.nextBoolean();
    }

    public String renameStudent(){
        student = student + "*";
        return student;
    }
}

