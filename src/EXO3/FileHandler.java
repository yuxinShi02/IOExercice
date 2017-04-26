package EXO3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tearsyu on 22/04/17.
 */
public class FileHandler {
    List<String> list = new ArrayList<>();
    /**
     * java MonProgramme XXX.txt YYY.txt.
     * @param dst
     * @param src
     * @return boolean
     */
    public static boolean copyFile(String src, String dst){
        boolean bool = false;
        File origin = new File(src);
        File dest = new File(dst);
        if(!origin.exists()) {
            System.out.println("origin file doesn't exit!");
            return bool;
        }
        try {
            InputStream in = new FileInputStream(origin);
            OutputStream out = new FileOutputStream(dest);
            byte[] buffer = new byte[2048];
            int len = 0;
            while((len = in.read(buffer)) > 0){
                out.write(buffer, 0, len);
            }
            bool = true;
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bool;
    }

    public static boolean delFile(String filePath){
        boolean bool = false;
        File fd = new File(filePath);
        if(fd.exists()){
            return fd.delete();
        } else {
            System.out.println("File doesn't exit.");
        }
        return bool;
    }

    public static boolean replaceFile(String src, String dst){
       return  (copyFile(src, dst) && delFile(src));
    }

    public static void pwd(){
        File curr = new File(".");
        System.out.println(curr.getAbsolutePath());
    }

    public static boolean cdTo(String dst){
        File folder = new File(dst);
        if(folder.exists() && folder.isDirectory()){
            boolean re = (System.setProperty("user.dir", folder.getAbsolutePath()) != null);

            return re;
        }
        return false;
    }

    public static void lsAllFile(File lsFile){
        File[] fileList = lsFile.listFiles();
        for (File afile : fileList) {
            if (afile.isDirectory()) {
                System.out.println("\n" + afile.getName());
                lsAllFile(afile);
            } else
                System.out.print("   -" + afile.getName() + " ");
        }
        System.out.println();
    }

    public List<String> getFName(File lsFile){
        File[] fileList = lsFile.listFiles();
        for (File file : fileList) {
            if (file.isDirectory()) {
                //System.out.println("\n" + file.getName());
                list.add(file.getName());
                getFName(file);
            } else {
                //System.out.print("   -" + file.getName() + " ");
                list.add(file.getName());
            }
        }
        return list;
    }

    public static List<File> find(String str){
        File file = new File(".");
        File[] files = file.listFiles();
        List<File> fileFound = new ArrayList<>();
        String regex = "(.*)"+str+"(.*)";
        for (File afile: files) {
            if(afile.getName().matches(regex)){
                fileFound.add(afile);
            }
        }
        return fileFound;
    }

    public List<String> findrec(String str){
        File file = new File(".");
        List<String> fileFound = new ArrayList<>();
        String regex = "(.*)"+ str+"(.*)";
        getFName(file);
        for(String element : list){
            if(element.matches(regex)){
                fileFound.add(element);
            }
        }
        return fileFound;
    }

    public void cmdTrigger(){
        try {
            boolean sayGoodBye = false;
            while(!sayGoodBye) {
                System.out.print("$");
                BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
                String[] cmds = bin.readLine().split(" ");
                for (String cmd : cmds){
                    System.out.print(cmd + " ");
                }

                if (cmds[0].equals("cp")) {
                    if (copyFile(cmds[1], cmds[2]))
                        System.out.println("Copy file successfully!");
                    else
                        System.out.println("Copy file failed!");
                } else if (cmds[0].equals("rm")){
                    if(delFile(cmds[1]))
                        System.out.println("rm file successfully!");
                    else
                        System.out.println("rm file failed!");
                } else if(cmds[0].equals("mv")) {
                    if(replaceFile(cmds[1], cmds[2]))
                        System.out.println("mv file successfully!");
                    else
                        System.out.println("mv file failed!");
                } else if(cmds[0].equals("pwd")){
                    pwd();
                } else if(cmds[0].equals("cd")){
                    if(cdTo(cmds[1])){
                        System.out.print("now your current path is :");
                        pwd();
                    } else
                        System.out.println(cmds[1] + " doesn't exit.");
                } else if(cmds[0].equals("ls")){
                    File lsFile = new File(cmds[1]);
                    lsAllFile(lsFile);
                } else if(cmds[0].equals("find")){
                    List<File> found = find(cmds[1]);
                    System.out.println("There are " + found.size() + " file have been matched.");
                    for (File afile: found) {
                        System.out.println("-" + afile.getName());
                    }
                } else if (cmds[0].equals("findrec")){
                    List<String> found = findrec(cmds[1]);
                    System.out.println("There are " + found.size() + " file have been matched.");
                    for (String astr: found) {
                        System.out.println("-" + astr);
                    }
                } else if (cmds[0].equals("bye")) {
                    sayGoodBye = true;
                    bin.close();
                } else {
                    System.out.println("No command '"+cmds[0] +"'found.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        FileHandler fhandler = new FileHandler();
        fhandler.cmdTrigger();
    }
}
