package racinggame;

public class Car {
    private static final int MOVE_POINT = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_POINT) {
            this.position++;
        }
    }

    public boolean isMatch(int position) {
        return this.position == position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        String result;

        result =  name + " : ";

        for (int i = 0; i < position; i++) {
            result += "-";
        }

        return result;
    }
}
