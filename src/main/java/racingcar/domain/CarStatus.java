package racingcar.domain;

public record CarStatus(String name, int position) implements Comparable<CarStatus> {

    public boolean isPositionAt(int targetPosition) {
        return position == targetPosition;
    }

    @Override
    public int compareTo(CarStatus status) {
        return position - status.position;
    }
}
