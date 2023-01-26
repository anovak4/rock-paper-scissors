/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;
import java.text.NumberFormat;

/**
 *
 * @author robno
 */
public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "", comp = "", play = "";
        int playWins = 0, compWins = 0, ties = 0, games = 0, compNum = 0;
        NumberFormat fmt = NumberFormat.getPercentInstance();
        
        System.out.println("Please use all lowercase when selecting rock, paper, or scissors. Thanks!");
        
        while(!play.equals("no"))
        {
            //Reads player's move
            System.out.print("\nSelect your move: ");
            input = Keyboard.readString();
            while(!input.equals("rock") && !input.equals("paper") && !input.equals("scissors") && !input.equals("gun"))
            {
                System.out.print("Not a valid choice. Please check your spelling and remember to put it in all lowercase. Enter again: ");
                input = Keyboard.readString();
            }
            
            //Determines computer's move
            compNum = (int)(Math.random() * 3);
            if((Math.random() * 100) < 1)
                comp = "gun";
            else
            {
                if(compNum == 0)
                comp = "rock";
                else if(compNum == 1)
                    comp = "paper";
                else
                    comp = "scissors";
            }
            
            //Figures out who won and increments their games won
            if(input.equals("rock") && comp.equals("paper"))
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". Sorry, you lost.");
                compWins++;
            }
            else if(input.equals("rock") && comp.equals("scissors"))
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". Good job, you won!");
                playWins++;
            }
            else if(input.equals("paper") && comp.equals("rock"))
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". Good job, you won!");
                playWins++;
            }
            else if(input.equals("paper") && comp.equals("scissors"))
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". Sorry, you lost.");
                compWins++;
            }
            else if(input.equals("scissors") && comp.equals("rock"))
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". Sorry, you lost.");
                compWins++;
            }
            else if(input.equals("scissors") && comp.equals("paper"))
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". Good job, you won!");
                playWins++;
            }
            else if(input.equals("gun"))
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". Good job, you won!");
                playWins++;
            }
            else if(comp.equals("gun"))
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". Sorry, you lost.");
                compWins++;
            }
            else
            {
                System.out.println("You picked " + input + " and the computer picked " + comp + ". You tied!");
                ties++;
            }
            
            // Increments game count
            games++;
            
            //Determines of the player wants to keep playing or not
            System.out.print("Would you like to play again? (yes/no): ");
            play = Keyboard.readString();
            while(!play.equals("yes") && !play.equals("no"))
            {
                System.out.print("Not a valid choice. Please remember to put it in all lowercase. Enter again: ");
                play = Keyboard.readString();
            }
        }
        
        System.out.println("\nThank you for playing Rock, Paper, Scissors! Here are your statistics:");
        System.out.println("\nGames played: " + games);
        System.out.println("Games won: " + playWins);
        System.out.println("Games lost: " + compWins);
        System.out.println("Games tied: " + ties);
        System.out.println("Winning percentage: " + fmt.format((double)playWins / games));
    }
    
}
