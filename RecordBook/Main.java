import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<Student>();

//        сreateFirstFile(students);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
        students = (List<Student>) ois.readObject();

        SortAndPrint.printBadStudents(students, new FileOutputStream("bad.txt"));
        SortAndPrint.printGoodStudents(students, new FileOutputStream("good.txt"));
        SortAndPrint.sortAndPrintByName(students, new FileOutputStream("byName.txt"));
        SortAndPrint.sortAndPrintByAverageMark(students, new FileOutputStream("byMark.txt"));
    }

    public static void сreateFirstFile(List<Student> students) throws IOException {
        students.add(new Student("Семененко Леша"));
        students.add(new Student("Паланевич Саша"));
        students.add(new Student("Генис Артем"));
        students.add(new Student("Шурхай Юрий"));
        students.add(new Student("Мазаник Сергей"));
        students.add(new Student("Леваков Толик"));

        for(int i = 0; i < students.size(); i++){
            students.get(i).sessions = new ArrayList<Session>(2);
            for (int j = 0; j < 2; j++){
                students.get(i).sessions.add(createSession());
            }
        }

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
            oos.writeObject(students);
            oos.flush();
        } catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static Session createSession(){
        Session session = new Session();
        session.subjects = new HashMap<Subjects, Integer>(5);
        for (Subjects subject : Subjects.values()){
            session.subjects.put(subject, 4 + (int)(Math.random() * 6));
        }

        return session;
    }
}