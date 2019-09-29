import java.util.List;

public class ChangeString {

    public static void splitAndUpper(List<String> myText){
        String[] tokens;

        for(String currentStr: myText){
            tokens = currentStr.split("[\\s.,]+");
            for(int i = 0; i < tokens.length; i++){
                if(tokens[i].substring(0,1).matches("A-Z")){
                    continue;
                }
                else {
                    currentStr = currentStr.replaceAll(tokens[i], firstToUpper(tokens[i]));
                }
            }
            System.out.println(currentStr);
        }
    }

    private static String firstToUpper(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }
}
