package domain;

public class Car implements Comparable<Car> {

    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void move() {
        this.score++;
    }


    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.score, o.score);
    }

    public boolean isSame(Car o) {
        return compareTo(o) == 0;
    }
}
