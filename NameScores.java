import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays; //required for sort - http://leepoint.net/notes-java/data/arrays/70sorting.html

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
        calculateScore();
    }   
    
    private void setNameList() {
        testArray = testListOfNames.split(",");
    }
    
    public long getNameScoreTotal() {
        return nameScoreTotal;
    }
    
    private void alphabitizeList() {
        Arrays.sort(testArray);
    }
    
    private int getNameScore(String name) {
        char[] charNameArray = new char[name.length() - 2];
        int nameTotal = 0;
        
        name.getChars(1, (name.length() - 1),charNameArray, 0);
        
        for(int i : charNameArray) {
            nameTotal += (i - 64);
        }
        return nameTotal;
    }
    
    private void calculateScore() {
        int counter = 1;
        
        for(String i : testArray) {
            nameScoreTotal += (getNameScore(i) * counter);
            counter++;
        }
    }
}