package racingcar;

import java.util.List;

public class OuputView {

    private static final String TRIAL_RESULT = "실행 결과:";
    private static final String POSITION_LOCATION = "-";
    public static final String CAR_POSITION_PARTITION_FORMAT = ":";

    public static void printGameStartMessage(){
        System.out.println(TRIAL_RESULT);
    }

    public static void printCurrentRacingSituation(RacingCars racingCars){
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        for (RacingCar racingCar : racingCarList) {
            String currentPosition = getCurrentPosition(racingCar);
            System.out.println(racingCar.getName() + CAR_POSITION_PARTITION_FORMAT +currentPosition);
        }
        System.out.println();
    }

    private static String getCurrentPosition(RacingCar racingCar){
        StringBuilder sb = new StringBuilder();
        int position = racingCar.getPosition();
        for (int i=0; i<position; i++){
            sb.append(POSITION_LOCATION);
        }
        return sb.toString();
    }

}
