import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        String fileName = "info.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String firstLine = br.readLine();
            System.out.println("First Line: " + firstLine);
        } catch (IOException e) {
            System.out.println("Error Reading the first line");
        }
    }
}
