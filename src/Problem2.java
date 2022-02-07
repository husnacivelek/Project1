import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        DoublyLinkedList dl = new DoublyLinkedList();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String file = kb.next();
        File f = new File(file);
        Scanner sc = new Scanner(f);

        Random random = new Random();

        while(sc.hasNext()){
            String name = "";
            String str = sc.nextLine();
            for (int i = 0; i < str.length(); ++i)
                if(str.charAt(i) != ' ')
                    name += str.charAt(i);
                else
                    break;
            dl.insertLast(name);

        }

        sc.close();
        System.out.println("------------------------------------------");
        DoublyLinkedList students = new DoublyLinkedList();
        int s = 0;
        while (s != 30){
            int n = random.nextInt(dl.size);
            if(!students.exists(dl.get(n).student)){
                students.insertLast(dl.get(n).student);
                s++;
            }

        }

        System.out.println("...Reading class.txt");
        System.out.print("Enter the number of hubs: ");
        int hub = kb.nextInt();
        System.out.println("…Creating a linked list of 30 students , " +hub + " are hubs");
        int i = hub;
        while(i != 0){
            int n = random.nextInt(students.size);
            String hubStu = students.get(n).student;
            if (hubStu.charAt(hubStu.length() - 1) != '*' ){
                students.get(n).renameStudent();
                i--;
            }

        }
        System.out.print("Enter the number of students to pass the message (k): ");
        int k = kb.nextInt();
        System.out.println("---Displaying the student message train, (hubs have a * character on their names):");
        students.display();
        System.out.print("Enter the message: ");
        String message = kb.next();
        System.out.print("Enter the source student: ");
        String source = kb.next();

        DoubleNode sourceNode = students.findSource(source);
        boolean direction = sourceNode.setDirection();

        if (direction)
            students.displayKthForward(sourceNode, k,message);
        else
            students.displayKthBackward(sourceNode, k,message);

    }
}

