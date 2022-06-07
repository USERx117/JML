package MusicLandscape.entities;

public class TVShow extends Event {

    private String name;

    private int viewers;

    public TVShow(){
        this.name="unknown";
        this.viewers=0;
    }

    public TVShow(Event e){
        super.setArtist(e.getArtist());
        super.setAttendees(e.getAttendees());
        super.setDate(e.getDate());
        super.setDescription(e.getDescription());
        super.setVenue(e.getVenue());
    }

    public TVShow(TVShow tvs){
        this.name=tvs.name;
        this.viewers=tvs.viewers;
        super.setArtist(tvs.getArtist());
        super.setAttendees(tvs.getAttendees());
        super.setDate(tvs.getDate());
        super.setDescription(tvs.getDescription());
        super.setVenue(tvs.getVenue());
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    public int impact(){
        return this.viewers*2;
    }

    public String toString() {
        return (super.getArtist().getName().isEmpty() ? super.getArtist().getName() : "unknown") +
                " @ " + (this.name.isEmpty() ? this.name : "unknown") +
                " on " + (super.getDate().dateString().isEmpty() ? super.getDate().dateString() : "unknown") +
                "\n" + (super.getDescription().isEmpty() ? super.getDescription() : "unknown") +
                "\n" +
                "(" + this.viewers + " attending " +
                "(" + this.impact() + "))";
    }
}
