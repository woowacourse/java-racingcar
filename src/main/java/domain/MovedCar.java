package domain;

import java.util.Comparator;
import java.util.Objects;

public class MovedCar {
    public static final Comparator<MovedCar> positionComparator = (o1, o2) -> o1.position - o2.position;

    private final String name;
    private final int position;

    public MovedCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovedCar movedCar = (MovedCar) o;
        return position == movedCar.position &&
                Objects.equals(name, movedCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
