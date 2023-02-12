package racingcar.domain.record;

import java.util.Objects;

public class GameResultOfCar {

    private final int gameRound;
    private final String carName;
    private final int position;

    public GameResultOfCar(final int gameRound, final String carName, final int position) {
        this.gameRound = gameRound;
        this.carName = carName;
        this.position = position;
    }

    public int getGameRound() {
        return gameRound;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResultOfCar that = (GameResultOfCar) o;
        return gameRound == that.gameRound && position == that.position && carName.equals(that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameRound, carName, position);
    }

    @Override
    public String toString() {
        return "GameResultOfCar{" +
                "gameRound=" + gameRound +
                ", carName='" + carName + '\'' +
                ", position=" + position +
                '}';
    }
}
