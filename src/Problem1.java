import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Problem1 {
    public static void main(String[] args) throws FileNotFoundException {
        CircularLinkedList cl = new CircularLinkedList();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String file = kb.next();
        System.out.print("Enter the number of students: ");
        int n = kb.nextInt();
        System.out.print("Enter the number of times you want to play: ");
        int t = kb.nextInt();
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
            cl.insertAfterCurrent(name);

        }

        sc.close();
        System.out.println("------------------------------------------");
        CircularLinkedList students = new CircularLinkedList();
        for (int i = 0; i < n; ++i){
            int rn = random.nextInt(cl.size + 1);
            students.insertAfterCurrent(cl.get(rn).student);
        }

        CircularLinkedList copyStudents = students.copyElements();

        for (int i = 0; i < t; ++i){
            int rn = random.nextInt(copyStudents.size + 1);
            System.out.println();
            System.out.print(students.get(rn).student + " loses a letter in his/her name: ");
            copyStudents.get(rn).deleteLetter();
            System.out.println(copyStudents.get(rn).student);
            copyStudents.toStr();
        }
        System.out.println();

        System.out.println("Winner of the game is: " + copyStudents.longestName());

    }
}

