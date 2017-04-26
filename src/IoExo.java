import java.io.*;

public class IoExo{

  public static void createFile(String path){
    File file = new File(path);
    try {
      boolean b = file.createNewFile();
      if(b){
        System.out.println("create successfully.");
      }
    } catch (IOException e) {
      System.out.println("Create file failed.");
    }

        System.out.println("is it a directory? " + (file.isDirectory()==true ? " Yes! " : " No!"));
  }

  public static void main(String[] args){
    IoExo i = new IoExo();
    i.createFile("hello.txt");
  }

  public void readFile(String path){
    File file = new File(path);

  }

}
