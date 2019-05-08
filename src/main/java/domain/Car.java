package domain;

public class Car {
    private static final int MIN_NAME_LEN = 1;
    private static final int MAX_NAME_LEN = 5;
    private static final int GO_RAN_NUM = 4;

    private String name;
    private int position = 0;

    public Car(String name){
        if(MIN_NAME_LEN > name.length() || MAX_NAME_LEN < name.length()){
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 입력해주세요.");
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void increasePositionOrNot(int random){
        if(GO_RAN_NUM <= random){
            this.position++;
        }
    }
}
