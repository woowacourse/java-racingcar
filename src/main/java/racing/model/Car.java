package racing.model;

public class Car {

    public static final int MAX_NAME_SIZE = 5;
    private String name;
    private int position;

    public Car(String name) {
        checkNameLengthUnderSix(name);
        checkNullOrEmptyName(name);
        this.name = name;
    }


    private void checkNullOrEmptyName(String name) {
        if (name == null || name.isEmpty()){
            throw new NullPointerException("차이름은 공백 또는 빈 문자열일 수 없습니다.");
        }
    }

    private void checkNameLengthUnderSix(String name) {
        if (name.length() > MAX_NAME_SIZE){
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public boolean isNameEqual(String name) {
        return this.name == name;
    }

    public void move(RandomNo randomNo){
        if (randomNo.isMovable()){
            position += 1;
        }
    }

    public String getPositionByDash(int position) {
        StringBuilder dash = new StringBuilder();
        for (int index = 0; index < position; index++){
            dash.append("-");
        }
        return dash.toString();
    }
}
