package domain;

public class Car {
    private String name;

    private int position;

    public Car(String name) {
        if(name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.position = 0;
    }

    public void tryMove(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
