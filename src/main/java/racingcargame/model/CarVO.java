package racingcargame.model;

public class CarVO {
    String name;
    int position;

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
