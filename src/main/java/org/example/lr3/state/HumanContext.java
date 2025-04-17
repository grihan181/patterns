package org.example.lr3.state;

public class HumanContext {

    private HumanState state;

    public void setState(HumanState state) {
        this.state = state;
    }

    public HumanState getState() {
        return state;
    }
}