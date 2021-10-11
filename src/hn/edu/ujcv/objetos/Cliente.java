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

    public long getIdentidad() {
        return identidad;
    }
    public void setIdentidad(long identidad) {
        this.identidad = identidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public void agregarCliente(ArrayList<Cliente> listaClientes){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Cliente cliente = new Cliente();
        String nombre,fecha,categoria;
        int contador;
        long identidad;
        do{
            System.out.print("Ingrese el numero de identidad del cliente: ");
            identidad = teclado.nextLong();
            contador = validarIdentidad(listaClientes,identidad);
        }while(contador > 0);
        cliente.setIdentidad(identidad);
        System.out.print("Ingrese el nombre del cliente: ");
        nombre = teclado.next();
        cliente.setNombre(nombre);
        System.out.print("Escriba la fecha de ingreso (dd/mm/yyyy): ");
        fecha = teclado.next();
        cliente.setFechaIngreso(fecha);
        System.out.print("Ingrese la categoria del cliente: ");
        categoria = teclado.next();
        cliente.setCategoria(categoria);
        listaClientes.add(cliente);
    }
    public int validarIdentidad(ArrayList<Cliente> listaClientes,long identidad){
        int contador = 0;
        for (Cliente cliente: listaClientes) {
            if(identidad==cliente.getIdentidad()){
                contador++;
            }
        }
        return contador;
    }
    public void visualizarClientes(ArrayList<Cliente> listaClientes){
        for (Cliente clientes: listaClientes) {
            System.out.println("» 0" + clientes.getIdentidad() +
                    "  " + clientes.getNombre() +
                    "  " + clientes.getFechaIngreso() +
                    "  " + clientes.getCategoria());
        }
    }

    public Cliente buscarCliente1(ArrayList<Cliente> listaClientes){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        long    identidad;
        Cliente cliente = new Cliente();
        System.out.print(" ingrese el Numero de identidad: ");
        identidad = teclado.nextLong();
        for (Cliente clientes: listaClientes) {
            if(identidad == clientes.getIdentidad()) {
                cliente = clientes;
            }
        }
        return cliente;
    }




}
