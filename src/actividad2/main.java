package actividad2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		
		boolean validado = false;
		Carrito carritoActual = new Carrito();
		
		//Productos
		Item arroz = new Item("Arroz", 30, 100);
		Item frijoles = new Item("Frijoles", 20, 10);
		Item azucar = new Item("Azucar", 10, 50);
		
		//Clientes
		Cliente juan = new Cliente("1", "Juan Juarez", "Ontario Street", "8-888-99-88", "jj@unknown.com");
		Cliente ana = new Cliente("2", "Ana Alvarez", "Toronto Street", "7-333-44-11", "aa@unknown.com");
		
		//Carritos
		Carrito carritoJuan = new Carrito(10, juan, new ArrayList<Item>());
		Carrito carritoAna = new Carrito(20, ana, new ArrayList<Item>());
		
		//Supermercado
		Supermercado pali = new Supermercado();
		//Productos
		pali.productos.items.add(arroz);
		pali.productos.items.add(frijoles);
		pali.productos.items.add(azucar);
		//Clientes
		pali.clientes.listaClientes.add(juan);
		pali.clientes.listaClientes.add(ana);
		//Carritos
		pali.carritos.add(carritoJuan);
		pali.carritos.add(carritoAna);		
		
		
		
		///////////////////////////////////////
		//MENU
		///////////////////////////////////////
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		String respuesta = "";
		do {
			try {
				System.out.println("\n-----------------------");
				System.out.println("------    PALI    ------");
				System.out.println("------------------------");
				System.out.println("1) Login");
				System.out.println("2) Logout");
				System.out.println("3) Ver Carrito");
				System.out.println("4) Agregar al Carrito");
				System.out.println("5) Pagar");
				System.out.println("6) Facturar");
				System.out.println("-------   Clientes   -------");
				System.out.println("c1) Mostrar Clientes");
				System.out.println("c2) Buscar Cliente");
				System.out.println("c3) Ingresar nuevo Cliente");
				System.out.println("c4) Actualizar Cliente");
				System.out.println("c5) Eliminar Cliente");
				System.out.println("-------   Productos   -------");
				System.out.println("p1) Mostrar Productos");
				System.out.println("p2) Buscar Producto");
				System.out.println("p3) Ingresar nuevo Producto");
				System.out.println("p4) Actualizar Producto");
				System.out.println("p5) Eliminar Producto");
				
				System.out.println("x) Salir\n");
				System.out.println("Digite una opción: ");
				respuesta = reader.readLine();
				
				switch (respuesta) {
					case "1":{
						System.out.println("Digite una cedula del cliente: ");
						String ced = reader.readLine();
						if (pali.validarCliente(ced)) {
							carritoActual = pali.buscarCarrito(ced);
							System.out.println("Bienvenido " + carritoActual.getCliente().getNombre());
							validado = true;
						}
						break;
					}
					case "2":{
						System.out.println("Session cerrada!");
						carritoActual = new Carrito();
						validado = false;
						break;
					}
					case "3":{
						if (validado) {
							System.out.println("Carrito:");
							System.out.println(carritoActual.mostrarCarrito());
						} else {
							System.out.println("*** DEBE INGRESAR AL SISTEMA PRIMERO ***:");
						}
						break;
					}
					case "4":{
						if (validado) {
							carritoActual = pali.agregarCarrito(carritoActual);
						} else {
							System.out.println("*** DEBE INGRESAR AL SISTEMA PRIMERO ***:");
						}
						break;
					}
					case "5":{
						if (validado) {
							System.out.println("Total a pagar: " + pali.pagar(carritoActual));
						} else {
							System.out.println("*** DEBE INGRESAR AL SISTEMA PRIMERO ***:");
						}
						break;
					}
					case "6":{
						if (validado) {
							System.out.println("   Procesando factura ...");
							System.out.println(pali.facturar(carritoActual));
							carritoActual.setItems(new ArrayList<Item>());
						} else {
							System.out.println("*** DEBE INGRESAR AL SISTEMA PRIMERO ***:");
						}
						break;
					}
					case "c1":{
						pali.clientes.read();
						break;
					}
					case "c2":{
						pali.clientes.mostrarCliente();
						break;
					}
					case "c3":{
						pali.clientes.create();
						break;
					}
					case "c4":{
						pali.clientes.update();
						break;
					}
					case "c5":{
						pali.clientes.delete();
						break;
					}
					case "p1":{
						System.out.println("Productos:");
						pali.productos.read();
						break;
					}
					case "p2":{
						pali.productos.mostrarProducto();
						break;
					}
					case "p3":{
						pali.productos.create();
						break;
					}
					case "p4":{
						pali.productos.update();
						break;
					}
					case "p5":{
						pali.productos.delete();
						break;
					}
					case "x":{
						validado = false;
						System.out.println("---- Gracias! ----");
						break;
					}
					default:{
						System.out.println("Opcion no válida!");
						break;
					}
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (!respuesta.equals("x"));
	}

}
