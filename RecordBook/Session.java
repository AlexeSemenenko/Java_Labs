import java.io.Serializable;
import java.util.Map;

public class Session implements Serializable {
    public Map<Subjects, Integer> subjects;

    public Pair<Integer, Integer> getStatistics() {
        int sum = 0;
        int count = 0;

        for (Map.Entry<Subjects, Integer> subject : subjects.entrySet()) {
            sum += subject.getValue();
            count++;
        }
        return new Pair<Integer, Integer>(sum, count);
    }

    public double getAverageMark() {
        Pair<Integer, Integer> statistics = getStatistics();
        return (double) statistics.first / statistics.second;
    }
}