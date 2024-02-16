package racingcar.domain;

public record CarStatus(String name, int position) implements Comparable<CarStatus> {

    public boolean isPositionAt(int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(CarStatus status) {
        return this.position - status.position();
    }
}
