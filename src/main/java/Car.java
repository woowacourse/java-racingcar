public class Car {
    private static final String FORMAT = "%s : %s";

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position();
    }

    public String getCurrentState() {
        return String.format(FORMAT, name, position);
    }


}
