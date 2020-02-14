package application.racing.domain;

public class Car {
    private String name;
    private Position position;

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public void moveCarWhenNumberOverFour(int number) {
        this.position.move(number);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
