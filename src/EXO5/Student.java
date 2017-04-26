package EXO5;

/**
 * Created by tearsyu on 23/04/17.
 */
public class Student {
    private String name, num;
    private Subject[] formation;

    public Student(String name, String num){
        this.name = name;
        this.num = num;
    }



// Setter and getter
    public Subject[] getFormation() {
        return formation;
    }

    public void setFormation(Subject[] formation) {
        this.formation = formation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
