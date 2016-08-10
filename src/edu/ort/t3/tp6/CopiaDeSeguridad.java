package edu.ort.t3.tp6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaDeSeguridad {
	private File fileIn;
	private File fileOut;
	private String nomOri;
	private String nomCop;
	
	public CopiaDeSeguridad(){
		nomOri = "";
		nomCop = "";
	}
	public CopiaDeSeguridad(String nomOri, String nomCopia){
		this.nomOri = nomOri;
		this.nomCop = nomCopia;
	}
	public void cearBackup(String nomOri, String nomCop) throws FileNotFoundException, IOException{
		if(nomOri.isEmpty()|nomCop.isEmpty()){
			this.nomOri = nomOri;
			this.nomCop = nomCop;
		}
		fileIn = new File(nomOri);
		fileOut = new File(nomCop);
		if(fileIn.exists()){//Si el archivo a copiar existe
			if(fileIn.canRead()){//Si el archivo a copiar se puede leer
				if(fileOut.exists()){//Si el archivo a grabar existe
					FileInputStream in = new FileInputStream(fileIn);
					FileOutputStream out = new FileOutputStream(fileOut);
					if(fileOut.canWrite()){//Si el archivo a grabar se puede grabar
						byte[] dato = new byte[(int)fileIn.length()];
						in.read(dato);
						System.out.println("Copiando desde "+ fileIn.getName() + " hacia "+ fileOut.getName());
						out.write(dato);
						System.out.println("Archivo copiado.");
						in.close();
						out.close();
					}else{//Si el archivo a grabar NO se puede grabar
						in.close();
						out.close();
						throw new IOException("Error al grabar el archivo "+fileOut.getName());
					}							
				}else //Si el archivo a grabar NO existe
					throw new FileNotFoundException("Error al abrir el archivo  "+fileOut.getName());
			}else//Si el archivo a copiar NO se puede leer
				throw new IOException("Error al leer el archivo "+fileIn.getName());
		}else//Si archivo a copiar NO existe.
			throw new FileNotFoundException("Error al abrir el archivo "+ fileIn.getName());
	}
}
