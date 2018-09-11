import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class FileWordAnalyzer {

    private FilePartReader filePartReader;


    FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }


    ArrayList wordsByABC(){
        String fileText = filePartReader.readLines();
        String[] fileLines = fileText.split("\n");
        Arrays.sort(fileLines);

        return new ArrayList<>(Arrays.asList(fileLines));
    }


    List wordsContainingSubString(String subString ){
        String fileText = filePartReader.readLines();
        String[] fileLines = fileText.split("\n");
        List<String> wordsContainingSubStr = new ArrayList<>();

        for (String word:fileLines){
            if (word.contains(subString)){
                wordsContainingSubStr.add(word);
            }
        }

        return wordsContainingSubStr;
    }
}
