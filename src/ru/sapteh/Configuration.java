package ru.sapteh;

import java.util.Objects;

public class Configuration {
    private int id;
    private String modelCpu;
    private String ram;
    private String hdd;
    private String powerSupply;

    public Configuration(int id, String modelCpu, String ram, String hdd, String powerSupply){
        this.id = id;
        this.modelCpu = modelCpu;
        this.ram = ram;
        this.hdd = hdd;
        this.powerSupply = powerSupply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelCpu() {
        return modelCpu;
    }

    public void setModelCpu(String modelCpu) {
        this.modelCpu = modelCpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    @Override
    public String toString(){
        return String.format("%d %s %s %s %s",getId(),getModelCpu(),getRam(),getHdd(),getPowerSupply());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return id == that.id &&
                Objects.equals(modelCpu, that.modelCpu) &&
                Objects.equals(ram, that.ram) &&
                Objects.equals(hdd, that.hdd) &&
                Objects.equals(powerSupply, that.powerSupply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelCpu, ram, hdd,powerSupply);
    }
}
