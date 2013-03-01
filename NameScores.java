import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;


public class NameScores {
    
    public NameScores () {
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get("names.txt"); 
        // - /var/lib/stickshift/513026b2e0b8cdd470000003/app-root/data/412440/
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }   
}