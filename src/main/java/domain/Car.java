package domain;

import java.util.LinkedList;
import java.util.List;

public class Car implements Comparable<Car> {
    private static final String NAME_CONVENTION = "^[a-zA-Zㄱ-ㅎ가-힣]{1,5}$";
    private static final int MOVE_STANDARD = 4;
    private final String name;
    private final List<Location> roundHistory;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        roundHistory = new LinkedList<>(List.of(new Location(0)));
    }

    private void validateCarName(String name) {
        if (!name.matches(NAME_CONVENTION)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 영어, 한글만 가능합니다.");
        }
    }

    public void move(int randomNumber) {
        int lastLocation = getLastLocation();
        if (randomNumber >= MOVE_STANDARD) {
            lastLocation++;
        }
        roundHistory.add(new Location(lastLocation));
    }

    public String getName() {
        return name;
    }

    public int getRoundLocation(int round) {
        if (round >= 0) {
            return roundHistory.get(round).getLocation();
        }
        throw new IllegalArgumentException("유효하지 않은 라운드입니다.");
    }

    public int getLastLocation() {
        if (roundHistory.size() > 0) {
            return roundHistory.get(roundHistory.size() - 1).getLocation();
        }
        return 0;
    }

    @Override
    public int compareTo(Car car) {
        return this.getLastLocation() - car.getLastLocation();
    }
}
