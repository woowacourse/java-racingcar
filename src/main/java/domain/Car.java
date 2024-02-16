package domain;

public class Car {

    private final CarName carName;
    private Integer position;
    private final PowerGenerator powerGenerator;

    private Car(CarName carName, int position) {
        this.carName = carName;
        this.position = position;
        this.powerGenerator = new PowerGenerator();
    }

    public static Car of(String name, int position) {
        CarName carName = CarName.from(name);
        return new Car(carName, position);
    }

    public Integer getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    public void tryMove() {
        if (powerGenerator.generate().isSufficientPower()) {
            move();
        }
    }

    private void move() {
        position++;
    }
}
