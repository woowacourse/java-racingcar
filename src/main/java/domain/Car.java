package domain;

public class Car {
    private String name;
    private int position = 0;

    Car(String name){
        this.name = name;
    }

    public void move(int randomNumber) {
        if (isMove(randomNumber)) {
            position++;
        }
    }

    public static boolean isMove(int randomNumber){
        return randomNumber >= Constant.MOVE_CONDITION;
    }

    public void printCurrentPosition(){
        System.out.print(String.format("%s : ", name));
        for (int i = 1; i <= position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
