package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Servicio {
    private String   codigo;
    private String   descripcion;
    private double   precio;
    private Empleado empleado;


    public Servicio() {
    }
    public Servicio(String pCodigo,String pDescripcion,double pPrecio,Empleado pEmpleado){
        this.codigo      = pCodigo;
        this.descripcion = pDescripcion;
        this.precio      = pPrecio;
        this.empleado    = pEmpleado;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void agregarServicio(ArrayList<Servicio> listaServicios,ArrayList<Empleado> listaEmpleados){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Servicio servicio = new Servicio();
        Empleado empleado = new Empleado();
        String codigo,descripcion;
        double precio;
        int contador;
        do {
            System.out.print("Ingrese el codigo del servicio: ");
            codigo = teclado.next();
            contador = validarCodigo(listaServicios,codigo);
        }while(contador>0);
        servicio.setCodigo(codigo);
        System.out.print("Escriba una descripcion del servicio: ");
        descripcion = teclado.next();
        servicio.setDescripcion(descripcion);
        System.out.print("Ingrese el precio del servicio: ");
        precio = teclado.nextDouble();
        servicio.setPrecio(precio);
        System.out.println("\n");
        empleado.visualizarEmpleados(listaEmpleados);
        System.out.print("Ingrese el codigo del empleado: ");
        codigo = teclado.next();
        for (Empleado empleados: listaEmpleados) {
            if (codigo.equals(empleados.getCodigo())){
                servicio.setEmpleado(empleados);
            }
        }
        listaServicios.add(servicio);
    }
    public int validarCodigo(ArrayList<Servicio> listaServicios,String codigo){
        int contador = 0;
        for (Servicio servicios: listaServicios){
            if(codigo.equals(servicios.getCodigo())){
                contador++;
            }
        }
        return contador;
    }
    public void visualizarServicios(ArrayList<Servicio> listaServicios){
        for (Servicio servicios: listaServicios) {
            System.out.println("» " + servicios.getCodigo() +
                    "  " + servicios.getDescripcion() +
                    "  " + servicios.getPrecio() +
                    "  " + servicios.getEmpleado().getNombre());
        }
    }

}