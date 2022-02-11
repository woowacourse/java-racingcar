package racingcar.vo;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

  private List<CarName> winners;

  public Winners(List<CarName> winners) {
    this.winners = winners;
  }

  @Override
  public String toString() {
    return winners.stream()
        .map(CarName::get)
        .collect(Collectors.joining(", "))
        + "가 최종 우승했습니다.";
  }
}
