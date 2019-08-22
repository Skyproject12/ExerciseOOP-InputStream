package inputstream;
import java.io.*;
public class InputStream implements Serializabel {
    private String nama;
    private int jumlah;

    public InputStream(String nm, int jlm) {
        this.nama = nm;
        this.jumlah = jlm;
    }

    @Override
    public void tampil() {
        System.out.println("nama barang"+nama);
        System.out.println("jumlah barang"+jumlah);
    }

    @Override
    public void simpanObject(InputStream ob) {
        try{
            FileOutputStream fos= new FileOutputStream("dtBrg.txt");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(ob);
            oos.flush();
        }
        catch (IOException ioe) {
            System.out.println("error"+ioe);
        }
    }

    @Override
    public void bacaObject(InputStream obb) {
       try{
           FileInputStream fis = new FileInputStream("dtBrg.txt");
           ObjectInputStream ois = new ObjectInputStream(fis);
           while((obb=(InputStream)ois.readObject())!=null)obb.tampil();
           
       }
       catch (IOException ioe) {
            System.exit(1);
        }
       catch (Exception e) {
            System.exit(1);
        }
    }
    
    
    
    
    public static void main(String[] args) {
       InputStream a1= new InputStream("Baju",5);
        a1.tampil();
    }
    
}
