package actividad2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Supermercado {
	
	Productos productos = new Productos();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Carrito> carritos = new ArrayList<Carrito>();
	
	public Supermercado() {
		super();
	}

	/**
	 * @return the productos
	 */
	public Productos getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	/**
	 * @return the clientes
	 */
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}	
	
	/**
	 * @return the carritos
	 */
	public ArrayList<Carrito> getCarritos() {
		return carritos;
	}

	/**
	 * @param carritos the carritos to set
	 */
	public void setCarritos(ArrayList<Carrito> carritos) {
		this.carritos = carritos;
	}

	public boolean validarCliente(String ced) {
		for (Cliente cliente : clientes) {
			if (cliente.getCed().equals(ced)) {
				return true;
			}
		}
		return false;
	}
	
	public Carrito buscarCarrito(String ced) {
		for (Carrito carrito : carritos) {
			if (carrito.getCliente().getCed().equals(ced)) {
				return carrito;
			}
		}
		return null;
	}
	
	public Carrito agregarCarrito(Carrito carrito) {
		
		try {
			Item newItem = new Item();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			String nombre = "";
			int cantidad = 0;
					
			System.out.println("Digite el nombre del producto:");
	        nombre = reader.readLine();
	        
	        for (Item item: productos.items) {
	        	if (item.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
	        		System.out.println("Digite la cantidad a comprar [max = " + item.getCantidadDisponible() + "]:");
	    	        cantidad = Integer.valueOf(reader.readLine());
	    	        
	    	        if (cantidad <= item.getCantidadDisponible() ) {
		        		for (Carrito c : carritos) {
		    				if (c.getId() == carrito.getId()) {
		    					newItem = item;
		    					newItem.setCantidadDeCompra(cantidad);
		    					item.setCantidadDisponible(item.getCantidadDisponible() - cantidad);
		    					c.items.add(item);
		    					return c;
		    				}
		    			}
	    	        } else {
	    	        	System.out.println("ERR: Cantidad solicitada no disponible! Intente de nuevo!");
	    	        }
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int pagar(Carrito carrito) {
		int total = 0;
		for (Item item : carrito.getItems()) {
			total += item.getCantidadDeCompra() * item.getPrecioUnitario();
		}
		return total;
	}
	
	
	public String facturar(Carrito carrito) {
		String factura = "-- FACTURA PALI --\n\tITEM  |  PRECIO UNITARIO  |  CANTIDAD COMPRADA  |  MONTO";
		for (Item item : carrito.getItems()) {
			factura += "\n\t" + item.getNombre() + "  |  " + item.getPrecioUnitario() + "  |  " + item.getCantidadDeCompra() + "  |  " + item.getPrecioUnitario() * item.getCantidadDeCompra();
		}
		factura += "\n\t\tTOTAL: " + pagar(carrito) + "\n-- Gracias por su visita --\n";
		return factura;
	}
	
	
}
