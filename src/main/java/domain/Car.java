package domain;

public class Car {
    private final CarName carName;
    private Integer distance = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            distance++;
        }
    }

    public String getCarName() {
        return carName.getName();
    }

    public Integer getDistance() {
        return distance;
    }

    public void printCarInfo() {
        System.out.print(carName.getName() + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
