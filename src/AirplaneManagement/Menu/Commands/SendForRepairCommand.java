package AirplaneManagement.Menu.Commands;

public class SendForRepairCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("you sent airplane on repair");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "changes \"underRepair\" status of airplane for true";
    }
}
