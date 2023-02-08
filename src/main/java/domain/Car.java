public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean move(int randomNumber) {
        return randomNumber >= 4;
    }
}
