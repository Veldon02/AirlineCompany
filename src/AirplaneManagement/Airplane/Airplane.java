package AirplaneManagement.Airplane;

import AirplaneManagement.AirlineСompany.AirlineCompany;

public class Airplane  {
    private int ID;
    private String name;
    private String type;
    private boolean underRepair;
    private int carryingCapacity;
    private int passengerSeatsNumber;
    private int maxFlightRange;
    private int fuelConsumption;

    private Airplane(AirplaneBuilder builder){
        this.ID = builder.ID;
        this.name = builder.name;
        this.type = builder.type;
        this.underRepair = builder.underRepair;
        this.carryingCapacity = builder.carryingCapacity;
        this.passengerSeatsNumber = builder.passengerSeatsNumber;
        this.maxFlightRange = builder.maxFlightRange;
        this.fuelConsumption = builder.fuelConsumption;
    }

    public int getID(){
        return ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public boolean isUnderRepair() {
        return underRepair;
    }
    public void setUnderRepair(boolean underRepair){
        this.underRepair = underRepair;
    }

    public String getType() { return type; }
    public void setType(String type){
        this.type = type;
    }

    public int getCarryingCapacity(){ return carryingCapacity; }
    public void setCarryingCapacity(int carryingCapacity){
        this.carryingCapacity = carryingCapacity;
    }

    public int getPassengerSeatsNumber(){return passengerSeatsNumber;}
    public void setPassengerSeatsNumber(int passengerSeatsNumber){
        this.passengerSeatsNumber = passengerSeatsNumber;
    }
    public int getMaxFlightRange() { return maxFlightRange; }
    public void setMaxFlightRange(int maxFlightRange){
        this.maxFlightRange = maxFlightRange;
    }

    public int getFuelConsumption() { return fuelConsumption; }
    public void setFuelConsumption(int fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }

//    @Override
//    public String toString(){
//        return String.format("|%4d|%20s|%12s|%15s|%19d|%20d|%24d|%18d|",
//                ID,name,type,underRepair,fuelConsumption,carryingCapacity,passengerSeatsNumber,maxFlightRange);
//    }
    @Override
    public String toString(){
        return String.format("""
                        ID: %d
                        Name: %s
                        Type: %s
                        Under Repair: %s
                        Fuel Consumption: %d
                        Carrying Capacity: %d
                        Passenger Seats Number: %d
                        Max Flight Range: %d""",
                ID,name,type,underRepair,fuelConsumption,carryingCapacity,passengerSeatsNumber,maxFlightRange);
    }

    public static class AirplaneBuilder{
        private int ID = 0;
        private String name;
        private String type;
        private boolean underRepair;
        private int carryingCapacity;
        private int passengerSeatsNumber;
        private int maxFlightRange;
        private int fuelConsumption;

        public AirplaneBuilder(String name, String type){
            this.name = name;
            this.type = type;
        }

        public Airplane build(){
            return new Airplane(this);
        }
        public AirplaneBuilder setUnderRepair(boolean underRepair){
            this.underRepair = underRepair;
            return this;
        }
        public AirplaneBuilder setID(int ID){
            this.ID = ID;
            return this;
        }
        public AirplaneBuilder setCarryingCapacity(int carryingCapacity){
            this.carryingCapacity = carryingCapacity;
            return this;
        }
        public AirplaneBuilder setPassengerSeatsNumber(int passengerSeatsNumber){
            this.passengerSeatsNumber = passengerSeatsNumber;
            return this;
        }
        public AirplaneBuilder setMaxFlightRange(int maxFlightRange){
            this.maxFlightRange = maxFlightRange;
            return this;
        }
        public AirplaneBuilder setFuelConsumption(int fuelConsumption){
            this.fuelConsumption = fuelConsumption;
            return this;
        }
    }
}

