package graphic;
import javazoom.jl.player.*;
import java.io.FileInputStream;
public class Audio {
      static Player playmp3;
      static String filename;

	public Audio(){
		
	}
	public static void play(String filename){
	try{
		FileInputStream file=new FileInputStream("/sound/FIFA2000.mp3");
		playmp3=new Player(file);
		playmp3.play();
	
			
		
		// TODO Auto-generated method stub
		}
		catch(Exception e){
			System.out.println(e);
		}
	   
       new Thread() {
	      @Override
	      public void run() {
	        try {
	          playmp3.play();
	        } catch (Exception e) {
	            System.err.printf("%s\n", e.getMessage());
	        }
	      }
	    }.start();
	}
	public static void close() {
		if(playmp3!=null){
			playmp3.close();
		}
		// TODO Auto-generated method stub
		
	}
}