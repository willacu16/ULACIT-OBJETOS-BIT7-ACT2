package actividad2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Productos extends CRUD{
	
	ArrayList<Item> items = new ArrayList<Item>();
	
	public Productos() {
		super();
	}
	
	public void mostrarProducto(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre del producto:");
			String nombre = reader.readLine();
			
			boolean encontrada = false;
			for (Item p : items) {
				if (p.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					System.out.println(p.mostrarProducto());
					encontrada = true;
		        }
			}
			if (!encontrada) {
				System.out.println("ERR: Producto [" + nombre + "] no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void ordenarAsc(){
		Item temp;
		String anterior = items.get(0).getNombre().toLowerCase();
		
		for (int i = 1; i < items.size(); i++) {
			if (items.get(i).getNombre().toLowerCase().compareTo(anterior)<0) {
				temp = items.get(i);
				items.set(i, items.get(i-1));
				items.set(i-1, temp);
	        	i = 1;
	        }
			anterior = items.get(i).getNombre().toLowerCase();
		}
	}

	@Override
	public void create() {
		try {
			Item nuevoItem = new Item();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			String input = "";
					
			System.out.println("Digite el nombre del producto:");
	        input = reader.readLine();
	        nuevoItem.setNombre(input);
	        
	        System.out.println("Digite la cantidad diponible del producto:");
	        input = reader.readLine();
	        nuevoItem.setCantidadDisponible(Integer.valueOf(input));
	        
	        System.out.println("Digite el precio unitario del producto:");
	        input = reader.readLine();
	        nuevoItem.setPrecioUnitario(Integer.valueOf(input));
	        
			items.add(nuevoItem);
			System.out.println("Producto [" + nuevoItem.getNombre() + "] agregado!");
			ordenarAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read() {
		ordenarAsc();
		for (Item p : items) {
			System.out.println(p.mostrarProducto());
		}
	}

	@Override
	public void update() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre del producto a actualizar:");
			String nombre = reader.readLine();
			
			int index = -1;
			for (int i=0; i < items.size(); i++) {
				if (items.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					index = i;
				}
			}
			
			if (index != -1) {
				Item viejoItem = items.get(index);
				Item nuevoItem = new Item();
				String input = "";
				
				System.out.println("Digite el nuevo nombre para [" + viejoItem.getNombre() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoItem.setNombre(viejoItem.getNombre());
		        } else {
		        	nuevoItem.setNombre(input);
		        }
		        
		        System.out.println("Digite la nueva Cantidad Disponible del producto [Cantidad actual = " + viejoItem.getCantidadDisponible() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoItem.setCantidadDisponible(viejoItem.getCantidadDisponible());
		        } else {
		        	nuevoItem.setCantidadDisponible(Integer.valueOf(input));
		        }
		        
		        System.out.println("Digite el nuevo Precio Unitario del producto [Precio actual = " + viejoItem.getPrecioUnitario() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoItem.setPrecioUnitario(viejoItem.getPrecioUnitario());
		        } else {
		        	nuevoItem.setPrecioUnitario(Integer.valueOf(input));
		        }
		        
		        items.set(index, nuevoItem);
		        System.out.println("Producto [" + nuevoItem.getNombre() + "] actualizado!");
			} else {
				System.out.println("ERR: Producto no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void delete() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el nombre del producto a eliminar:");
			String nombre = reader.readLine();
			
			int index = -1;
			for (int i=0; i < items.size(); i++) {
				if (items.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					index = i;
				}
			}
			
			if (index != -1) {
				try {
					items.remove(index);
					System.out.println("Producto eliminado!");
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				System.out.println("ERR: Producto no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
