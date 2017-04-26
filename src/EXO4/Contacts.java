package EXO4;

import java.io.Serializable;

/**
 * Created by tearsyu on 20/04/17.
 */
public class Contacts implements Serializable{
    private String fname;
    private String lname;
    private String addr;
    private String email;
    private String tel;

    public Contacts(String fname){
        this.fname = fname;
    }


    public Contacts(String fname, String lname, String addr, String email, String tel) {
        this.fname = fname;
        this.lname = lname;
        this.addr = addr;
        this.email = email;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", addr=" + addr +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
