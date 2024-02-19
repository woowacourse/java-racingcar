package racing.domain;

class Car implements Comparable<Car> {

  static final int ONCE_MOVE_DISTANCE = 1;

  private final String name;
  private int position;

  Car(int position, String name) {
    CarNameValidator.validate(name);
    this.position = position;
    this.name = name;
  }

  void go() {
    position += ONCE_MOVE_DISTANCE;
  }

  void stop() {
  }

  @Override
  public int compareTo(Car o) {
    return o.position - position;
  }

  String getName() {
    return name;
  }

  int getPosition() {
    return position;
  }
}
