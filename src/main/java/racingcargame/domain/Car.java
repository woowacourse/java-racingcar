package racingcargame.domain;

public class Car {
    Name name;
    int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public void go(Engine engine) {
        if (engine.isHigherThanLimit()) {
            position++;
        }
    }

    public boolean isSameTo(int position) {
        return this.position == position;
    }
}
