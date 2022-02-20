package racingcar.view.log;

public class CarForLog {

    private final String name;
    private final int position;

    public CarForLog(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
