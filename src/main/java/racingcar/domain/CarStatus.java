package racingcar.domain;

public record CarStatus(String name, int position) implements Comparable<CarStatus> {

    public boolean isPositionAt(final int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(final CarStatus status) {
        return this.position - status.position();
    }
}
