package racingcar.dto;

public class CarResponseDto {
    private String name;
    private int position;

    public CarResponseDto(){
    }

    public CarResponseDto(String name, int position){
        this.name = name;
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPosition(int position){
        this.position = position;
    }
}
