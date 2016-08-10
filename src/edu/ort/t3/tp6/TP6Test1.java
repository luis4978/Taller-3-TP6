package edu.ort.t3.tp6;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TP6Test1 {
	private static final int tope = 100;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		if (args.length != 2) {
			System.out.println("Debe ingresar el Directorio y el nombre del archivo");
			System.exit(-1);
		}
		File dir = new File(args[0]);
		dir.mkdirs();
		File archi = new File(dir.getAbsolutePath()+args[1]);//System.out.println(archi.length());
		if (archi.exists()) {
			System.out.println("El archivo ya existe. Que desea hacer?");
			System.out.println("leer(l), re-grabar(e), para salir(-1))");
			String str = "";
			while(input.hasNext()){
				str = input.next();
				switch (str){
				case "l":
					System.out.println("Leyendo archivo...");
					leer(archi);
					break;
				case "e":
					System.out.println("Re-grabando archivo...");
					grabar(archi);
					break;
				case "-1":
					System.out.println("Fin del programa.");
					System.exit(-1);
					break;
				default:
					System.out.println("Ingreso invalido!! ");
				}
				System.out.println("Que desea hacer?");
				System.out.println("leer(l), escribir(e), para salir (-1):");
			}
			input.close();
		} else {
			grabar(archi);
			leer(archi);
		}
	}
	/////////////grabar///////////////////
	public static void grabar(File archi){
		try {
			FileOutputStream grabar = new FileOutputStream(archi);
			try {
				for (int i = 0; i < tope; i++) {
					grabar.write(i + 1);
				}
				System.out.println("Archivo grabado con exito.");
				grabar.close();
			} 
			catch (IOException e) {
				System.out.println("Error al grabar el archivo.");
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo: ");
		}
	}
	/////////////leer/////////////////
	public static void leer(File archi){
		try {
			FileInputStream leer = new FileInputStream(archi);
			byte[] datos = new byte[(int) archi.length()];
			try {
				leer.read(datos);
				for (byte i : datos) {
					System.out.printf("%4d", i);
					if (i % 20 == 0)
						System.out.print("\n");
				}
				System.out.println("Archivo leido con exito.");
				leer.close();
			} 
			catch (IOException e) {
				System.out.println("Error al leer el archivo.");
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo: ");
		}
	}
}