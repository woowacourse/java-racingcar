package racingcar.vo;

public class CarName {

  public static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름으로 공백을 입력할 수 없습니다.";
  private String name;

  public CarName(String name) {
    validEmpty(name);
    this.name = name;
  }

  public String get() {
    return name;
  }

  public boolean equals(CarName carName) {
    return carName.name.equals(this.name);
  }

  private void validEmpty(String name) {
    if (name.isEmpty()) {
      throw new RuntimeException(EMPTY_CAR_NAME_ERROR_MESSAGE);
    }
  }
}
