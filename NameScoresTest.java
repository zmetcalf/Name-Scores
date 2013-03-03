public class NameScoresTest {
    
    public static void main(String [] args) {
        String fileName = "names.txt";
        NameScores score = new NameScores(fileName);        
        System.out.println("The total is: " + score.getNameScoreTotal());
    }
}