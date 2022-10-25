package AirplaneManagement.Airplane;

import AirplaneManagement.AirlineСompany.AirlineCompany;

public class Airplane {
    private String name;
    private boolean underRepair;
    private int weight;
    private int carryingCapacity;
    private int passengerSeatsNumber;
    private int maxFlightRange;
    private int fuelTankVolume;
    private String flight;
    private String type;

    public Airplane(){
        name = "airplane";
        underRepair = false;
    }

    public String getName() {
        return name;
    }

    public boolean isUnderRepair() {
        return underRepair;
    }

    @Override
    public String toString(){
        return name;
    }
}
