package MusicLandscape.entities;

public class Artist
{
    private String name;

    public Artist() {
        this.name = "unknown";
    }

    public Artist(Artist a) {
        this.name = a.name;
    }

    public Artist(String name) {
        this.name = name;
    }

    public void setName(String name) {
        if (name == null) {
            System.out.println("Error: Name is null.");
        } else if (name.isBlank()) {
            System.out.println("Error: Name blank.");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public String toString(){
        if(this.name==null || this.name.isEmpty()){
            return "unknown";
        }else{
            return this.name;
        }
    }
}
