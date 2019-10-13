import java.util.Comparator;

public class ComparatorByAverageMark implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if(a.averageMark() < b.averageMark()){
            return -1;
        }
        else{
            return 0;
        }
    }
}