package actividad2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Clientes extends CRUD{
	
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public Clientes() {
		super();
	}
	
	public void mostrarCliente(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite la cédula del cliente:");
			String ced = reader.readLine();
			
			boolean encontrada = false;
			for (Cliente c : listaClientes) {
				if (c.getCed().toLowerCase().equals(ced.toLowerCase())) {
					System.out.println(c.mostrarCliente());
					encontrada = true;
		        }
			}
			if (!encontrada) {
				System.out.println("ERR: Cliente con cédula [" + ced + "] no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void ordenarAsc(){
		Cliente temp;
		String anterior = listaClientes.get(0).getNombre().toLowerCase();
		
		for (int i = 1; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getNombre().toLowerCase().compareTo(anterior)<0) {
				temp = listaClientes.get(i);
				listaClientes.set(i, listaClientes.get(i-1));
				listaClientes.set(i-1, temp);
	        	i = 1;
	        }
			anterior = listaClientes.get(i).getNombre().toLowerCase();
		}
	}

	@Override
	public void create() {
		try {
			Cliente nuevoCliente = new Cliente();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			String input = "";
					
			System.out.println("Digite el número de cédula del cliente:");
	        input = reader.readLine();
	        nuevoCliente.setCed(input);
	        
	        System.out.println("Digite el nombre del cliente:");
	        input = reader.readLine();
	        nuevoCliente.setNombre(input);
	        
	        System.out.println("Digite la dirección del cliente:");
	        input = reader.readLine();
	        nuevoCliente.setDireccion(input);
	        
	        System.out.println("Digite el número de teléfono del cliente:");
	        input = reader.readLine();
	        nuevoCliente.setTelefono(input);
	        
	        System.out.println("Digite el correo del cliente:");
	        input = reader.readLine();
	        nuevoCliente.setCorreo(input);
	        
			listaClientes.add(nuevoCliente);
			System.out.println("Cliente [" + nuevoCliente.getNombre() + ", ced: " + nuevoCliente.getCed() +"] agregado!");
			ordenarAsc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read() {
		ordenarAsc();
		for (Cliente c : listaClientes) {
			System.out.println(c.mostrarCliente());
		}
	}

	@Override
	public void update() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el número de cédula del cliente a actualizar:");
			String cedula = reader.readLine();
			
			int index = -1;
			for (int i=0; i < listaClientes.size(); i++) {
				if (listaClientes.get(i).getCed().toLowerCase().equals(cedula.toLowerCase())) {
					index = i;
				}
			}
			
			if (index != -1) {
				Cliente viejoCliente = listaClientes.get(index);
				Cliente nuevoCliente = new Cliente();
				String input = "";
				
				System.out.println("Digite el nuevo número de cédula o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoCliente.setCed(viejoCliente.getCed());
		        } else {
		        	nuevoCliente.setCed(input);
		        }
		        
				System.out.println("Digite el nuevo nombre para [" + viejoCliente.getNombre() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoCliente.setNombre(viejoCliente.getNombre());
		        } else {
		        	nuevoCliente.setNombre(input);
		        }
		        
		        System.out.println("Digite la nueva dirección [Dirección Actual: " + viejoCliente.getDireccion() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoCliente.setDireccion(viejoCliente.getDireccion());
		        } else {
		        	nuevoCliente.setDireccion(input);
		        }
		        
		        System.out.println("Digite el nuevo número de teléfono [Número de teléfono Actual: " + nuevoCliente.getTelefono() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoCliente.setTelefono(viejoCliente.getTelefono());
		        } else {
		        	nuevoCliente.setTelefono(input);
		        }
		        
		        System.out.println("Digite el nuevo correo [Correo Actual: " + nuevoCliente.getCorreo() + "] o presione ENTER para no modificar:");
		        input = reader.readLine();
		        if (input.isEmpty()) {
		        	nuevoCliente.setCorreo(viejoCliente.getCorreo());
		        } else {
		        	nuevoCliente.setCorreo(input);
		        }
		        
		        listaClientes.set(index, nuevoCliente);
		        System.out.println("Cliente [" + nuevoCliente.getNombre() + ", ced: " + nuevoCliente.getCed() + "] actualizado!");
			} else {
				System.out.println("ERR: Cliente no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void delete() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Digite el número de cédula del cliente a eliminar:");
			String cedula = reader.readLine();
			
			int index = -1;
			for (int i=0; i < listaClientes.size(); i++) {
				if (listaClientes.get(i).getCed().toLowerCase().equals(cedula.toLowerCase())) {
					index = i;
				}
			}
			
			if (index != -1) {
				try {
					listaClientes.remove(index);
					System.out.println("Cliente eliminado!");
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				System.out.println("ERR: Cliente no encontrado!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
