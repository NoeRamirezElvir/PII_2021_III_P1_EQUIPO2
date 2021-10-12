package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private long   identidad;
    private String nombre;
    private String fechaIngreso;
    private String categoria;

    public Cliente(){
    }
    public Cliente(long pIdentidad,String pNombre,String pFechaIngreso,String pCategoria){
        this.identidad    = pIdentidad;
        this.nombre       = pNombre;
        this.fechaIngreso = pFechaIngreso;
        this.categoria    = pCategoria;
    }

    public long   getIdentidad() {
        return identidad;
    }
    public void   setIdentidad(long identidad) {
        this.identidad = identidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void   setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaIngreso() {
        return fechaIngreso;
    }
    public void   setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getCategoria() {
        return categoria;
    }
    public void   setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public void agregarCliente(ArrayList<Cliente> listaClientes){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Cliente cliente = new Cliente();
        long identidad;

        do{
            System.out.print("Ingrese el numero de Identidad del Cliente: ");
            identidad = teclado.nextLong();
            if (validarIdentidad(listaClientes,identidad))
                System.out.println("No. Identidad Invalido, ya registrado!");
        }while( validarIdentidad(listaClientes,identidad));

        cliente.setIdentidad(identidad);
        System.out.print("Ingrese el Nombre del Cliente: ");
        cliente.setNombre( teclado.next());
        System.out.print("Escriba la Fecha de Ingreso (dd/mm/yyyy): ");
        cliente.setFechaIngreso(teclado.next());
        System.out.print("Ingrese la Categoria del Cliente: ");
        cliente.setCategoria(teclado.next());
        listaClientes.add(cliente);
        System.out.println("--Cliente Agregado--");
    }

    public boolean validarIdentidad(ArrayList<Cliente> listaClientes,long identidad){
        boolean condicion = false;
        for (Cliente item: listaClientes) {
            if(identidad==item.getIdentidad()){
                condicion=true;
            }
        }
        return condicion;
    }
    public void visualizarClientes(ArrayList<Cliente> listaClientes){
        for (Cliente clientes: listaClientes) {
            System.out.println("» 0" + clientes.getIdentidad() +
                    "  " + clientes.getNombre() +
                    "  " + clientes.getFechaIngreso() +
                    "  " + clientes.getCategoria());
        }
    }

    public Cliente buscarCliente(ArrayList<Cliente> listaClientes){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        long    identidad;
        Cliente cliente = new Cliente();
        do {
            System.out.print(" Ingrese el Numero de Identidad: ");
            identidad = teclado.nextLong();
            for (Cliente clientes: listaClientes) {
                if(identidad == clientes.getIdentidad()) {
                    cliente = clientes;
                }
            }
            if (!cliente.validarIdentidad(listaClientes, identidad))
                System.out.println("Digite un codigo valido!");

        }while (!cliente.validarIdentidad(listaClientes,identidad));
        return cliente;
    }

}
