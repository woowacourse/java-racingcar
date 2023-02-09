package racingcar.dto;

public class RacingCarDto {
    private String name;
    private Integer point;

    public RacingCarDto(String name, Integer point){
        this.name = name;
        this.point = point;
    }

    public String getName(){
        return this.name;
    }

    public Integer getPoint() {
        return point;
    }
}
