package info.keyal.demo.tutorial.designpattern.creational.factorymethod;

public abstract class Plan {
    protected double rate;

    abstract void getRate();

    public double calculateBill(int units) {
        return units * rate;
    }
}
