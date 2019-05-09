package domain;

import java.util.stream.IntStream;

public class Car {
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
