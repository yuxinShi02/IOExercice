package EXO5;

/**
 * Created by tearsyu on 23/04/17.
 */
public class Subject {
    private String subName;
    private float note;
    private int coeff;

    public Subject(String subName, float note, int coeff) {
        this.subName = subName;
        this.note = note;
        this.coeff = coeff;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
