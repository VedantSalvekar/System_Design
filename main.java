import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ParkingLot.resetForTesting();
        ParkingLot lot = ParkingLot.getInstance();

        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add(new ParkingSpot("F1-S1", SpotSize.SMALL));
        floor1Spots.add(new ParkingSpot("F1-M1", SpotSize.MEDIUM));
        floor1Spots.add(new ParkingSpot("F1-M2", SpotSize.MEDIUM));
        lot.addFloor(new ParkingFloor(1, floor1Spots));

        List<ParkingSpot> floor2Spots = new ArrayList<>();
        floor2Spots.add(new ParkingSpot("F2-L1", SpotSize.LARGE));
        floor2Spots.add(new ParkingSpot("F2-L2", SpotSize.LARGE));
        lot.addFloor(new ParkingFloor(2, floor2Spots));

        EntryGate entry = new EntryGate();
        ExitGate exit = new ExitGate();

        Ticket bikeTicket = entry.generateTicket(new Bike("BK-001"));
        Ticket carTicket1 = entry.generateTicket(new Car("CR-001"));
        Ticket carTicket2 = entry.generateTicket(new Car("CR-002")); // should take the other MEDIUM spot
        Ticket truckTicket = entry.generateTicket(new Truck("TR-001"));

        try {
            entry.generateTicket(new Car("CR-003"));
        } catch (RuntimeException e) {
            System.out.println("EntryGate Rejected CR-003 -> " + e.getMessage());
        }

        exit.processExit(carTicket1);

        entry.generateTicket(new Car("CR-003"));
    }
}
