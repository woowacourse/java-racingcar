package racinggame;

public class Car {
    private static final int MOVE_POINT = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_POINT) {
            this.position++;
        }
    }

    public boolean isMaxInstance(int maxInstance) {
        return position == maxInstance;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

}
