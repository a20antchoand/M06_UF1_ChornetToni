package m06.uf1.examen1_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	
	private BufferedWriter bw;
	private String ruta;
	
	public Log(String ruta) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");  
	    Date date = new Date();
	    String temps = formatter.format(date);
		this.ruta = ruta + "/execucio_" + temps + ".log";
	}
	
	public void open() throws IOException {
		this.bw = new BufferedWriter(new FileWriter(this.ruta, true));
	}
	
	public void addLine(String linia) throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");  
	    Date date = new Date();
	    String moment = formatter.format(date);
		this.open();
		this.bw.write("[ " + moment + " ] " + linia + "\n");
		this.bw.close();
	}
	
}