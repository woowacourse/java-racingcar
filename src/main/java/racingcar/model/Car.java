package racingcar.model;

public class Car implements Comparable<Car> {

    private final String name;
    private Integer progress;
    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public void goForward(){
        this.progress++;
    }
    public String getName() {
        return name;
    }

    public Integer getProgress() {
        return progress;
    }

    @Override
    public int compareTo(Car other) {
        return this.progress - other.progress;
    }
}

