package car.view;

public class TestInputConsole implements Input{
    private String testCarName;
    private String testTrialCount;
    public void setCarNames(String testCarNames){
        this.testCarName = testCarNames;
    }
    public void setTestTrialCount(String testTrialCount){
        this.testTrialCount = testTrialCount;
    }
    @Override
    public String inputCarNames() {
        return this.testCarName;
        //return "땡칠,호이,달리,루쿠,저문,아마란스";
    }

    @Override
    public String inputTrialCount() {
        return this.testTrialCount;
        //return "10";
    }
}
