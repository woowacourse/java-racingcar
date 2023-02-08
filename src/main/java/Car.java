import java.util.List;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void addPosition() {
        position = position + 1;
    }

}
