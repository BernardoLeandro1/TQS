package io.cucumber.skeleton;

public class Calculator {

    private int res;

    public Calculator() { res = 0; }

    public Calculator add(int a, int b) {
        res = a + b;
        return this;
    }

    public Calculator subtract(int a, int b) {
        res = a - b;
        return this;
    }

    public int result() {
        return res;
    }

}