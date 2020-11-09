package actividad2;

public class Item extends Producto{
	
	int cantidadDeCompra;

	public Item() {
		super();
	}
	
	public Item(String nombre, int cantidadDisponible, int precioUnitario) {
		super(nombre, cantidadDisponible, precioUnitario);
		this.cantidadDeCompra = 0;
	}

	public Item(String nombre, int cantidadDisponible, int precioUnitario, int cantidadDeCompra) {
		super(nombre, cantidadDisponible, precioUnitario);
		this.cantidadDeCompra = cantidadDeCompra;
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
	
	@Override
	public String toString() {
		return mostrarProducto() + "\n\tCantidad de Compra: " + cantidadDeCompra + "\n";
	}
	
}
