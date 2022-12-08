import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class demo {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("data/words_250.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line.replaceAll("[^a-zA-Z0-9]", " "));
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}