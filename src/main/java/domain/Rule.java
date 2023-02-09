package domain;

import vo.Trial;

public class Rule {
    private final Trial trial;

    public Rule(Trial trial) {
        this.trial = trial;
    }

    public Trial getTrial() {
        return trial;
    }
}
