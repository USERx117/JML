package MusicLandscape.entities;

public class TVShow extends Event {

    private String name;

    private int viewers;

    public TVShow() {
        this.name = null;
        this.viewers = 0;
    }

    public TVShow(Event e) {
        super(e);
    }

    public TVShow(TVShow tvs) {
        this.name = tvs.name;
        this.viewers = tvs.viewers;
        if(tvs.getArtist()!=null){
            super.setArtist(new Artist(tvs.getArtist()));
        }else{
            super.setArtist(new Artist());
        }
        if(tvs.getVenue()!=null){
            super.setVenue(new Venue(tvs.getVenue()));
        }else{
            super.setVenue(new Venue());
        }
        if(tvs.getDate()!=null){
            super.setDate(new Date(tvs.getDate()));
        }else{
            super.setDate(new Date());
        }

        super.setAttendees(tvs.getAttendees());
        super.setDescription(tvs.getDescription());

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        if(viewers>=0){
            this.viewers = viewers;
        }
    }

    public int impact() {
        return (this.viewers+super.getAttendees()) * 2;
    }

    public String toString() {
        String retString="";
        if(super.getArtist()==null){
            retString+="unknown";
        }else{
            if(!super.getArtist().getName().isEmpty()){
                retString+=super.getArtist().getName();
            }else{
                retString+="unknown";
            }
        }
        retString+=" @ ";
        if(this.name==null){
            retString+="unknown";
        }else{
            if(!this.name.isEmpty()){
                retString+=this.name;
            }else{
                retString+="unknown";
            }
        }
        retString+=" on ";
        if (super.getDate() == null) {
            retString+="unknown";
        }else{
            if(!super.getDate().toString().isEmpty()){
                retString+=super.getDate().toString();
            }else{
                retString+="unknown";
            }
        }
        retString+="\n";
        if(super.getDescription()==null){
            retString+="unknown";
        }else{
            if(!super.getDescription().isEmpty()){
                retString+=super.getDescription();
            }else{
                retString+="unknown";
            }
        }
        retString+="\n";
        retString+="("+ (this.viewers+super.getAttendees())+ " attending ";
        retString+="("+ this.impact() + "))";
        return retString;

//        return (super.getArtist().getName().isEmpty() ? super.getArtist().getName() : "unknown") +
//                " @ " + (this.name.isEmpty() ? this.name : "unknown") +
//                " on " + (super.getDate().dateString().isEmpty() ? super.getDate().dateString() : "unknown") +
//                "\n" + (super.getDescription().isEmpty() ? super.getDescription() : "unknown") +
//                "\n" +
//                "(" + this.viewers + " attending " +
//                "(" + this.impact() + "))";
    }
}
