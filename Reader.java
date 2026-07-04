import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public ArrayList<String> readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));) {
            String line;

            while((line = br.readLine()) != null)
                lines.add(line);

        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file.");
        } catch (IOException e) {
            System.out.println("Could not read file.");
        }

        return lines;
    }
}
