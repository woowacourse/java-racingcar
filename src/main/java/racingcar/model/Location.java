package racingcar.model;

public class Location {

    private int location;

    public int getCurrentPosition() {
        return location;
    }

    public void increase() {
        this.location++;
    }
}
