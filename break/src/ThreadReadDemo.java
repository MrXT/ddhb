import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
public class ThreadReadDemo {
    public static Date sta = new Date();
    /**Java多线程读大文件
     * @param args
     */
    public static void main(String[] args) {
        
        Thread t1=new Thread(new MultiThread(),"A");
        Thread t2=new Thread(new MultiThread(),"B");
        t1.start();
        t2.start();
    }

}


 class MultiThread implements Runnable{ 
    private static int counts = 0;
    private static BufferedReader br = null;
    
    static{
        try {
            br = new BufferedReader(new FileReader("C://Users//Administrator//Desktop//tools//EWSApj//packet//超级字典.txt"),10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        String line = null;
        int count = 0;
        while(true) {
            synchronized(br) {
                try {
                    counts ++;
                    File f = new File("C://Users//Administrator//Desktop//2//"+counts+".txt");
                    if(!f.exists()){
                        f.createNewFile();
                    }
                    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                    while((line = br.readLine()) != null) {
                        if(count<10000) {
                            bw.write(line);
                            bw.newLine();
                            count++;
                        }else {
                            bw.write(line);
                            bw.newLine();
                            count = 0;
                            bw.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(line == null){
                System.out.println((new Date().getTime() - ThreadReadDemo.sta.getTime())/1000);
                break;
            }
        }
    }
    
}
