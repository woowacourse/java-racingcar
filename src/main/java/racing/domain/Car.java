package racing.domain;

class Car {

    private final String name;
    private int distance;

    Car(int distance, String name) {
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
        distance += 1;
    }

    void stop() {
    }
}
