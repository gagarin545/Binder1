package ru;

import java.util.ArrayList;
import java.util.Iterator;

public class Knot implements Component {
    private double consumed;
    private double distributed;
    private String name;
    private ArrayList knots = new ArrayList();

    Knot(double consumed, String name) {
        this.consumed = consumed;
        this.name = name;
    }
    public void add(Component Component) { knots.add(Component);    }
    public Component getChild(int i) {  return (Component)knots.get(i); }
    public double getConsumed() {        return consumed;    }
    public void setConsumed(double consumed) {        this.consumed = consumed;    }
    public double getDistributed() {        return distributed;    }
    public void setDistributed(double distributed) {        this.distributed = distributed;    }
    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }
    public void difference() {
        double delta =  consumed - knots.stream().mapToDouble(x->  ((Component) x).getConsumed()).reduce(Double::sum).getAsDouble();
        System.out.println("Родитель " + name + " имеет разницу " + delta );
        knots.stream()
                .filter(x-> ((Component) x).getConsumed() > 0)
                .peek(x-> ((Component) x).setDistributed((((Component) x).getConsumed()/
                        knots.stream().mapToDouble(a->  ((Component) a).getConsumed()).filter(a-> a > 0 ).reduce(Double::sum).getAsDouble())
                        * delta))
                .forEach(x-> System.out.println("Узел " +((Component) x).getName() + " распределенная нагрузка " + ((Component) x).getDistributed()));

    }
    public void print() {
        Iterator iterator = knots.iterator();
        while(iterator.hasNext()) {
            Component knot = (Component) iterator.next();
            knot.difference();
            knot.print();
        }
    }
}
