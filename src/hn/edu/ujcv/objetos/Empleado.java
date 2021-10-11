package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
    private String codigo;
    private String nombre;
    private String fechaIngreso;
    private String puesto;

    public Empleado(){
    }
    public Empleado(String pCodigo,String pNombre,String pFechaIngreso,String pPuesto){
        this.codigo       = pCodigo;
        this.nombre       = pNombre;
        this.fechaIngreso = pFechaIngreso;
        this.puesto       = pPuesto;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void agregarEmpleado(ArrayList<Empleado> listaEmpleados){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Empleado empleado = new Empleado();
        String codigo,nombre,fecha,puesto;
        int contador;
        do {
            System.out.print("Ingrese el codigo de empleado: ");
            codigo = teclado.next();
            contador = validarCodigo(listaEmpleados,codigo);
        }while(contador>0);
        empleado.setCodigo(codigo);
        System.out.print("Ingrese el nombre del empleado: ");
        nombre = teclado.next();
        empleado.setNombre(nombre);
        System.out.print("Escriba la fecha de ingreso (dd/mm/yyyy): ");
        fecha = teclado.next();
        empleado.setFechaIngreso(fecha);
        System.out.print("Ingrese el puesto del empleado: ");
        puesto = teclado.next();
        empleado.setPuesto(puesto);
        listaEmpleados.add(empleado);
    }
    public int validarCodigo(ArrayList<Empleado> listaEmpleados,String codigo){
        int contador = 0;
        for (Empleado empleado: listaEmpleados) {
            if(codigo.equals(empleado.getCodigo())){
                contador++;
            }
        }
        return contador;
    }
    public void visualizarEmpleados(ArrayList<Empleado> listaEmpleados){
        for (Empleado empleados: listaEmpleados) {
            System.out.println("» " + empleados.getCodigo() +
                    "  " + empleados.getNombre() +
                    "  " + empleados.getFechaIngreso() +
                    "  " + empleados.getPuesto());
        }
    }

    public Empleado buscarEmpleado1(ArrayList<Empleado> listaEmpleados){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Empleado empleado = new Empleado();
        String codigo;
        System.out.print(" ingrese el codigo del empleado: ");
        codigo = teclado.next();
        for (Empleado empleados: listaEmpleados) {
            if (codigo.equals(empleados.getCodigo())){
               empleado = empleados;
            }
        }
        return empleado;
    }
}
