package racingcar.vo;

public class CarName {

  private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름으로 공백을 입력할 수 없습니다.";
  private static final String TOO_LONG_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 너무 깁니다.";
  private static final int MAX_LENGTH = 5;

  private String name;

  public CarName(String name) {
    validEmpty(name);
    validLength(name);
    this.name = name;
  }

  public String get() {
    return name;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CarName)) {
      return false;
    }
    CarName carName = (CarName) object;
    return carName.name.equals(this.name);
  }

  @Override
  public int hashCode(){
    return name.hashCode();
  }

  private void validEmpty(String name) {
    if (name.isEmpty()) {
      throw new RuntimeException(EMPTY_CAR_NAME_ERROR_MESSAGE);
    }
  }

  private void validLength(String name) {
    if (name.length() > MAX_LENGTH) {
      throw new RuntimeException(TOO_LONG_CAR_NAME_ERROR_MESSAGE);
    }
  }
}
