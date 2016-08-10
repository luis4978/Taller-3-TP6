package edu.ort.t3.tp6;
import java.util.Scanner;

import edu.ort.t3.tp4.Alumno;
import edu.ort.t3.tp4.Persona;
import edu.ort.t3.tp4.Profesor;

public class Curso {
	private static final int TOPE = 2;
	private int altas = 0;
	private Persona[] personas;
	private Scanner input;
	private String lista = "";
	private String op = "";
	private Boolean valida;

	public Curso() {
		personas = new Persona[TOPE];
		input = new Scanner(System.in);
	}

	public void procesar() {
		do {
			System.out.printf("*********************************************\n"
					+"%15s" + "Menu Cursos\n"
					+"*********************************************\n"
					+"1. Alta de un alumno\n"
					+ "2. Alta de un Profesor\n"
					+ "3. Mostrar todos los datos\n"
					+ "4. Mostrar nombre de profesor y categoria\n"
					+ "5. Mostrar nombre de alumno y estado\n" + "6. Fin\n"
					+ "*********************************************\n"
					+ "Ingrese una opcion: ", "");
			op = input.next();
			if (altas == TOPE && (op.equals("1") | op.equals("2"))) {
				System.out.print("\n\nLa lista inscriptción está complata\n\n");
			} else {
				switch (op) {
				case "1":
					altaPersona(altaAlumno());
					break;
				case "2":
					altaPersona(altaProfesor());
					break;
				case "3":
					verLista();
					break;
				case "4":
					verProfesores();
					break;
				case "5":
					verAlumnos();
					break;
				case "6":
					System.out.println("Fin del programa");
					break;
				default:
					System.out.println("Ingrese una opcion valida");
					break;
				}
			}
		} while (validarMenu());
	}

	private Boolean validarMenu() {
		valida = true;
		try{
			int num = Integer.parseInt(op) ;
			if (num == 6)
				valida = false;
		}catch(NumberFormatException op){
			System.out.println("Debe ingresar solo numeros");
		}
		return valida;
	}

	private void altaPersona(Persona p) {
		p.setNombre(nombre("Ingrese el nombre:"));
		p.setEdad(Integer.parseInt(numerico("Ingrese la edad: ", 12, 75)));

		if (p instanceof Alumno) {
			((Alumno) p).setCurso(Integer.parseInt(numerico("Ingrese el numero de curso: ", 1, 3)));
			((Alumno) p).setCantMaterias(Integer.parseInt(numerico("Ingrese cantidad de materias que cursa: ", 0, 7)));
			((Alumno) p).setEstado(cadena("Ingrese estado ", "regular", "recursante", "baja"));
		} else if (p instanceof Profesor) {
			((Profesor) p).setDepartamento(cadena("Ingrese cátedra ", "sistemas" ,"control", "quimica"));
			((Profesor) p).setCategoria(cadena("Ingrese categoría ", "titular", "suplente", "auxiliar"));
		}
		personas[altas++] = p;
		System.out.println("Alta registrada");
	}

	private Persona altaAlumno() {
		Alumno p = new Alumno();
		return p;
	}

	private Persona altaProfesor() {
		Profesor p = new Profesor();
		return p;
	}

	public void verAlumnos() {
		System.out.println("\n##################");
		System.out.println("Lista de Alumnos: ");
		System.out.println("##################");
		lista = "";
		for (Persona p : personas) {
			if (p != null & p instanceof Alumno) {
				lista += p.toString() + "\n";
			}
		}
		if (lista != "")
			System.out.println(lista);
		else
			System.out.println("\n No hay alumnos inscriptos. \n");
			
	}

	public void verProfesores() {
		System.out.println("\n#####################");
		System.out.println("Lista de Profesores: ");
		System.out.println("#####################\n");
		lista = "";
		for (Persona p : personas) {
			if (p != null & p instanceof Profesor) {
				lista += p.toString() + "\n";
			}
		}
		if (lista != "")
			System.out.println(lista);
		else
			System.out.println(" No hay profesores inscriptos. \n");

	}

	public void verLista() {
		
		int prof = 0;
		int alum = 0;

		System.out.println("\n####################");
		System.out.println("Lista de Profesores: ");
		System.out.println("####################\n");
		for (Persona p : personas) {
			if (p != null & p instanceof Profesor){
				p.verTodo();
				prof ++ ;
				}
		}
		if (prof == 0){System.out.println(" No hay profesores inscriptos. \n");}
		
		System.out.println("\n##################");
		System.out.println("Lista de Alumnos: ");
		System.out.println("####################\n");
		for (Persona p : personas) {
			if (p != null & p instanceof Alumno){
				p.verTodo();
				alum ++ ;
			}
		}
		if (alum == 0) {System.out.println(" No hay alumnos inscriptos. \n");}
		System.out.println("\n");
	}

	//INIICIO VALIDACION DE DATOS
	private String nombre(String mensaje) {
		String nombre = "";
		do {
			System.out.print(mensaje);
			nombre = input.next();
		} while (nombre.matches("\\D+") != true);
		input.nextLine();
		return nombre;
	}

	private String numerico(String mensaje, int desde, int hasta) {
		String num = "";
		do {
			System.out.print(mensaje);
			num = input.next();
		} while (esNumero(num, desde, hasta));
		input.nextLine();
		return num;
	}

	private String cadena(String mensaje, String str1, String str2, String str3) {
		String dato = "";
		do {
			System.out.print(mensaje +"("+str1+", "+str2+", "+str3+"):");
			dato = input.next();
		} while(!(dato.equals(str1) | dato.equals(str2) | dato.equals(str3)));	
		input.nextLine();
		return dato;
	}
	private Boolean esNumero(String numero, int desde, int hasta){
		valida = true;
		try{
			int num =Integer.parseInt(numero);
			if((desde <= num) & (num <=hasta))
				valida = false;
			else
				System.out.println("Debe ingresa un numero entre " + desde + " y " + hasta);
		}catch(NumberFormatException e){
			System.out.println("Debe ingresar solo numeros");
		}
		return valida;
		
	}
}
