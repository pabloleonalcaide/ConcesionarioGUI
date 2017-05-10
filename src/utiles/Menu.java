package utiles;

import concesionarioCoches.Color;

/**
 * Clase utilizada para la gesti�n de un men�. Se dedica a:
 * 
 * <li>Mostrar las opciones del men�
 * 
 * <li>Recoger y devolver las opciones de un men�
 * 
 * @author mlmc
 * 
 */
public class Menu {
	String titulo = null;
	String opciones[] = null;
	int numOpciones = 2;

	/**
	 * 
	 * @param titulo
	 *            t�tulo del men�
	 * @param opciones
	 *            opciones del men�
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	/**
	 * Gestiona el men�. Consiste en mostrar las opcines y recoger la opci�n
	 * seleccionada por el usuario
	 * 
	 * @return opci�n v�lida del men�
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del men�
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opci�n v�lida del men�
	 * 
	 * @return opci�n v�lida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

}
