package domain;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    @Override
    public String toString() {
        String bars = "";
        for (int i = 0; i < position; i++) {
            bars += "-";
        }

        return name + " : " + bars;
    }

    public void Move() {
        this.position++;
    }

    @Override
    public int compareTo(Car compareCar) {
        return (this.position > compareCar.position) ? 1 : (this.position == compareCar.position) ? 0 : -1;
    }
}
