package racingcar.vo;

public class Attempt {
  private int attempt;

  public Attempt(String attempt){
    this.attempt = toInteger(attempt);
  }

  private int toInteger(String string) {
    return Integer.parseInt(string);
  }

  public int get(){
    return attempt;
  }
}
