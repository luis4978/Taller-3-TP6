package edu.ort.t3.tp6;
import java.io.File;
//import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;

public class ListadoDirectorioOrdenado {
	private File dir;
	private File[] listArchi;
	
	public ListadoDirectorioOrdenado(String ruta) throws FileNotFoundException{
		dir = new File(ruta);
		if(!dir.exists())
			throw new FileNotFoundException("El archivo "+dir.getName()+" no existe");
		else if(dir.isDirectory())
			System.out.println(dir.getAbsolutePath() + " es un directorio");
		else if(dir.isFile()){
			System.out.println(dir.getAbsolutePath() + " es un archivo");
		}				
	}
	public void listar(){
		listArchi = dir.listFiles();
		for(int i=0; i < listArchi.length; i++)
			System.out.printf("%-3d"+listArchi[i].getName()+"\n", i+1);
	}
	public void listar(final String extension){
		listArchi = dir.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(extension);}});
		/*
		listArchi = dir.listFiles(new FileFilter(){
			@Override
			public boolean accept(File dir) {
				return dir.getName().contains(extension);}});
		*/		
		for (int i = 0; i < listArchi.length; i++) {
			System.out.printf("%-3d"+listArchi[i].getName()+"\n", i+1);
		}
	}
	public File getArchivo(int pos){
		return listArchi[pos-1];
	}
	public int tamanio(String nomArchi) throws FileNotFoundException{
		File tamanio = new File(nomArchi);
		if(tamanio.isFile())
			return (int) tamanio.length();
		else if(tamanio.isDirectory())
			throw new FileNotFoundException("El archivo "+tamanio.getName()+" es un directorio");
		return 0;
	}
}
