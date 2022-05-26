package trabajo_prog;

import java.io.Serializable;

public class Persona implements Serializable {

	// Datos de cada persona
	String nombre;
	String apellido;
	String nombreUsuario;
	String correo;
	String contrase�a;
	String descuento;

	// Constructor
	public Persona(String nombre, String apellido, String nombreUsuario, String correo, String contrase�a, String descuento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.descuento = descuento;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public String getContrase�a() {
		return contrase�a;
	}
	public String getDescuento() {
		return descuento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return nombre + ";" + apellido + ";" + nombreUsuario + ";" + correo + ";" + contrase�a + ";" + descuento;
	}

}
