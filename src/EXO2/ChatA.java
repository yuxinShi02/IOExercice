package EXO2;

import java.io.*;

/**
 * Created by tearsyu on 20/04/17.
 * Create a little app in using two file(in, out) to chat between two terminals.
 * Mode synchronized
 */
public class ChatA {
    private BufferedReader in, readin;
    private BufferedWriter out;
    private boolean isMyTurn;
    public ChatA(String[] args){
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
            if(isMyTurn) {
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
                isMyTurn = false;
            } else {
                try {
                    if(readin.ready()){
                        String str = readin.readLine();
                        System.out.println(str);
                        isMyTurn = true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        ChatA a = new ChatA(args);
        a.startChat();
    }

}
