public class Main {
    public static void main(String[] args) {

        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("data.txt",1,6);
        System.out.println(filePartReader.readLines());
    }
}
