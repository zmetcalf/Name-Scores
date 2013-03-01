import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class NameScores {
    
    ArrayList<String> nameList = new ArrayList<String>();
    private String testListOfNames = "";
    private String[] testArray;
    
    public NameScores (String fileName) {
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get(fileName); 
        
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                testListOfNames += line;
            }
            
        }
        catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        setNameList();
    }   
    
    private void setNameList() {
        testArray = new String[(testListOfNames.split("\",\"")).length];
        testArray = testListOfNames.split("\",\"");
    }
    
    public String getNameList() {
        return testArray[1];
    }
}