package racing.domain;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private int numTrials;

    /**
     * 경기 준비 메소드
     */
    public void createCars() {
        cars = new ArrayList<>();
        Iterator<String> it = inputCarNames().iterator();
        while (it.hasNext()) {
            cars.add(new Car(it.next()));
        }
    }

    public List<String> inputCarNames(){
        try{
            List<String> carNames = InputView.requestNames();
            checkDuplicated(carNames);
            return carNames;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    public boolean checkDuplicated(List<String> names){
        List<String> namesSet = names.stream().distinct().collect(Collectors.toList());
        if(names.size()!=namesSet.size()) throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
        return true;
    }

    public void inputNumTrials(){
        try {
            numTrials = InputView.requestNumTrials();
            checkValidNumTrials(numTrials);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputNumTrials();
        }
    }

    public boolean checkValidNumTrials(int numTrials) {
        if (0 >= numTrials) {
            throw new IllegalArgumentException("시도 횟수는 자연수만 입력 가능합니다.");
        }
        return true;
    }


    /**
     * 경기 진행 반복 메소드
     */
    public void repeatRace() {
        System.out.println("실행 결과");
        for (int i=0; i<numTrials; i++) {
            race();
            OutputView.printRace(cars);
        }
    }
    private void race() {
        Iterator<Car> it = cars.iterator();
        while(it.hasNext()) {
            Car car = it.next();
            car.tryGoForward();
        }
    }

    public RaceResult getResult(){
        RaceResult raceResult = new RaceResult(cars);
        raceResult.judgeWinners();
        return raceResult;
    }
}
