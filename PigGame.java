import java.lang.*;
import java.util.*;

public class PigGame extends Object {
  private static int GOAL_SCORE = 100;
  private PigPlayer player1;
  private PigPlayer player2;
  private int turnTotal = 0;
  
  public PigGame() {
    player1 = new UserPigPlayer();
    player2 = new UserPigPlayer();
  }
  
  public PigGame(PigPlayer player1, PigPlayer player2) {
    this.player1 = player1;
    this.player2 = player2;
  }
  
  public void play() {
    int whoseTurn = 0;
    int turnTotal = 0;
    
    Die d = new Die();
    while (player1.getScore() < GOAL_SCORE && player2.getScore() < GOAL_SCORE) {
      System.out.println("Player 1 score: " + player1.getScore());
      System.out.println("Player 2 score: " + player2.getScore());
      
      whoseTurn++;
      if (whoseTurn % 2 == 1) {
        System.out.println("It is player 1" + "'s turn.");
        System.out.print("Roll: ");
        int roll = d.nextRoll();
        System.out.print(roll);
        System.out.println();
        
        if (player1.getClass().equals(UserPigPlayer.class)) {
          userPlay(roll, 1);
        } else {
          notUserPlay(roll, 1);
        }
        
      } else {
        System.out.println("It is player 2" + "'s turn.");
        System.out.print("Roll: ");
        int roll = d.nextRoll();
        System.out.print(roll);
        System.out.println();
        
        if (roll != 1)
          turnTotal = roll;
        
        if (player2.getClass().equals(UserPigPlayer.class)) {
          userPlay(roll, 2);
        } else {
          notUserPlay(roll, 2);
        }
      }
      
    }
    
    if (player1.getScore() >= GOAL_SCORE) 
      System.out.println("Player 1 wins!");
    else 
      System.out.println("Player 2 wins!");
  }
  
  public void userPlay(int roll, int playerNum) {
    if (roll == 1) {
      turnTotal = 0;
      System.out.println("Turn total: 0");
      System.out.println("New score: " + score(playerNum));
      return;
    } 
    turnTotal = roll;
    System.out.print("Turn total: " + turnTotal);
    System.out.print("\tRoll/hold? ");
    Scanner scan = new Scanner(System.in);
    String holdOrRoll = scan.nextLine();
    
    while (holdOrRoll.length() == 0) {
      int a = roll();
      if (a == 1) {
        turnTotal = 0;
        System.out.println("Turn total: 0");
        System.out.println("New score: " + score(playerNum));
        return;
      }
      System.out.print("Turn total: " + turnTotal);
      System.out.print("\tRoll/hold? ");
      holdOrRoll = scan.nextLine();
    }
    
    setScore(score(playerNum) + turnTotal, playerNum);
    System.out.println("Turn total: " + turnTotal);
    turnTotal = 0;
    System.out.println("New score: " + score(playerNum));
    
  }
  
  
  public void notUserPlay(int roll, int playerNum) {
    if (roll == 1) {
      turnTotal = 0;
      System.out.println("Turn total: 0");
      System.out.println("New score: " + score(playerNum));
      return;
    } 
    
    while (roll != 1 && turnTotal < 20 && score(playerNum) + turnTotal < GOAL_SCORE) {
      turnTotal += roll;
      System.out.print("Roll: ");
      Die d = new Die();
      roll = d.nextRoll();
      System.out.print(roll);
      System.out.println();
    }
    
    if (roll == 1) {
      turnTotal = 0;
      System.out.println("Turn total: 0");
      System.out.println("New score: " + score(playerNum));
      return;
    } 
    
    setScore(score(playerNum) + turnTotal, playerNum);
    System.out.println("Turn total: " + turnTotal);
    turnTotal = 0;
    System.out.println("New score: " + score(playerNum));

  }
  
  public int score(int playerNum) { 
    int score;
    if (playerNum == 1) 
      score = player1.getScore();
    else
      score = player2.getScore();
    return score;
  }
  
  public void setScore(int score, int playerNum) {
    if (playerNum == 1) 
      player1.setScore(score);
    else
      player2.setScore(score);
  }
  
  public int roll() {
    System.out.print("Roll: ");
    Die d = new Die();
    int roll = d.nextRoll();
    System.out.print(roll);
    System.out.println();
    turnTotal += roll;
    return roll;
  }
  
}