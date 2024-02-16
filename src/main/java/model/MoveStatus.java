package model;

import java.util.List;

public enum MoveStatus {
  FORWARD("-", 4),
  STOP("", 0);


  private final String output;
  private final int condition;

  MoveStatus(String output, int condition) {
    this.output = output;
    this.condition = condition;
  }

  public static MoveStatus decide(int num) {
    if (num >= FORWARD.condition) {
      return FORWARD;
    }
    return STOP;
  }

  public static String join(String delimiter, List<MoveStatus> moveStatuses) {
    return String.join(delimiter, moveStatuses.stream().map(MoveStatus::getOutput).toList());
  }

  public String getOutput() {
    return output;
  }
}
