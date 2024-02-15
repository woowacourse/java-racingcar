package model;

public enum CarStatus {
  FORWARD("-"),
  STOP("");

  private final static int FORWARD_CONDITION = 4;

  private final String output;

  CarStatus(String output) {
    this.output = output;
  }

  public String getOutput() {
    return output;
  }

  public static CarStatus decide(int num) {
    if (num >= FORWARD_CONDITION) {
      return FORWARD;
    }
    return STOP;
  }
}
