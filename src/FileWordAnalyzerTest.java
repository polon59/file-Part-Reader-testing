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
        List<String> expectedWords = new ArrayList<>();
        expectedWords.add("1a1");
        expectedWords.add("2b 2a");
        expectedWords.add("3c 3b 3a");
        filePartReader.setup("data.txt",1,3);

        List wordsAlphabhetically = fileWordAnalyzer.wordsByABC();

        assertEquals(expectedWords, wordsAlphabhetically);
    }


    @Test
    @DisplayName("Test if exception thrown in method setup with fromline < 1")
    void testSetupFromLineLT1() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("data.txt",0,5));
    }


    @Test
    @DisplayName("Test if exception thrown in method setup with toLine < fromLine")
    void testSetupToLineLTFromLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("data.txt",5,2));
    }



    @Test
    @DisplayName("Test reading lines from 1 to 2")
    void testReadLines1_2() {
        String expected = "1a1\n2b 2a\n";
        filePartReader.setup("text.txt",1,2);

        String recieved = filePartReader.readLines();

        assertEquals(expected,recieved);
    }


    @Test
    @DisplayName("Test reading lines from 2 to 4")
    void testReadLines2_4() {
        String expected = "2b 2a\n3c 3b 3a\n4d 4cr 4bb4 4a\n";
        filePartReader.setup("text.txt",2,4);
        String recieved = filePartReader.readLines();
        assertEquals(expected,recieved);
    }

//    RECEIVED

    @Test
    @DisplayName("Test finding palindromes")
    void testWordsArePalindrome() {
        List<String> expected = new ArrayList<>();
        expected.add("1a1");
        List recieved = fileWordAnalyzer.wordsArePalindrome();
        assertEquals(expected,recieved);
    }


    @Test
    @DisplayName("Test finding strings containing given substring")
    void testWordsContainingSubString(){
        List<String> received;
        List<String> expected = new ArrayList<>();
        filePartReader.setup("data.txt",1,100);
        expected.add("5e 5d 5c 5b 5ax");
        expected.add("6f 6ea 6d 6ca 6bb 6a");
        expected.add("7g 7f 7ea");

        received = fileWordAnalyzer.wordsContainingSubString("e");

        assertEquals(expected,received);
    }







}