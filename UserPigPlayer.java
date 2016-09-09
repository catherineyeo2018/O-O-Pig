import java.lang.*;
import java.util.*;

public class UserPigPlayer extends Object implements PigPlayer {
  private int score;
  
  public UserPigPlayer() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter nothing to roll; enter anything to hold. ");
  }
  
  public boolean isRolling(int myScore, int otherScore, int turnTotal) {
    score = myScore;
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Turn total: " + turnTotal);
    System.out.print("\tRoll/hold? ");
    String holdOrRoll = scan.nextLine();
    
    return (holdOrRoll.length() > 0);
  }
  
  public int getScore() {
    return score;
  }
  
  public void setScore(int s) {
    score = s;
  }
}