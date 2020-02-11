package ru;

public class KnotItem implements Component {
    private double consumed;
    private double distributed;
    private String name;

    KnotItem(double consumed,  String name) {
        this.consumed = consumed;
        this.name = name;
    }
    public double getConsumed() {        return consumed;    }
    public double getDistributed() {        return distributed;    }
    public void setDistributed(double distributed) {        this.distributed = distributed;    }

    @Override
    public void add(Component Component) {
    }

    @Override
    public Component getChild(int i) {
        return null;
    }
    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }
    public void difference() {}
    public void print() {
       // System.out.println("Узел " + getName() + " распределенная нагрузка " + getDistributed());
    }
}
