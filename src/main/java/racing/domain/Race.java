package racing.domain;

public class Race {
    private final Cars cars;
    private final TryCount tryCount;

    public Race(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void proceedRace(){
        while(tryCount.isRemain()){
            tryCount.consume();
            cars.proceedRound();
        }
    }
}
