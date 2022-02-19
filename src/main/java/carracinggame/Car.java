package carracinggame;

public class Car {

    public static final int INITIAL_POSITION = 0;
    public static final String SPACE_BETWEEN_NAME_DISTANCE = " : ";
    public static final String DISTANCE_OUTPUT = "-";

    private final String name;
    private int position = INITIAL_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar(boolean isGoing) {
        if (isGoing) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        String output = name + SPACE_BETWEEN_NAME_DISTANCE;
        for (int idx = 0; idx < position; idx++) {
            output += DISTANCE_OUTPUT;
        }
        return output;
    }

    public int getPosition() {
        return this.position;
    }

    public void printName() {
        System.out.print(this.name);
    }

    public boolean checkSamePosition(int maxPosition) {
        return this.position == maxPosition;
    }

}
