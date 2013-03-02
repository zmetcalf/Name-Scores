import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class NameScores {
    
    private String testListOfNames = "";
    private String[] testArray;
    private long nameScoreTotal = 0;
    
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
        alphabitizeList();
    }   
    
    private void setNameList() {
        testArray = testListOfNames.split(",");
    }
    
    public String getNameList() {
        return testArray[0] + " " + testArray[1];
    }
    
    private void alphabitizeList() {
        //toCharArray will be helpful for alphabitization
        for(int x: testArray) {    
            for(int i : testArray) {
            
            }
        }
    }
}