import java.io.File;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(){
        filePath = "";
        fromLine = 0;
        toLine = 1;
    }


    public void setup(String filePath, int fromLine, int toLine) {

        if (toLine < fromLine || fromLine < 1){
            throw new IllegalArgumentException();
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }


    private String read(){
        File file = new File("data/data.txt");
        StringBuilder text = new StringBuilder();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                text.append(scanner.nextLine());
                text.append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return text.toString();
    }

    public String readLines(){
        String wholeText = read();
        StringBuilder sb = new StringBuilder();
        String[] textLines = wholeText.split("\n");

        for (int i = 0; i<textLines.length; i++){
            if (i >= fromLine-1 && i <= toLine-1){
                sb.append(textLines[i]);
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
