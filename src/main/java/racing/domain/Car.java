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
