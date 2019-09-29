import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> text = new ArrayList<>();

        System.out.println("Input your text(if you want to stop enter an empty string)");
        TextIn.inputText(text);

        ChangeString.splitAndUpper(text);
    }
}
