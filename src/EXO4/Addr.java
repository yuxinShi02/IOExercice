package EXO4;

import java.io.Serializable;

/**
 * Created by tearsyu on 20/04/17.
 */
public class Addr implements Serializable{
    private String roadname;
    private String city;
    private int roadnum;
    private String postal;
    public Addr(String rn, String city, int rnum, String postal){
        this.city = city;
        this.roadname = rn;
        this.postal = postal;
        this.roadnum = rnum;
    }

    public Addr(){}

    @Override
    public String toString(){
        return "" + postal + " " + city + "/" + roadnum + " " + roadname;
    }
    public String getRoadname() {
        return roadname;
    }

    public void setRoadname(String roadname) {
        this.roadname = roadname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRoadnum() {
        return roadnum;
    }

    public void setRoadnum(int roadnum) {
        this.roadnum = roadnum;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
}
