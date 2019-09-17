package com.example;

import java.util.*;

public class Car {
    private final String color;
    private final int gasLevel;

    private Engine carEngine;

    private final List<String> passengers;
    private final List<String> trunkContents;
    private List<Tyre> tyreList;

    private Car(String color, int gasLevel, Engine ccPower, List<String> passengers, List<String> trunkContents) {
        this.color = color;
        this.gasLevel = gasLevel;
        this.carEngine = (Engine)ccPower.clone();
        this.passengers = passengers;
        this.trunkContents = trunkContents;
        setTyreList(new ArrayList<Tyre>(Arrays.asList(
                new Tyre(10,100),
                new Tyre(10,100),
                new Tyre(10,100),
                new Tyre(10,100)
        )));
    }

    public static Car withColorGasEnginePassengers(String color, int gasLevel, Engine ccPower, String ... passengers){
        List<String> tempPassengers = new ArrayList<String>();
        for(String passName : passengers)
        {
            tempPassengers.add(passName);
        }
        //List<String> tempTrunk = Collections.unmodifiableList(Arrays.asList(passengers));
        return new Car(color,gasLevel,ccPower, tempPassengers,null);
    }

    public static Car withColorGasEnginePassengersTrunk(String color, int gasLevel, Engine ccPower, List<String> passengers) {
        List<String> tempPassengers = new ArrayList<String>();
        tempPassengers.addAll(passengers);
        List<String> tempTrunk = Collections.unmodifiableList(Arrays.asList("jack","wrench","spare wheel"));
        return new Car(color, gasLevel, ccPower, tempPassengers, tempTrunk);
    }

    public String getColor() {
        return color;
    }
    public int getGasLevel() {
        return gasLevel;
    }
    public Engine getCarEngine() {
        return (Engine) carEngine.clone();
    }

    public List<String> getPassengers() {
        //return passengers;  // Do not return same list. it will be updated from outside.
        //return new ArrayList<String>(passengers); //runtime fails if passanger list is null
        List<String> temp = new ArrayList<String>();
        if(null != passengers && !passengers.isEmpty()) {
            temp.addAll(passengers);
        }
        return temp;
    }

    public List<String> getTrunkContents() {
        //return trunkContents;  // Do not return same list. it will be updated from outside.
        //return new ArrayList<String>(trunkContents);  //runtime fails if trunkContents is null
        List<String> temp = new ArrayList<String>();
        if(null != trunkContents && !trunkContents.isEmpty()){
            temp.addAll(trunkContents);
        }
        return  temp;
    }


    public void setCarEngine(Engine e1) {
        this.carEngine=(Engine) e1.clone();
        //this.carEngine = ccPower;
    }

    @Override
    public Object clone() {
        return new Car(
                this.color,
                this.gasLevel,
                (Engine)this.carEngine.clone(),
                this.getPassengers(),
                this.getTrunkContents()
        );
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", gasLevel=" + gasLevel +
                ", ccPower=" + carEngine +
                ", passengers=" + passengers +
                ", trunkContents=" + trunkContents +
                ", tyreList=" + tyreList +
                '}';
    }

    public List<Tyre> getTyreList() {
        List<Tyre> temp = new ArrayList<Tyre>();
        if(null != tyreList && !tyreList.isEmpty()){
            for(Tyre t : tyreList){
                temp.add((Tyre)t.clone());
            }
        }
        return  temp;
    }
    public void setTyreList(List<Tyre> tyreList) {
        List<Tyre> temp = new ArrayList<Tyre>();
        if(null != tyreList && !tyreList.isEmpty()){
            for(Tyre t : tyreList){
                temp.add((Tyre)t.clone());
            }
        }
        this.tyreList = temp;
    }
}
