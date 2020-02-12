package racingcargame.domain;

public class Car {
    Name name;
    int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }
}
