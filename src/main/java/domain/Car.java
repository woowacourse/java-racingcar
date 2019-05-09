package domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name){
        this(name,0);
    }

    public void move() {
        position++;
    }
}
