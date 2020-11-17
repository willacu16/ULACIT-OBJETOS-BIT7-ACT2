package actividad2;

public class Cliente{
	
	String ced;
	String nombre;
	String direccion;
	String telefono;
	String correo;
	
	public Cliente() {
		super();
	}

	public Cliente(String ced, String nombre, String direccion, String telefono, String correo) {
		super();
		this.ced = ced;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	/**
	 * @return the ced
	 */
	public String getCed() {
		return ced;
	}

	/**
	 * @param ced the ced to set
	 */
	public void setCed(String ced) {
		this.ced = ced;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String mostrarCliente() {
		return "\n\tCédula: " + ced + "\n\tNombre: " + nombre + "\n\tDirección: " + direccion + "\n\ttelefono: " + telefono + "\n\tcorreo: " + correo;
	}
	
	
}
