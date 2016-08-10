package edu.ort.t3.tp6;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TP6Test6 {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			ListadoDirectorioOrdenado l = new ListadoDirectorioOrdenado("src\\edu\\ort\\t3\\tp6");
			//l.listar();
			l.listar(".java");
			System.out.print("Ingrese numero de archivo para verificar tamaño, -1 para salir: ");
			System.out.println(l.tamanio(l.getArchivo(input.nextInt()).getName()));
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	

}
