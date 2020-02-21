package racingcargame.domain.car;

public class Car {
    private Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void decideGoOrStop(int num) {
        position.decideGoOrStop(num);
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
