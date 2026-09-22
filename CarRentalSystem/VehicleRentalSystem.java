enum VehicleType {CAR,BIKE}
enum VehicleStatus {AVAILABLE, BOOKED, UNDER_MAINENANCE}
enum ReservationStatus {PENDING, CONFIRMED, ACTIVE, COMPLETED, CANCELLED}

//VEHICLE

class Vehicle{
    private String id,
    private VehicleType type,
    private String model;
    private String reg,
    private double rate,
    private VehicleStatus status,

    Vehicle(String id, VehicleType type, String model, String reg, double rate, VehicleStatus status){
        this.id = id;
        this.type = type;
        this.model = model;
        this.reg = reg;
        this.rate = rate;
        this.status = VehicleStatus.AVAILABLE;
    }
    String getId(){return id;}
    VehicleType getType() { return type; }
    String getModel() { return model; }
    double getDailyRate() { return dailyRate; }
    VehicleStatus getStatus() { return status; }
    void setStatus(VehicleStatus status) { this.status = status; }
 
    public String toString() { return model + " (" + registrationNumber + ")"; }
}

//USER
class User{
    private String id;
    private String name;
    private String licenseNum;
     
    User(String id, String name, String licenseNum){
        this.id = id;
        this.name = name;
        this.licenseNum = licenseNum;
    }
    String getId(){return id;}
    String getName(){return name;}
}

//VIM
class Vim{
    private List<Vehicle> vehicles = new ArrayList<>();

    void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    List<Vehicle> getVehicleByType(VehicleType type){
        List<Vehicle> res = new ArrayList<>();
        for(Vehicle v : vehicles){
            if(v.getType() == type && v.getStatus() == VehicleStatus.AVAILABLE){
                res.add(v);
            }
        }
        return res;
    }
}

//LOCATION
class Location{
    private String address;
    private VIM inventory;

    Location (String address){
        this.address = address;
        this.inventory = new VIM();
    }
    String getAddress(){
        return address;
    }
    VIM getInventory() {
        return inventory;
    }
}

//RESERVATION
class Reservation{
    private String id;
    private User user;
    private Vehicle vehicle;
    private Location pickUpLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus status;

      Reservation(User user, Vehicle vehicle, Location pickupLocation, LocalDate startDate, LocalDate endDate) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.user = user;
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = ReservationStatus.CONFIRMED;
    }
 
    String getId() { return id; }
    User getUser() { return user; }
    Vehicle getVehicle() { return vehicle; }
    LocalDate getStartDate() { return startDate; }
    LocalDate getEndDate() { return endDate; }
    ReservationStatus getStatus() { return status; }
    void setStatus(ReservationStatus status) { this.status = status; }
}

