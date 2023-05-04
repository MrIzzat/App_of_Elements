package com.mrizzat.appofelements.models;

public class Chemical {

    private String Symbol;
    private String Name;
    private double atomicWeight;
    private int atomicNumber;


    public Chemical(String Symbol,String Name,double atomicWeight,int atomicNumber){
        this.Symbol=Symbol;
        this.Name=Name;
        this.atomicWeight=atomicWeight;
        this.atomicNumber=atomicNumber;

    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    public void setAtomicWeight(double atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public String toString(){
        return Symbol+" "+Name+" "+atomicNumber+" "+atomicWeight;
    }
}
