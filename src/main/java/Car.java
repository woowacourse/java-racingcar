public class Car {
    private static final double INITIAL_RANDOM_NUMBER = -1;
    private int location;
    private double randomNumber;

    public Car() {
        this.location = 1;
        this.randomNumber = INITIAL_RANDOM_NUMBER;
    }

    public int getLocation() {
        return this.location;
    }

    public double getRandomNumber() {
        return this.randomNumber;
    }

    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void forward() {
        this.location += 1;
    }
}
