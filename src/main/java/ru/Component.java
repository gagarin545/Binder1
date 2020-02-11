package ru;

public interface Component {
    public void add (Component Component);
    public Component getChild(int i) ;

    public String getName () ;
    public double getConsumed ();

    public double getDistributed() ;
    public void setDistributed(double distributed) ;
    public void setName(String name) ;

    public void difference();
    public void print() ;
}
