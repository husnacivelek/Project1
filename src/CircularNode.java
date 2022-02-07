
public class CircularNode {
    CircularNode next;
    CircularNode prev;
    String student;
    public CircularNode(String student){
        this.student = student;
        next = null;
        prev = null;
    }

    public String deleteLetter(){
        String newStudent = "";
        for(int i = 0; i < student.length()- 1; ++i)
            newStudent+=student.charAt(i);

        student = newStudent;

        return student;
    }

    public boolean loseGame(){
        return student.isEmpty();
    }
}

