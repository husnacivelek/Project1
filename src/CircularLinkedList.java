


public class CircularLinkedList {
    CircularNode current;
    int size;

    public CircularLinkedList(){
        current = null;
        size = 0;
    }


    public CircularLinkedList copyElements(){
        CircularLinkedList clist = new CircularLinkedList();
        CircularNode temp = current;
        int c = 1;
        while (c != 2){
            clist.insertAfterCurrent(temp.student);
            temp = temp.prev;
            if (temp == current)
                c++;


        }
        return clist;
    }
    public void insertAfterCurrent(String s) {
        CircularNode cnode = new CircularNode(s);
        if (current == null){
            current = cnode;
            current.next = current;
            current.prev = current;

        }else{

            cnode.next = current.next;
            current.next.prev = cnode;
            current.next = cnode;
            cnode.prev = current;

        }
        size++;
    }


    public String longestName() {
        CircularNode temp = current;
        CircularNode max = current;
        int c = 1;
        while (c != 2){

            temp = temp.next;
            if (temp.student.length() > max.student.length())
                max = temp;

            if (temp == current)
                c++;

        }

        return max.student;

    }


    CircularNode get(int n){
        CircularNode temp = current;

        for (int i = 0; i < n-1; ++i)
            temp = temp.next;

        return temp;
    }


    public void toStr(){
        CircularNode temp = current;
        int c = 1;
        while (c != 2){
            if(!temp.loseGame()){
                System.out.println(temp.student);
            }
            temp = temp.next;
            if (temp == current)
                c++;

        }

    }
}
