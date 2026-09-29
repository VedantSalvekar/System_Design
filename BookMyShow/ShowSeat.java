class ShowSeat {

    private SeatStatus status;
    private double price;

    private Seat seat;

    public ShowSeat(
            Seat seat,
            double price
    ) {
        this.seat = seat;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}