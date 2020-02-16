package application.racingGame;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public void moveForward(){
        position++;
    }

    public int getPosition() {
        return this.position;
    }

}
