package com.example;

public class Engine {
    private EngineCylinder engineCylinder;
    private int enginePowerInCC;

    public Engine() {
        this.enginePowerInCC = 800;
        this.setEngineCylinder(EngineCylinder.THREE_CYL_ENGINE);
    }
    public Engine(int cc, EngineCylinder ec) {
        if(cc < 800)
            throw new IllegalArgumentException("Engine capacity less than 800 is not possible");

        this.enginePowerInCC = cc;
        this.setEngineCylinder(ec);
    }

    public EngineCylinder getEngineCylinder() {
        return engineCylinder;
    }
    public void setEngineCylinder(EngineCylinder engineCylinder) {
        this.engineCylinder = engineCylinder;
    }

    public int getPowerCC() {
        return enginePowerInCC;
    }
    public void setPowerCC(int powerCC) {
        this.enginePowerInCC = powerCC;
    }

    @Override
    protected Object clone() {
        return new Engine(this.enginePowerInCC, this.engineCylinder);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineCylinder=" + engineCylinder +
                ", enginePowerInCC=" + enginePowerInCC +
                '}';
    }
}
