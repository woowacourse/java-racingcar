public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }



    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
