package domain;

public class Car {
    private static final String FORMAT = "%s : %s";

    private final Name name;
    private Position position;


    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }



    public void move() {
        position.move();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.toString();
    }

    public String getCurrentState() {
        return String.format(FORMAT, name, position);
    }
}
