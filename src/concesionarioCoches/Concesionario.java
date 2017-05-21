package concesionarioCoches;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.CocheNoExisteException;
import excepciones.CocheNoValidoException;
import excepciones.CocheYaExisteException;
import excepciones.ColorNoValidoException;
import excepciones.MatriculaNoValidaException;
import excepciones.ModeloNoValidoException;

/*
 * No pueden existir dos coches con la misma matr�cula en el almac�n del concesinario
 * no puede a�adirse un coche al concecionario con alguno de sus atributos inv�lidos. Han de conocerse todas sus caracter�sticas 
 * Ninguno de los valores puede ser por defecto
 */
/**
 * Representa un concesionario de coches.
 * 
 * L�gicamente, no podr� a�adirse un coche inv�lido almac�n del concesinario)
 * 
 * Han de conocerse todas sus caracter�sticas Ninguno de los valores puede ser
 * por defecto
 * 
 * @author Mar�aLourdes
 * 
 */
public class Concesionario implements Serializable {
private ArrayList<Coche> almacen = new ArrayList<Coche>();
	
private final String nombre = "";
private boolean modificado = false;



	/**
	 * A�ade un coche al almacen
	 * 
	 * @param matricula
	 *            Representa la matr�cula del coche a a�adir
	 * @param color
	 *            Representa el color del coche a a�adir
	 * @param modelo
	 *            Representa el modelo del coche a a�adir
	 * @return true si el coche se a�ade, false en otro caso (el coche es null o
	 *         el coche ya est� contenido en el almacen)
	 * @throws CocheNoValidoException 
	 * @throws ModeloNoValidoException 
	 * @throws ColorNoValidoException 
	 * @throws MatriculaNoValidaException 
	 */
	public boolean annadir(String matricula, Color color, Modelo modelo) throws CocheNoValidoException, MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException {
		Coche coche = new Coche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			return false;
		return almacen.add(coche);
	}

	/**
	 * Elimina un coche del almacen
	 * 
	 * @param matricula
	 *            Representa la matr�cula del coche a eliminar
	 * @return true si el coche se elimina, false en otro caso (el coche no est�
	 *         en el almacen)
	 * @throws MatriculaNoValidaException 
	 */
	public boolean eliminar(String matricula) throws MatriculaNoValidaException {
		return almacen.remove(Coche.getInstance(matricula));
	}

	/**
	 * Devuelve el n�mero de coches del almacen
	 * 
	 * @return N�mero de coches del almacen
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el coche indicado por la matr�cula
	 * 
	 * @param matricula
	 *            Representa la matr�cula a buscar
	 * @return Coche contenido en el almacen. null si no existe
	 * @throws MatriculaNoValidaException 
	 */
	public Coche get(String matricula) throws MatriculaNoValidaException {
		Coche coche = Coche.getInstance(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		return null;
	}
	
	public Coche get(int index) {
		if(almacen.isEmpty())
			return null;
		if(index < 0 | index > almacen.size()-1)
			return null;
		return almacen.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}
	public boolean isModificado() {
		return modificado;}
	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}
	/**
	 * Genera una lista de coches de un determinado color
	 * 
	 * @param color
	 *            Representa el color a buscar
	 * @return Lista de coches de un determinado color
	 */
	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

	public boolean isVacio() {
		
		return size() == 0;
	}}
