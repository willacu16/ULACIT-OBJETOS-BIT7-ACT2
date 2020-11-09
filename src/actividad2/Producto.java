package actividad2;

public class Producto{
	
	String nombre;
	int cantidadDisponible;
	int precioUnitario;
	
	public Producto() {
		super();
	}

	public Producto(String nombre, int cantidadDisponible, int precioUnitario) {
		super();
		this.nombre = nombre;
		this.cantidadDisponible = cantidadDisponible;
		this.precioUnitario = precioUnitario;
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
	 * @return the cantidadDisponible
	 */
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	/**
	 * @param cantidadDisponible the cantidadDisponible to set
	 */
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	/**
	 * @return the precioUnitario
	 */
	public int getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public String mostrarProducto() {
		return "\n\tNombre: " + nombre + "\n\tPrecio Unitario: " + precioUnitario + "\n\tCantidad Disponible: " + cantidadDisponible;
	}

}
