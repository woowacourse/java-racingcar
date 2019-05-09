package domain;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Car {
    public static Comparator<Car> compareByPosition = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.position - o2.position;
        }
    };

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name){
        this(name,0);
    }

    public String getName() {
        return name;
    }

    public String getStatusString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" : ");

        for(int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void move() {
        position++;
    }
}
