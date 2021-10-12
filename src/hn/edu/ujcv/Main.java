package hn.edu.ujcv;

import hn.edu.ujcv.objetos.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        String  respuesta;
        int     opcion;
        //Instancias
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente>  listaClientes  = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        ArrayList<Factura>  listaFacturas  = new ArrayList<>();

        Producto producto = new Producto();
        Cliente  cliente  = new Cliente();
        Empleado empleado = new Empleado();
        Servicio servicio = new Servicio();
        Factura  factura  = new Factura();
        try{
            System.out.println("                    - Menu - ");
            do {
                System.out.print("1 - Agregar Productos. ");
                System.out.println("  4 - Agregar Servicios. ");
                System.out.print("2 - Agregar clientes. ");
                System.out.println("   5 - Agregar Facturas. ");
                System.out.print("3 - Agregar Empleados. ");
                System.out.println("  6 - Visualizar Factura. ");
                System.out.print("Seleccione una opcion.\n" + " > ");
                opcion = teclado.nextInt();
                switch(opcion){
                    case 1:
                        //Agregar productos
                            producto.agregarProducto(listaProductos);
                        break;
                    case 2:
                        //Agregar cliente
                            cliente.agregarCliente(listaClientes);
                        break;
                    case 3:
                        //Agregar empleado
                            empleado.agregarEmpleado(listaEmpleados);
                        break;
                    case 4:
                        //Agregar servicio
                            servicio.agregarServicio(listaServicios,listaEmpleados);
                        break;
                    case 5:
                        //Agregar factura
                        factura.agregarFactura(listaFacturas,listaEmpleados,listaClientes,listaProductos,listaServicios);
                        break;
                    case 6:
                        //visualizar factura
                        factura.visualizarFactura(listaFacturas);
                        break;
                    default:
                        System.out.println("Opcion invalida!");
                        break;
                }
                System.out.print("Desea continuar S/N: ");
                respuesta = teclado.next();
            }while(respuesta.equalsIgnoreCase("s"));

        }catch(Exception e){
            System.err.println("Error " + e.getMessage());
        }
    }
}
