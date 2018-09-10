import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    void wordsByABCTest() {
        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        filePartReader.setup("data.txt",1,3);

        List<String> wordsAlphabhetically = fileWordAnalyzer.wordsByABC();

        List<String> expectedWords = new ArrayList<>();
        expectedWords.add("dupa");
        expectedWords.add("jakieś słowo");
        expectedWords.add("line2");

        assertEquals(expectedWords, wordsAlphabhetically);
    }
}