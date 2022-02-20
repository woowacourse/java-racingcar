package racingcar.service;

public class ScoreDto {
    private final String name;
    private final int point;

    public ScoreDto(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}
