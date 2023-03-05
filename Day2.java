import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Game{

    /** string representation of each player's move */
    private final String p1Move; // A B C
    private final String p2Move; // X Y Z

   /**
    * creates a new instance of a rock-paper-scissors game
    * */
   Game(String p1Move, String p2Move){
        this.p1Move = p1Move;
        this.p2Move = p2Move;
    }

    /**
     * plays a single game of rock-paper-scissors
     * Note: large sections are commented out to implement part 2 of the problem
     * @return player 2s score
     * */
    int play(){
        int p1Score;
//        int p2Score = 0;

        if (p1Move.equals("A")){
            p1Score = 1;
        }
        else if (p1Move.equals("B")){
            p1Score = 2;
        }
        else{
            p1Score = 3;
        }

//        Note: part one X = rock, Y = paper, Z = scissors

//        if (p2Move.equals("X")){
//            p2Score = 1;
//        }
//        else if (p2Move.equals("Y")){
//            p2Score = 2;
//        }
//        else{
//            p2Score = 3;
//        }
        if (p2Move.equals("X")){
            if (p1Score == 1){
                return 3;
            }
            else if (p1Score == 2){
                return 1;
            }
            else{
                return 2;
            }
        }
        else if (p2Move.equals("Y")){
            return 3 + p1Score;
        }
        else {
            if (p1Score == 1){
                return 2 + 6;
            }
            else if (p1Score == 2){
                return 3 + 6;
            }
            else{
                return 1 + 6;
            }
        }

//        if (p1Score == p2Score){
//            return p2Score + 3; // Draw
//        }
//        else if ((p1Score == 1 && p2Score == 3) || (p1Score == 2 && p2Score == 1) || (p1Score == 3 && p2Score == 2)){
//            return p2Score; // Loss
//        }
//        else{
//            return p2Score + 6; // Win
//        }
    }
}
public class Day2 {

    /**
     * makes a list of game objects
     * */
    private static ArrayList<Game> compileGames(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner sc = new Scanner(f);

        ArrayList<Game> games = new ArrayList<>();

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] splitLine = line.split(" ");

            games.add(new Game(splitLine[0], splitLine[1]));
        }
        return games;
    }

    /**
     * compiles a list of games and plays them to calculate a total score
     * */
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Game> games = compileGames(args[0]);

        int totalScore = 0;
        for (Game game: games){
            totalScore += game.play();
        }

        System.out.println(totalScore);
    }
}
