package EXO4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tearsyu on 21/04/17.
 */
public class Test {
    public static void main(String[] args){
        //Serialization s = new Serialization();
        List<Contacts> carnet = new ArrayList<>();
        for(int i = 0; i < 5; ++i){
            Contacts c = new Contacts("BB");
            c.setFname("Bliz" + i);
            c.setAddr("Rue du genie " + i);
            carnet.add(c);
        }
        File fd = new File("src/carnet.ser");
        Serialization.writeObject(carnet, fd);
        List<Contacts> re = Serialization.readObjectForList(fd);
        for (Contacts each : re){
            System.out.println(each.toString());
            //each.toString();
        }


//        s.serialList(carnet);
//
//        List<Contacts> carnet01 = s.deserialList();
//        for(Contacts each : carnet01){
//            each.toString();
//        }
//
//        Contacts add = new Contacts("Yoric");
//        add.setLname("Weaking");
//        add.setAddr("Valorien");
//        carnet01.add(add);
//        s.serialList(carnet01);
//
//        try {
//            s.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
