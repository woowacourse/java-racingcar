package application.racing;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveCarWhenNumberOverFour(int number) {
        if (isNumberOverFour(number)) {
            this.position = this.position + ConstantForRacing.ADD_POSITION;
        }
    }

    private boolean isNumberOverFour(int number) {
        return number >= ConstantForRacing.MOVE_STANDARD;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
