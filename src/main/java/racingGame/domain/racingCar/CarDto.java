package racingGame.domain.racingCar;

public class CarDto {
    final Name name;
    final int position;

    public CarDto(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }
}
