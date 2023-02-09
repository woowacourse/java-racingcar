package racingcar.domain.dto;

public class DrivingDistance {

    private final Integer distance;

    private DrivingDistance(int distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public static DrivingDistance of(int distance) {
        return new DrivingDistance(distance);
    }
}
