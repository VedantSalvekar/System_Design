class Seat{
    private String row;
    private int seatNumber;
    private SeatType type;

    Seat(String row, int seatNumber, SeatType type){
        this.row = row;
        this.seatNumber =seatNumber;
        this.type = type;
    }
    private String getRow(){
        return row;
    }
    private int getSeatNumber(){
        return seatNumber;
    }
    private SeatType getType(){
        return type;
    }
}