import java.lang.*;

public class HoldAt20PigPlayer extends Object implements PigPlayer {
  private int score;
  
  public HoldAt20PigPlayer() {
  }
  
  public boolean isRolling(int myScore, int otherScore, int turnTotal) {
    score = myScore;
    return (turnTotal < 20 && (myScore + turnTotal) < 100);
  }
  
  public int getScore() {
    return score;
  }
  
  public void setScore(int s) {
    score = s;
  }
}