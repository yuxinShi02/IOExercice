import java.io.*;

/*
Écrire un programme qui lit un fichier texte et le modifie afin qu’il contienne le
même texte mais avec un caractère « : » entre chaque caractère du texte.
*/

public class EXO1{

  public EXO1(){
  }
  public void modifyFile(String path){
    try{
      InputStream f = new FileInputStream(path);

      int size = f.available();
      byte [] suit = new byte[size];
      for(int i=0; i< size; i++){
        suit[i] = (byte)f.read();
        System.out.print((char)suit[i]);
      }

      OutputStream os = new FileOutputStream(path);
      for(int i = 0; i < size; ++i){
        os.write(suit[i]);
        os.write(':');
      }
      os.close();
      f.close();
    }catch(IOException e){
    }

  }

  public void copieFile(String src, String dest){
    File fd = new File(src);
    File out = new File(dest);
    FileInputStream fin = null;
    FileOutputStream fos = null;
    byte[] buffer = new byte[1024];
    if(!fd.exists()){
      System.out.println("File doesn't exist.");
      return;
    } else {
      try{
        fin = new FileInputStream(fd);
        fos = new FileOutputStream(out);
        int num = 0;
        while((num = fin.read(buffer)) != -1){
          fos.write(buffer,0,num);
        }
      }catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          fin.close();
          fos.close();
        } catch (IOException e){
          e.printStackTrace();
        }
      }
    }
  }


  public static void main(String[] arg){
    EXO1 e = new EXO1();
    //e.modifyFile("text.txt");
    //e.copieFile("text.txt", arg[1]);
  }

}
