package concesionarioCoches;

import java.io.Serializable;
//P: Indica cu�ndo se utiliza la etiqueta @see Busca c�mo se usa en http://docs.oracle.com/javase/7/docs/technotes/tools/solaris/javadoc.html
import java.util.regex.Pattern;

import excepciones.CocheNoValidoException;
import excepciones.ColorNoValidoException;
import excepciones.MatriculaNoValidaException;
import excepciones.ModeloNoValidoException;

/**
 * @author MariaLourdes
 * @version 2.0
 * 
 */
public class Coche implements Serializable {

	private String matricula;
	private Color color;
	private Modelo modelo;

	static final private Pattern controlMatricula = Pattern.compile("^\\d{4}[ -]?[a-zA-Z&&[^aeiouAEIOUÑQ]]{3}$");

	// Constructor privatizado, controlamos primero la matricula antes de
	// crearlo
	Coche(String matricula, Color color, Modelo modelo)
			throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException {
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	private Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}
//
//	static Coche instanciarCoche(String matricula, Color color, Modelo modelo)
//			throws CocheNoValidoException, MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException {
//		if (matriculaValida(matricula) && color != null && modelo != null)
//			return new Coche(matricula, color, modelo);
//		else
//			throw new CocheNoValidoException();
//	}

	static Coche getInstance(String matricula) throws MatriculaNoValidaException {
		if (matriculaValida(matricula))
			return new Coche(matricula);
		return null;
	}

	public static boolean matriculaValida(String matricula) {
		return controlMatricula.matcher(matricula).matches();
	}

	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (!matriculaValida(matricula))
			throw new MatriculaNoValidaException("la matricula no es valida");

		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setColor(Color color) throws ColorNoValidoException {
		if (color == null)
			throw new ColorNoValidoException("el color no es valido");

		this.color = color;
	}

	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo == null)
			throw new ModeloNoValidoException("el modelo no es valido");
		this.modelo = modelo;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	// Lo unico que nos preocupa al comparar coches es la matricula
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nCoche matricula: " + matricula + ", color: " + color + ", modelo: " + modelo;
	}

	public Color getColor() {
		return this.color;
	}
}