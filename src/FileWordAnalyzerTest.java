import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class FileWordAnalyzerTest {

    private FilePartReader filePartReader;
    private FileWordAnalyzer fileWordAnalyzer;


    @Mock
    private FilePartReader filePartReaderMock;


    @BeforeEach
    void setup() {
        this.filePartReader = new FilePartReader();
        this.fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }



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
        MockitoAnnotations.initMocks(this);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReaderMock);
        when(filePartReaderMock.readLines()).thenReturn("1a1\n2b 2a\n3c 3b 3a\n4d 4cr 4bb4 4a\n5e 5d 5c 5b 5ax\n6f 6ea 6d 6ca 6bb 6a\n7g 7f 7ea\n");
        List<String> received;
        List<String> expected = new ArrayList<>();
        expected.add("5e 5d 5c 5b 5ax");
        expected.add("6f 6ea 6d 6ca 6bb 6a");
        expected.add("7g 7f 7ea");

        received = fileWordAnalyzer.wordsContainingSubString("e");

        assertEquals(expected,received);
    }


    @Test
    @DisplayName("Test reading all lines from file")
    void testReadLinesAll(){
        String expected = "1a1\n2b 2a\n3c 3b 3a\n4d 4cr 4bb4 4a\n5e 5d 5c 5b 5ax\n6f 6ea 6d 6ca 6bb 6a\n7g 7f 7ea\n";
        filePartReader.setup("text.txt",1,100);

        String recieved = filePartReader.readLines();

        assertEquals(expected,recieved);
    }


    @Test
    @DisplayName("Test reading while 'toline' is past file length")
    void testReadLinesPastEof(){
        String expected = "1a1\n2b 2a\n3c 3b 3a\n4d 4cr 4bb4 4a\n5e 5d 5c 5b 5ax\n6f 6ea 6d 6ca 6bb 6a\n7g 7f 7ea\n";
        filePartReader.setup("text.txt",1,100);

        String recieved = filePartReader.readLines();

        assertEquals(expected,recieved);
    }







}