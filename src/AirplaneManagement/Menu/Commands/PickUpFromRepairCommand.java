package AirplaneManagement.Menu.Commands;

public class PickUpFromRepairCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("you picked up airplane from repair");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "changes \"underRepair\" status of airplane for false";
    }
}
