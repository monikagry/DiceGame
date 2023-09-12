import java.util.Scanner;
import java.util.Random;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min_value = 1;
        int max_value = 6;
        
        int players;
        while (true) {
            System.out.print("Enter the number of players (2 - 4): ");
            if (scanner.hasNextInt()) {
                players = scanner.nextInt();
                if (players >= 2 && players <= 4) {
                    break;
                } else {
                    System.out.println("Must be between 2 - 4 players.");
                }
            } else {
                System.out.println("Invalid input, try again.");
                scanner.next(); // Clear invalid input
            }
        }
        
        int max_score = 50;
        int[] player_scores = new int[players];
        
        while (maxScore(player_scores) < max_score) {
            for (int player_idx = 0; player_idx < players; player_idx++) {
                System.out.println("\nPlayer number " + (player_idx + 1) + "'s turn has just started!");
                System.out.println("Your total score is: " + player_scores[player_idx] + "\n");
                int current_score = 0;
                
                while (true) {
                    System.out.print("Would you like to roll (y)? ");
                    String should_roll = scanner.next().toLowerCase();
                    if (!should_roll.equals("y")) {
                        break;
                    }
                    
                    int value = random.nextInt(max_value - min_value + 1) + min_value;
                    if (value == 1) {
                        System.out.println("You rolled a 1! Turn done!");
                        current_score = 0;
                        break;
                    } else {
                        current_score += value;
                        System.out.println("You rolled a: " + value);
                    }
                    
                    System.out.println("Your score is: " + current_score);
                }
                
                player_scores[player_idx] += current_score;
                System.out.println("Your total score is: " + player_scores[player_idx]);
            }
        }
        
        int winning_idx = indexOfMaxScore(player_scores);
        System.out.println("Player number " + (winning_idx + 1) + " is the winner with a score of: " + player_scores[winning_idx]);
    }
    
    private static int maxScore(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
    
    private static int indexOfMaxScore(int[] scores) {
        int max = scores[0];
        int index = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                index = i;
            }
        }
        return index;
    }
}
