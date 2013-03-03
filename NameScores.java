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
        System.out.println(getNameScore("\"COLIN\""));
        //alphabitizeList();
    }   
    
    private void setNameList() {
        testArray = testListOfNames.split(",");
    }
    
    public String getNameList() {
        return testArray[0] + " " + testArray[1];
    }
    
    private void alphabitizeList() {
        //toCharArray will be helpful for alphabitization
        //for(int x: testArray) {    
        //    for(int i : testArray) {
            
        //    }
        //}
    }
    
    private int getNameScore(String name) {
        char[] charNameArray = new char[name.length() - 2];
        int nameTotal = 0;
        
        name.getChars(1, (name.length() - 1),charNameArray, 0);
        System.out.println(charNameArray);
        for(int i : charNameArray) {
            nameTotal += (i - 64);
        }
        return nameTotal;
    }
}