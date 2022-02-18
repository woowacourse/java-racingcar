package racingcargame.model;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_MOVE_ACCESSIBLE = 4;

    private final String name;
    private int position;

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    boolean isWinner(Car winner) {
        return position == winner.getPosition();
    }

    void move(int number) {
        if (number >= MINIMUM_MOVE_ACCESSIBLE) {
            position ++;
        }
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(position, car.getPosition());
    }

    String getName(){
        return name;
    }

    int getPosition() {
        return position;
    }
}
