import java.io.Serializable;
import java.util.List;

public class Student implements Comparable<Student>, Serializable {
    private static int amountOfStudent;

    public String name;
    public int id;
    public List<Session> sessions;

    public Student(String name) {
        this.name = name;
        this.id = amountOfStudent;
        amountOfStudent++;
    }

    @Override
    public int compareTo(Student otherStudent) {
        if (name.compareTo(otherStudent.name) != 0){
            return name.compareTo(otherStudent.name);
        } else{
            return id - otherStudent.id;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(name + "\t").append(id + "\t").append(this.averageMark() + "\n");
        return result.toString();
    }

    public double averageMark() {
        double sum = 0;
        int numberOfMarks = 0;

        for (Session session : sessions) {
            Pair<Integer, Integer> statistics = session.getStatistics();
            sum += statistics.first;
            numberOfMarks += statistics.second;
        }

        return (double) sum / numberOfMarks;
    }
}