import java.lang.*;

public class OOPig extends Object {
  public OOPig() {
  }

  public static void main(String[] args) {
    int randomIndex = (int)(Math.random()*2+1);
    System.out.println("You will be player #" + randomIndex);
    
    PigPlayer player1;
    PigPlayer player2;
    if (randomIndex == 1) {
      player1 = new UserPigPlayer();
      player2 = new HoldAt20PigPlayer();
    } else {
      player1 = new HoldAt20PigPlayer();
      player2 = new UserPigPlayer();
    }
    
    PigGame game = new PigGame(player1, player2);
    game.play();
  }
}