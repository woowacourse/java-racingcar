package racingcargame.domain;

public class CarSnapShot {

    private final String name;
    private final int position;

    public CarSnapShot(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
