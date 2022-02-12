package racingcargame.model;

public class CarVO {
    private final String name;
    private final int position;

    public CarVO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
