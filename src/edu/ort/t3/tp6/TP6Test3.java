package edu.ort.t3.tp6;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
//import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TP6Test3 {

	public static void main(String[] args) {
		File archi = new File(args[0]);
		File archi2 = new File("Ej_6\\TP6Test3.txt");
		LinkedList<String> lista = new LinkedList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(archi));
			String str = br.readLine();
			while(str != null){
				lista.add(str);
				str = br.readLine();
			}
			for(String linea:lista)
				System.out.println(linea);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo "+archi.getName());
		} catch (IOException e) {
			System.out.println("Error al leer el archivo "+archi.getName());
		}
		try {
			//BufferedWriter br2 = new BufferedWriter(new FileWriter(archi2));
			PrintWriter pw = new PrintWriter(new FileWriter(archi2));
			int i = 0;
			for(String linea:lista){
				//br2.write(++i +"  "+ linea+"\n");
				pw.println(String.format("%-3d"+"%s", ++i, linea));
			}
			//br2.close();
			pw.close();
			BufferedReader br = new BufferedReader(new FileReader(archi2));
			String str2 = br.readLine();
			while(str2 != null){
				System.out.println(str2);
				str2 = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
