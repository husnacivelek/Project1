import static java.lang.Character.compare;


public class DoublyLinkedList {
    DoubleNode first;
    DoubleNode last;
    int size;



    public DoublyLinkedList(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void insertLast(String str){
        DoubleNode newNode = new DoubleNode(str);

        if (last == null){
            first = newNode;

        } else{
            last.next = newNode;

        }
        newNode.prev = last;
        last = newNode;
        size++;

    }

    public boolean exists(String name){
        for (int i = 0; i < size; ++i)
            if(get(i).student == name)
                return true;

        return false;
    }

    public void display(){
        DoubleNode temp = this.first;
        while (temp != null){
            if (temp == last){
                System.out.print(temp.student);
                System.out.println();
            }else
                System.out.print(temp.student + " <--> ");


            temp = temp.next;

        }

    }

    public void displayKthForward(DoubleNode source,int k,String message){
        System.out.println();
        DoubleNode temp = source;
        System.out.println(source.student + " passes message " + message + " to forward: ");
        for (int i = 0; i < k; ++i){
            if (i == k - 1){
                System.out.print(temp.student);
                System.out.println();
            }else
                System.out.print(temp.student + " <--> ");



            temp = temp.next;
            if(temp == null)
                break;
            if(appropriateHub(message,temp)){
                if (temp.setDirection()){
                    displayKthForward(temp,k,message);
                    break;
                }else{
                    displayKthBackward(temp, k,message);
                    break;
                }
            }

        }
    }

    public void displayKthBackward(DoubleNode source,int k,String message){
        System.out.println();
        DoubleNode temp = source;
        System.out.println(source.student + " passes message " + message + " to backward: ");
        for (int i = 0; i < k; ++i){
            if (i == k - 1){
                System.out.print(temp.student);
                System.out.println();
            }else
                System.out.print(temp.student + " <--> ");



            temp = temp.prev;
            if(temp == null)
                break;

            if(appropriateHub(message,temp)){
                if (temp.setDirection()){
                    displayKthForward(temp,k,message);
                    break;
                }else{
                    displayKthBackward(temp, k,message);
                    break;
                }
            }
        }

    }


    public boolean appropriateHub(String msg, DoubleNode hub){
        return checkHub(msg,hub) && checkHubLetters(msg,hub);
    }

    public boolean checkHub(String msg, DoubleNode hub){
        return hub.student.charAt(hub.student.length() - 1) == '*';
    }

    public boolean checkHubLetters(String msg, DoubleNode hub){
        int n = 0;
        String name = hub.student.toLowerCase();
        for (int i = 0; i < msg.length(); ++i)
            for (int k = 0; k < name.length(); ++k)
                if (msg.charAt(i) == name.charAt(k))
                    ++n;

        return n >= 2;
    }

    public DoubleNode get(int n){
        DoubleNode temp = first;

        for (int i = 0; i < n -1; ++i)
            temp = temp.next;

        return temp;
    }

    public DoubleNode findSource(String source){
        DoubleNode temp = first;

        while (temp != null){
            if (temp.student.equalsIgnoreCase(source))
                return temp;
            temp = temp.next;
        }
        throw new java.util.NoSuchElementException();
    }



}
