package racing.domain;

import racing.view.InputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private int numTrials;

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
        numTrials = InputView.requestNumTrials();
    }


}
