class Show {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Movie movie;

    public Show(
            LocalDateTime startTime,
            LocalDateTime endTime,
            Movie movie
    ) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Movie getMovie() {
        return movie;
    }
}