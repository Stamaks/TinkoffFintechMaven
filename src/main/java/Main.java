import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {
    private static final String FILE_NAME = "file.txt";
    private static final int MAX_LENGHT = 20;

    private static Random rand = new Random();

    public static void main(String args[]){
        createRandomFolderWithTextFile();
    }

    private static void createRandomFolderWithTextFile(){
        String folderName = "";
        int numberOfCharsInFolderName = 1 + rand.nextInt(MAX_LENGHT);

        for (int i = 0; i < numberOfCharsInFolderName; i++) {
            folderName += (char)((int)'a' + rand.nextInt((int)'z'-(int)'a'));
        }

        if (new File(folderName).mkdirs()) {
            try {
                if (new File(folderName + "/" + FILE_NAME).createNewFile())
                    System.out.println("Success!");
                else
                    System.err.println("Cannot create file!");
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        else {
            System.out.println("Cannot create folder!");
        }
    }
}
