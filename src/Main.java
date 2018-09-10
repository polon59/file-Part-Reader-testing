
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        filePartReader.setup("data.txt",1,3);
        System.out.println(filePartReader.readLines());

        List<String> wordsAlphabhetically = fileWordAnalyzer.wordsByABC();
        for (String word : wordsAlphabhetically){
            System.out.print(word);
        }
    }
}
