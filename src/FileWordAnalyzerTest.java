import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    void wordsByABCTest() {
        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List<String> wordsAlphabhetically = fileWordAnalyzer.wordsByABC();
        List<String> expectedWords = new ArrayList<>();
        expectedWords.add("dupa"); }
}