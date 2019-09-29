import java.util.List;
import java.util.Scanner;

public class TextIn {

    public static void inputText(List<String> myText){
        Scanner scn = new Scanner(System.in);

        while(true) {
            String currentLine = scn.nextLine();
            if (currentLine.equals("")){
                break;
            }
            myText.add(currentLine);
        }
    }
}
