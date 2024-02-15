package model;

import java.util.List;

public enum MoveStatus {
  FORWARD("-"),
  STOP("");

  private static final int FORWARD_CONDITION = 4;

  private final String output;

  MoveStatus(String output) {
    this.output = output;
  }

  public String getOutput() {
    return output;
  }

  public static MoveStatus decide(int num) {
    if (num >= FORWARD_CONDITION) {
      return FORWARD;
    }
    return STOP;
  }

  public static String join(String delimiter, List<MoveStatus> moveStatuses) {
    return String.join(delimiter, moveStatuses.stream().map(MoveStatus::getOutput).toList());
  }
}
