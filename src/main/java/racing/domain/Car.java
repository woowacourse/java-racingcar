package racing.domain;

class Car implements Comparable<Car> {

  static final int ONCE_MOVE_DISTANCE = 1;

  private final String name;
  private int distance;

  Car(int distance, String name) {
    CarNameValidator.validate(name);
    this.distance = distance;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Car car = (Car) o;

    if (distance != car.distance) {
      return false;
    }
    return name.equals(car.name);
  }

  @Override
  public int hashCode() {
    int result = distance;
    result = 31 * result + name.hashCode();
    return result;
  }

  void go() {
    distance += ONCE_MOVE_DISTANCE;
  }

  void stop() {
  }

  @Override
  public int compareTo(Car o) {
    return o.distance - distance;
  }

  boolean hasSameDistance(Car other) {
    return distance == other.distance;
  }

  String getName() {
    return name;
  }

  int getDistance() {
    return distance;
  }
}
