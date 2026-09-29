class Movie{
    private String title;
    private String lang;
    private int durMins;

    public Movie(String title, String language, int durMins) {
        this.title = title;
        this.language = lang;
        this.durMins = durMins;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return lang;
    }

    public int getDurationMins() {
        return durMins;
    }
}