package MusicLandscape.entities;

import org.testng.util.Strings;
public class Track {
    private String title;
    private int duration;
    private Artist writer = new Artist();
    private Artist performer = new Artist();
    private int year;

    public Track(String title) {
        this.setTitle(title);
    }

    public Track() {
        this.setDuration(0);
        this.setYear(1900);
    }

    public Track(Track t) {
        this.title = t.title;
        this.duration = t.duration;
        this.setWriter(new Artist(t.getWriter()));
        this.setPerformer(new Artist(t.getPerformer()));
        this.year = t.year;
    }

    public String getTitle() {
        if (this.title == null){
            return "unknown title";
        }
        else {
            return title;
        }
    }

    public void setTitle(String title) {
        if (title == null) {
            this.title = null;
        }
        else if (title.trim().isEmpty()) {
            this.title = null;
        }
        else {
            this.title = title;
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        }
    }

    public Artist getWriter() {

        return writer;
    }

    public void setWriter(Artist writer) {
        if (writer != null) {
            this.writer = writer;
        }
    }

    public Artist getPerformer() {
        return performer;
    }

    public void setPerformer(Artist performer) {
        if (performer != null) {
            this.performer = performer;
        }
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        if (year >= 1900 && year <= 2999) {
            this.year = year;
        }
    }

    public boolean writerIsKnown() {
        if (this.writer != null) {

            return this.writer.getName() != null;
        }
        else {
            return false;
        }
    }

    public String getString() {
        return formatString(this.title) + " by " + (this.writer == null ? "   unknown" : formatString(this.writer.getName())) +
                " performed by " + (this.performer == null ? "   unknown" : formatString(this.performer.getName())) +
                " (" + formatDigit(this.duration / 60) + ":" + formatDigit(this.duration % 60) + ")";
    }

    public String formatString(String string) {
        String temp = "";
        if (string == null)
            return "   unknown";
        else if (string.length() < 10) {
            for (int i = string.length(); i < 10; i++) {
                temp = temp + " ";
            }
            return temp + string;
        } else if (string.length() > 10) {
            temp = string.substring(0, 10);
            return temp;
        } else {
            return string;
        }
    }

    public String formatDigit(int digit) {
        if (digit < 0 || digit > 99) {
            return "";
        }
        else if (digit < 10) {
            return "0" + digit;
        }
        else {
            return "" + digit;
        }
    }
}
