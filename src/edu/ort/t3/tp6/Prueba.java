package edu.ort.t3.tp6;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Prueba {

	public static void main(String[] args) {
		File archi = new File("Agenda.dat");
		if(!archi.exists()){
			System.out.println("El archivo "+archi.getName()+" no existe");
		}
		else{
			try {
				FileInputStream fs = new FileInputStream(archi);
				DataInputStream di = new DataInputStream(fs);
				try {
					di.readInt();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
