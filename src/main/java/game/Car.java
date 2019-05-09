package game;

public class Car {
    private static int MOVE_POINT = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return this.name;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_POINT) {
            this.position++;
        }
    }

    public boolean isMaxInstance(int maxInstance) {
        return position == maxInstance;
    }

    public int getPosition() {
        return position;
    }

}
