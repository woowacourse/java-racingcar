package racingcar;

import java.util.List;

public class Car{
    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    public static List<String> askCarNames(){
        return CarException.askCarNamesException();
    }

    public static int askTotalTurns() {
        return CarException.askTotalTurnsException();
    }

    public void moveCar(){
        int randomNumber = randomNumberGenerator();
        if(randomNumber >= 4){
            position++;
        }
    }

    public static int randomNumberGenerator(){
        return (int) (Math.random() * 10);
    }

    public void printPosition(){
        System.out.print(this.name + " : ");
        for(int i=0; i<this.position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public int findMax(int max) {
        if (position > max) {
            max = position;
        }
        return max;
    }

    public void findScoreSameAsMax(int maxPosition, List<String> winners){
        if(maxPosition == this.position){
            winners.add(this.name);
        }
    }

    public void setPosition(int position){
        //테스트코드용
        this.position = position;
    }
}
