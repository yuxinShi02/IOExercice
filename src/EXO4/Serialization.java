package EXO4;

import java.io.*;
import java.util.Arrays;
import java.util.List;


/**
 * Created by tearsyu on 20/04/17.
 */
public class Serialization {
    private FileOutputStream fout;
    private ObjectOutputStream oout;
    private FileInputStream fin;
    private ObjectInputStream oin;
    private static final String PATH = "carnet.ser";
    public Serialization(){
        try {
            fout = new FileOutputStream(PATH);
            oout = new AppendingObjectOutputStream(fout);
            fin = new FileInputStream(PATH);
            oin = new ObjectInputStream(fin);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serial(Object o){
        try {
            oout.writeObject(o);
            System.out.println(o.toString() + " serial finish.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //flag = 1 ==> a list
    //flag = 2 ==> an object
    public Object deserial(){
        Object o = null;
        try {
            o = oin.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }


    public static <T> boolean writeObject(List<T> list,File file)
    {
        T[] array = (T[]) list.toArray();
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)))
        {
            out.writeObject(array);
            out.flush();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 反序列化,List
     */
    public static <E> List<E> readObjectForList(File file)
    {
        E[] object;
        try(ObjectInputStream out = new ObjectInputStream(new FileInputStream(file)))
        {
            object = (E[]) out.readObject();
            return Arrays.asList(object);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void close() throws IOException {
        oout.close();
        fout.close();
        fin.close();
        oin.close();
    }
}
