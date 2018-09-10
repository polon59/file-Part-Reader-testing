import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public ArrayList wordsByABC(){
        String fileText = filePartReader.readLines();
        String[] fileLines = fileText.split("\n");
        Arrays.sort(fileLines);


        return new ArrayList<String>(Arrays.asList(fileLines));
    }
}
