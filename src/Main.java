
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        filePartReader.setup("data.txt",2,4);
//        System.out.println(filePartReader.readLines());

        filePartReader.setup("data.txt",1,30);
        List<String> foundWords = fileWordAnalyzer.wordsContainingSubString("du");
        for (String word:foundWords) {
            System.out.println(word);
        }
    }
}
