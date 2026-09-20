import java.time.LocalDateTime;
import java.util.UUID;

class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;

    Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID().toString().substring(0, 8);
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    String getTicketId() {
        return ticketId;
    }

    Vehicle getVehicle() {
        return vehicle;
    }

    ParkingSpot getSpot() {
        return spot;
    }

    LocalDateTime getEntryTime() {
        return entryTime;
    }
}
