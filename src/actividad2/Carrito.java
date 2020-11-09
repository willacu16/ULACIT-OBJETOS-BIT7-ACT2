package actividad2;

import java.util.ArrayList;

public class Carrito {
	
	int id;
	Cliente cliente;
	ArrayList<Item> items;
	
	public Carrito() {
		super();
	}

	public Carrito(int id, Cliente cliente, ArrayList<Item> items) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.items = items;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public String mostrarItems() {
		String values = "";
		for (Item item : items) {
			values = values + item.mostrarItem();
		}
		return values;
	}

	@Override
	public String toString() {
		return "\tid=" + id + "\n\tcliente=" + cliente.toString() + "\n\titems=[" + mostrarItems() + "\t\t]";
	}
	
	
	
}
