import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private FilePartReader filePartReader = new FilePartReader();
    private FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    @Test
    @DisplayName("Test word sorting by alphabetic order")
    void wordsByABCTest() {

        filePartReader.setup("data.txt",1,3);

        List wordsAlphabhetically = fileWordAnalyzer.wordsByABC();

        List<String> expectedWords = new ArrayList<>();
        expectedWords.add("dupa");
        expectedWords.add("jakieś słowo");
        expectedWords.add("line2");

        assertEquals(expectedWords, wordsAlphabhetically);
    }


    @Test
    @DisplayName("Test if exception thrown in method setup with fromline < 1")
    void testSetupFromLineLT1() {
        boolean thrown = false;

        try {
            filePartReader.setup("data.txt",0,5);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


    @Test
    @DisplayName("Test if exception thrown in method setup with toLine < fromLine")
    void testSetupToLineLTFromLine() {
        boolean thrown = false;

        try {
            filePartReader.setup("data.txt",5,2);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }



    @Test
    @DisplayName("Test reading lines from 1 to 2")
    void testReadLines1_2() {
        String expected = "dupa\nline2\n";
        filePartReader.setup("text.txt",1,2);
        String recieved = filePartReader.readLines();
        assertEquals(expected,recieved);
    }


    @Test
    @DisplayName("Test reading lines from 2 to 4")
    void testReadLines2_4() {
        String expected = "line2\njakieś słowo\nline4\n";
        filePartReader.setup("text.txt",2,4);
        String recieved = filePartReader.readLines();
        assertEquals(expected,recieved);
    }



}