package racingcar.vo;

public class CarName {
  private String name;

  public CarName(String name) {
    this.name = name;
  }

  public String get() {
    return name;
  }

  public boolean equals(CarName carName){
    return carName.name.equals(this.name);
  }
}
