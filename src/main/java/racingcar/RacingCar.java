package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        Car c = new Car("ss");
        c.move(new Car.RandomMovement());
    }

}
