package MusicLandscape.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Concert extends Event {

    private int nextIdx;

    private Track[] setList;

    public Concert() {

    }

    public boolean addTrack(Track t){

        if(t != null){

            ensureCapacity(1);
            setList[nextIdx++] = t;
            return true;
        }
        return false;

    }

    public void resetSetList() {
        this.setList = new Track[0];
    }

    public int nrTracks(){
        return (nextIdx != 0)?nextIdx:0;

    }

    public int duration() {
        int totaldur = 0;
        if(this.setList == null || this.setList.length == 0) {
            return totaldur;
        }
        for (int i = 0; i < this.setList.length; i++) {
            totaldur += this.setList[i].getDuration();
        }
        return totaldur;
    }

    public int impact() {
        double halfh = (this.duration() / 60.0) / 30.0;
        if (halfh == 0) {
            halfh = 1.0;
        }
        halfh=Math.round(halfh);
        return super.getAttendees() * (int)halfh;
    }

    public Track[] getSetList() {
        setList = new Track[this.setList.length];
        System.arraycopy(this.setList,0,setList,0,this.setList.length);
        return setList;
    }

    public void setSetList(Track[] setList) {
        this.setList = setList;
    }

    public String calcTime(int t) {
        int hour = (t / 3600) % 60;
        int minutes = t / (60 * 1000);
        return String.format("%02d:%02d", hour, minutes);
    }

    public void ensureCapacity(int length){

        if(setList != null){

            if(length > setList.length-nextIdx-1){

                Track[] tempTrackList = new Track[nextIdx+length];
                int i = 0;

                for(Track tempTrack : setList){

                    tempTrackList[i] = tempTrack;

                    i++;
                }

                nextIdx = i;
                setList = tempTrackList;
            }

        }else{
            setList = new Track[length];

        }


    }

    public String toString() {
        String event = super.toString();
        String len = "unknown";
        if(this.setList !=null) {
            len = Integer.toString(this.setList.length);
        }
        return event + "\n" + len + " Tracks played " + this.calcTime(this.duration());
    }
}