public interface PigPlayer {
  
  public boolean isRolling(int myScore, int otherScore, int turnTotal); 
  public int getScore();
  public void setScore(int s);
}