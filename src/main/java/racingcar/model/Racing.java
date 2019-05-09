package racingcar.model;

import java.util.Random;

public class Racing {

    private static final int FOWARD_NUM = 3;

    public int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }

    public int move(Car car, int randomNumber){
        int position = car.getPosition();

        if(randomNumber > FOWARD_NUM){
            position++;
        }

        return position;
    }
}
