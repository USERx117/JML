package MusicLandscape.entities;

import java.util.Objects;

public class Event {

    private Artist artist;

    private int attendees;

    private Date date;

    private String description;

    private Venue venue;

    public Event() {

    }

    public Event(Event e) {
        if (e.getArtist() == null) {
            this.artist = new Artist();
        } else {
            this.artist = new Artist(e.getArtist());
        }

        this.attendees = e.getAttendees();

        if (e.getDate() == null) {
            this.date = new Date();
        } else {
            this.date = new Date(e.getDate());
        }

        this.description = e.getDescription();

        if (e.getVenue() == null) {
            this.venue = new Venue();
        } else {
            this.venue = new Venue(e.getVenue());
        }
    }


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        if (artist == null) {
            return;
        }
        this.artist = artist;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        if (attendees >= 0) {
            this.attendees = attendees;
        }
    }

    public Date getDate() {
//        if (this.date != null) {
//            return new Date();
//        }
        return this.date;
    }

    public void setDate(Date date) {
//        if (date != null) {
//            date = new Date();
//        }
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNullElse(description, "");
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String toString() {
        String retString="";
        if(this.artist==null) {
            retString += "unknown";
        }else{
            if(!this.artist.getName().isEmpty()){
                retString+=this.artist.getName();
            }else{
                retString+="unknown";
            }
        }
        retString += " @ ";
        if(this.venue==null) {
            retString += "unknown";
        }else{
            if(!this.venue.getName().isEmpty()){
                retString+=this.venue.getName();
            }else{
                retString+="unknown";
            }
        }
        retString+=" on ";
        if(this.date==null){
            retString+="null";
        }else{
            if(!this.date.toString().isEmpty()){
                retString+=this.date.toString();
            }else{
                retString+="null";
            }
        }
        retString+= "\n";
        if(this.description==null){
            retString+="";
        }else{
            if(!this.description.isEmpty()){
                retString+=this.description;
            }else{
                retString+="";
            }
        }
        retString+="\n";
        retString+="("+ this.attendees + " attending ";
        retString+="("+ this.impact() + "))";

        return retString;
       /* return (this.artist.getName().isEmpty() ? this.artist.getName() : "unknown") +
                " @ " + (this.venue.getName().isEmpty() ? this.venue.getName() : "unknown") +
                " on " + (this.date.dateString().isEmpty() ? this.date.dateString() : "unknown") +
                "\n" + (this.description.isEmpty() ? this.description : "unknown") +
                "\n" +
                "(" + this.attendees + " attending " +
                "(" + this.impact() + "))";*/

    }

    public int impact() {
        return this.attendees * 2;
    }
}
