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

    public String   getCodigo() {
        return codigo;
    }
    public void     setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String   getDescripcion() {
        return descripcion;
    }
    public void     setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double   getPrecio() {
        return precio;
    }
    public void     setPrecio(double precio) {
        this.precio = precio;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void     setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void agregarServicio(ArrayList<Servicio> listaServicios,ArrayList<Empleado> listaEmpleados){
        Scanner  teclado  = new Scanner(System.in).useDelimiter("\n");
        Servicio servicio = new Servicio();
        Empleado empleado = new Empleado();
        String   codigo;

        do {
            System.out.print("Ingrese el Codigo del Servicio: ");
            codigo = teclado.next();
            if (validarCodigo(listaServicios,codigo))
                System.out.println("Codigo de Servicio ya existe! ");

        }while(validarCodigo(listaServicios,codigo));
        servicio.setCodigo(codigo);
        System.out.print("Escriba una Descripcion del servicio: ");
        servicio.setDescripcion(teclado.next());
        System.out.print("Ingrese el Precio del Servicio: ");
        servicio.setPrecio(teclado.nextDouble());
        System.out.println("Empleados: ");
        empleado.visualizarEmpleados(listaEmpleados);
        //validar empleado
        do {
            System.out.print("Ingrese el Codigo del Empleado: ");
            codigo = teclado.next();
            for (Empleado item: listaEmpleados) {
                if (codigo.equals(item.getCodigo())) {
                    servicio.setEmpleado(item);
                }
            }
            if (!empleado.validarCodigo(listaEmpleados,codigo)) {
                System.out.println("Digite un codigo valido!");
            }
        }while (!empleado.validarCodigo(listaEmpleados,codigo));

        listaServicios.add(servicio);
        System.out.println("--Servicio Agregado--");
    }
    public boolean validarCodigo(ArrayList<Servicio> listaServicios,String codigo){
        boolean condicion = false;
        for (Servicio servicios: listaServicios){
            if(codigo.equals(servicios.getCodigo())){
                condicion = true;
            }
        }
        return condicion;
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