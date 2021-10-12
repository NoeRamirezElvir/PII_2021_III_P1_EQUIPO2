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
    public void   setCodigo(String codigo) {
        this.codigo = codigo;
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
    public String getPuesto() {
        return puesto;
    }
    public void   setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void agregarEmpleado(ArrayList<Empleado> listaEmpleados){
        Scanner  teclado  = new Scanner(System.in).useDelimiter("\n");
        Empleado empleado = new Empleado();
        String codigo;
        do {
            System.out.print("Ingrese el Codigo del Empleado: ");
            codigo = teclado.next();

            if (validarCodigo(listaEmpleados,codigo))
                System.out.println("Codigo de Empleado ya Existe!");

        }while(validarCodigo(listaEmpleados,codigo));
        empleado.setCodigo(codigo);
        System.out.print("Ingrese el Nombre del Empleado: ");
        empleado.setNombre(teclado.next());
        System.out.print("Escriba la Fecha de Ingreso (dd/mm/yyyy): ");
        empleado.setFechaIngreso(teclado.next());
        System.out.print("Ingrese el Puesto del Empleado: ");
        empleado.setPuesto(teclado.next());
        listaEmpleados.add(empleado);
        System.out.println("--Empleado Agregado--");
    }
    public boolean validarCodigo(ArrayList<Empleado> listaEmpleados,String codigo){
        boolean condicion = false;
        for (Empleado empleado: listaEmpleados) {
            if(codigo.equals(empleado.getCodigo())){
                condicion=true;
            }
        }
        return condicion;
    }
    public void visualizarEmpleados(ArrayList<Empleado> listaEmpleados){
        for (Empleado empleados: listaEmpleados) {
            System.out.println("» " + empleados.getCodigo() +
                    "  " + empleados.getNombre() +
                    "  " + empleados.getFechaIngreso() +
                    "  " + empleados.getPuesto());
        }
    }

    public Empleado buscarEmpleado(ArrayList<Empleado> listaEmpleados) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Empleado empleado = new Empleado();
        String codigo;
        do {
            System.out.print(" Ingrese el codigo del empleado: ");
            codigo = teclado.next();
            for (Empleado empleados : listaEmpleados) {
                if (codigo.equals(empleados.getCodigo())) {
                    empleado = empleados;
                }
            }
            if (!empleado.validarCodigo(listaEmpleados, codigo))

                System.out.println("Digite un codigo valido!");
        }while (!empleado.validarCodigo(listaEmpleados, codigo)) ;
            return empleado;
    }
}

