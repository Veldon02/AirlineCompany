package Test;

import AirplaneManagement.Airplane.Airplane;
import AirplaneManagement.Airplane.AirplaneRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AirplaneRepositoryTest {

    private final AirplaneRepository airplaneRepository = new AirplaneRepository();

    @Test
    void  getAll() {
        var airplanes = airplaneRepository.getAll();
        assertEquals(6,airplanes.size());
    }

    @Test
    void getAirplaneNonexistentID() {
        var airplane = airplaneRepository.getAirplane(-19);
        assertNull(airplane);
    }
    @Test
    void getAirplaneNormalID() {
        var airplane = airplaneRepository.getAirplane(1);
        assertEquals("Ан-225", airplane.getName());
    }

    @Test
    void getIDs() {
        var ids = airplaneRepository.getIDs();
        assertEquals(6,ids.size());
    }

    @Test
    void getCargo() {
        var ids = airplaneRepository.getCargo();
        for(var id: ids){
            assertEquals("Cargo", airplaneRepository.getAirplane(id).getType());
        }
    }

    @Test
    void getPassenger() {
        var ids = airplaneRepository.getPassenger();
        for(var id: ids){
            assertEquals("Passenger", airplaneRepository.getAirplane(id).getType());
        }
    }

    @Test
    void getWorking() {
        var ids = airplaneRepository.getWorking();
        for(var id: ids){
            assertFalse(airplaneRepository.getAirplane(id).isUnderRepair());
        }
    }

    @Test
    void getUnderRepair() {
        var ids = airplaneRepository.getUnderRepair();
        for(var id: ids){
            assertTrue(airplaneRepository.getAirplane(id).isUnderRepair());
        }
    }

    @Test
    @Order(1)
    void addAirplaneWithNegativeCharacteristics() {
        Airplane airplane = new Airplane.AirplaneBuilder("Test","Cargo")
                .setUnderRepair(true)
                .setFuelConsumption(-5)
                .setCarryingCapacity(-5)
                .setPassengerSeatsNumber(-5)
                .setMaxFlightRange(-5)
                .build();
        GlobalVariables.addedID = airplaneRepository.addAirplane(airplane);
        assertEquals(-1,GlobalVariables.addedID);
    }

    @Test
    @Order(2)
    void addAirplaneNormal() {
        Airplane airplane = new Airplane.AirplaneBuilder("Test","Cargo")
                .setUnderRepair(true)
                .setFuelConsumption(5)
                .setCarryingCapacity(5)
                .setPassengerSeatsNumber(5)
                .setMaxFlightRange(5)
                .build();
        GlobalVariables.addedID = airplaneRepository.addAirplane(airplane);
        assertNotEquals(-1,GlobalVariables.addedID);
    }

    @Test
    @Order(3)
    void changeInt() {
        airplaneRepository.changeInt(GlobalVariables.addedID,"MaxFlightRange",30000);
        assertEquals(30000,airplaneRepository.getAirplane(GlobalVariables.addedID).getMaxFlightRange());
    }

    @Test
    @Order(4)
    void changeString() {
        airplaneRepository.changeString(GlobalVariables.addedID,"Name","TestingChangeMethod",true);
        assertEquals("TestingChangeMethod",airplaneRepository.getAirplane(GlobalVariables.addedID).getName());
    }

    @Test
    @Order(5)
    void changeStringWithoutBrackets() {
        airplaneRepository.changeString(GlobalVariables.addedID,"UnderRepair","False",false);
        assertFalse(airplaneRepository.getAirplane(GlobalVariables.addedID).isUnderRepair());
    }

    @Test
    @Order(6)
    void sortByFlightRange() {
        var ids = airplaneRepository.sortByFlightRange();
        int last = ids.size()-1;
        assertEquals(GlobalVariables.addedID,ids.get(0));
        assertEquals(4,ids.get(last));
    }

    @Test
    @Order(7)
    void deleteAirplane() {
        airplaneRepository.deleteAirplane(GlobalVariables.addedID);
        assertNull(airplaneRepository.getAirplane(GlobalVariables.addedID));
    }

    @Test
    void findByFuelConsumptionRange() {
        var ids = airplaneRepository.findByFuelConsumptionRange(15900,15900);
        assertEquals(1, ids.get(0));
    }

    @Test
    void getCapacitySum() {
        var sum = airplaneRepository.getCapacitySum();
        assertEquals(557, sum);
    }

    @Test
    void getCarryingCapacitySum() {
        var sum = airplaneRepository.getCarryingCapacitySum();
        assertEquals(567700, sum);
    }


}

