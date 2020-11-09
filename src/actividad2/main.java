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
		Cliente ana = new Cliente("2", "Juan Juarez", "Ontario Street", "8-888-99-88", "jj@unknown.com");
		
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
		pali.clientes.add(juan);
		pali.clientes.add(ana);
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
				System.out.println("4) Ver Productos");
				System.out.println("5) Agregar al Carrito");
				System.out.println("6) Pagar");
				System.out.println("7) Facturar");
				
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
						validado = false;
						break;
					}
					case "3":{
						if (validado) {
							System.out.println("Carrito:");
							System.out.println(carritoActual.toString());
						} else {
							System.out.println("*** DEBE INGRESAR AL SISTEMA PRIMERO ***:");
						}
						break;
					}
					case "4":{
						System.out.println("Productos:");
						pali.productos.read();
						break;
					}
					case "5":{
						if (validado) {
							carritoActual = pali.agregarCarrito(carritoActual);
						} else {
							System.out.println("*** DEBE INGRESAR AL SISTEMA PRIMERO ***:");
						}
						break;
					}
					case "6":{
						if (validado) {
							System.out.println("Total a pagar: " + pali.pagar(carritoActual));
						} else {
							System.out.println("*** DEBE INGRESAR AL SISTEMA PRIMERO ***:");
						}
						break;
					}
					case "7":{
						if (validado) {
							System.out.println("   Procesando factura ...");
							System.out.println(pali.facturar(carritoActual));
						} else {
							System.out.println("*** DEBE INGRESAR AL SISTEMA PRIMERO ***:");
						}
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
