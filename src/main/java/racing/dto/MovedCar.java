package racing.dto;

public class MovedCar {
    private String name;
    private int position = 0;

    public MovedCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
