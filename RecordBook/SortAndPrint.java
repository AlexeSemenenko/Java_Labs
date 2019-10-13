import java.util.Comparator;
import java.util.List;
import java.io.*;

public class SortAndPrint {

    public static void sortAndPrintByName(List<Student> students, OutputStream out) throws IOException {
        out.write("Sorted by name:\n".getBytes());

        Comparator<Student> comparator = new ComparatorByName();

        students.sort(comparator);

        for(Student student : students){
            try{
                out.write(("\t" + student).getBytes());
            } catch (IOException ex){
                System.out.println("Error " + ex.getMessage());
            }
        }
    }

    public static void sortAndPrintByAverageMark(List<Student> students, OutputStream out) throws IOException {
        out.write("Sorted by average mark:\n".getBytes());

        Comparator<Student> comparator = new ComparatorByAverageMark();

        students.sort(comparator);

        for(Student student : students){
            try{
                out.write(("\t" + student).getBytes());
            } catch (IOException ex){
                System.out.println("Error " + ex.getMessage());
            }
        }
    }

    public static void printGoodStudents(List<Student> students, OutputStream out) throws IOException {
        out.write("Good students:\n".getBytes());

        for(Student student : students){
            try{
                if(student.averageMark() >= 6){
                    out.write(("\t" + student.toString()).getBytes());
                }
            } catch (IOException ex){
                System.out.println("Error " + ex.getMessage());
            }
        }
    }

    public static void printBadStudents(List<Student> students, OutputStream out) throws IOException {
        out.write("Bad students:\n".getBytes());

        for(Student student : students){
            try{
                if(student.averageMark() < 6){
                    out.write(("\t" + student.toString()).getBytes());
                }
            } catch (IOException ex){
                System.out.println("Error " + ex.getMessage());
            }
        }
    }
}
