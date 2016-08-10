/* 
Utilizando el archivo “numeros.dat” del ejercicio 1, crear un nuevo programa que realiza una
copia de seguridad. Es obligatorio el uso de excepciones verificando la existencia del archivo de
origen. Deberá utilizar un FileOutputStream.
El programa tendrá un objeto de clase CopiaDeSeguridad cuyo método crearBackup(String
nombreArchivoOrigen, String nombreArchivoDestino) que lanzará excepciones(ver que tipo puede
lanzar), copiará el archivo cuyo nombre recibe como parámetro en otro idéntico, pero en cuya
extensión se remplazará por “.bak”.
Al llamar a la rutina crearBackup() debe obtenerse un archivo llamado “numeros.bak”, el que se
encontrará en la misma carpeta que “numeros.dat”.
Utilizando un objeto de clase File, probar que ambos archivos existan en su directorio, y que el
tamaño del archivo de bkup sea el mismo que el original. Esta prueba se realizara imprimiendo los
datos indicados. 
El archivo para probar será TP6Test2.java*/  
package edu.ort.t3.tp6;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TP6Test2 {

	public static void main(String[] args) {
		CopiaDeSeguridad copy = new CopiaDeSeguridad();
		try{
			copy.cearBackup("Ej_6\\numeros.dat", "Ej_6\\numeros.bak");
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		File archiOri = new File("Ej_6\\numeros.dat");
		File archiCop = new File("Ej_6\\numeros.bak");
		if(archiOri.exists()){
			System.out.print("El archivo "+archiOri.getName()+" esta en el directorio: ");
			System.out.print(archiOri.getAbsolutePath()+"\n");
		}
		else
			System.out.println("El archivo "+archiOri.getName()+" no existe en el directorio");
		if(archiCop.exists()){
			System.out.print("El archivo "+archiCop.getName()+" esta en el directorio: ");
			System.out.println(archiCop.getAbsolutePath());
		}
		else
			System.out.println("El archivo "+archiCop.getName()+" no existe en el directorio");
		if(archiOri.length()==archiCop.length()){
			System.out.println("Tamaño del archivo " + archiOri.getName() + " :" + archiOri.length()+"kb");
			System.out.println("Tamaño del archivo " + archiCop.getName() + " :" + archiCop.length()+"kb");
		}
		
	}

}
