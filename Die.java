import java.lang.*;

public class Die extends Object {
  private int[] dice;
  
  public Die() {
    dice = new int[6];
    for (int i = 0; i < 6; i++) {
      dice[i] = i+1;
    }
  }
  
  public Die(int[] outcomes) {
    dice = new int[6];
    for (int i = 0; i < 6; i++) {
      dice[i] = outcomes[i];
    }
  }
  
  public Die(int sides, int min) {
    dice = new int[sides];
    for (int i = 0; i < sides; i++) {
      dice[i] = min + i;
    }
  }
  
  public int nextRoll() {
    int randomIndex = (int)(Math.random()*(dice.length)+1);
    return dice[randomIndex-1];
  }
  
}