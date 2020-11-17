package actividad2;

public class Item extends Producto{
	
	int cantidadDeCompra = 0;

	public Item() {
		super();
	}
	
	public Item(String nombre, int cantidadDisponible, int precioUnitario) {
		super(nombre, cantidadDisponible, precioUnitario);
	}

	

	/**
	 * @return the cantidadDeCompra
	 */
	public int getCantidadDeCompra() {
		return cantidadDeCompra;
	}

	/**
	 * @param cantidadDeCompra the cantidadDeCompra to set
	 */
	public void setCantidadDeCompra(int cantidadDeCompra) {
		this.cantidadDeCompra = cantidadDeCompra;
	}

	public boolean validarDisponible(int cantidad) {
		if (cantidadDisponible >= cantidad) {
			return true;
		}
		return false;
	}

	public String mostrarItem() {
		return "\n\t\tNombre: " + nombre + "\n\t\tPrecio Unitario: " + precioUnitario + "\n\t\tCantidad de Compra: " + cantidadDeCompra + "\n";
	}
	
	
}
