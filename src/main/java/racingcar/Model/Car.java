package racingcar.Model;

public class Car {
    public static final int CRITERIA_FOR_GO = 4;
    private String carName;


    public Car(String carName) {
        this.carName = carName;
    }

    public boolean goOrNot(int randomNumber) {
        return randomNumber >= CRITERIA_FOR_GO;
    }
}
