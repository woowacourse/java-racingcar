package racingcar;

public class RacingCarDto {

    private String name;
    private int position;

    public RacingCarDto(String name, int postition) {
        this.name = name;
        this.position = postition;
    }

    public static RacingCarDto from(RacingCar racingCar) {
        return new RacingCarDto(racingCar.getName(), racingCar.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
