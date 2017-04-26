package EXO2;

import java.io.*;

/**
 * Created by tearsyu on 20/04/17.
 * Mode asynchronized
 * @Test unchecked
 */
public class ChatB {
    private BufferedReader in, readin;
    private BufferedWriter out;
    //private boolean isMyTurn;
    public ChatB(String[] args){
        File fd1 = new File("EXO2/canal1.txt");
        File fd2 = new File("EXO2/canal2.txt");
        try {
            if (args[0].equals("1")) {
                readin = new BufferedReader(new FileReader(fd1));
                out = new BufferedWriter(new FileWriter(fd2));
                in = new BufferedReader(new InputStreamReader(System.in));
            } else {
                readin = new BufferedReader(new FileReader(fd2));
                out = new BufferedWriter(new FileWriter(fd1));
                in = new BufferedReader(new InputStreamReader(System.in));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startChat(){
        while(true){
                System.out.print("$ ");
                String str = null;
                try {
                    str = in.readLine();
                    out.write(str, 0, str.length());
                    out.newLine();
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if(readin.ready()){
                        str = readin.readLine();
                        System.out.println(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

    public static void main(String[] args){
        ChatB a = new ChatB(args);
        a.startChat();

    }
}
