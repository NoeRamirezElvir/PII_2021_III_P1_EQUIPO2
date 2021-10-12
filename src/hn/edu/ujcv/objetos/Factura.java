package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Factura {
    private int      numFactura;
    private String   fecha;
    private Cliente  cliente;
    private Empleado empleado;
    private double   subTotal;
    private double   ISV;
    private double   descuento;
    private double   totalPagar;
    private ArrayList<Detalle> listaDetalles;

    public Factura(){
    }
    public Factura(int numFactura, String fecha, Cliente cliente, Empleado empleado, double subTotal, double isv, double descuento,
                   double totalPagar, ArrayList<Detalle> listaDetalles){
        this.numFactura    = numFactura;
        this.fecha         = fecha;
        this.cliente       = cliente;
        this.empleado      = empleado;
        this.subTotal      = subTotal;
        this.ISV           = isv;
        this.descuento     = descuento;
        this.totalPagar    = totalPagar;
        this.listaDetalles = listaDetalles;
    }

    public int      getNumFactura() {
        return numFactura;
    }
    public void     setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
    public String   getFecha() {
        return fecha;
    }
    public void     setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Cliente  getCliente() {
        return cliente;
    }
    public void     setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void     setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public double   getSubTotal() {
        return subTotal;
    }
    public void     setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public double   getISV() {
        return ISV;
    }
    public void     setISV(double ISV) {
        this.ISV = ISV;
    }
    public double   getDescuento() {
        return descuento;
    }
    public void     setDescuento(double descuento) {
        this.descuento = descuento;
    }
    public double   getTotalPagar() {
        return totalPagar;
    }
    public void     setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    public ArrayList<Detalle> getListaDetalles() {
        return listaDetalles;
    }
    public void     setListaDetalles(ArrayList<Detalle> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }


    public void agregarFactura(ArrayList<Factura> listaFacturas, ArrayList<Empleado> listaEmpleados, ArrayList<Cliente> listaClientes,
                               ArrayList<Producto> listaProductos, ArrayList<Servicio> listaServicios){

        Scanner  teclado  = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Detalle> detalles = new ArrayList<>();
        Detalle  detalle  = new Detalle();
        Factura  factura  = new Factura();
        Cliente  cliente  = new Cliente();
        Empleado empleado = new Empleado();

        int numFactura;
        double   subTotal = 0,isv,descuento,total, totalP;

        do{
            System.out.print("Ingrese el Numero de Factura: ");
            numFactura = teclado.nextInt();

           if (validarNumero(listaFacturas,numFactura))
               System.out.println("No. Factura en uso!");

        }while((validarNumero(listaFacturas,numFactura)));
        factura.setNumFactura(numFactura);
        System.out.print("Escriba la Fecha de Ingreso (dd/mm/yyyy): ");
        factura.setFecha(teclado.next());
        System.out.println(" - Lista de Clientes - ");
        cliente.visualizarClientes(listaClientes);
        System.out.print("Ingrese el cliente,");
        factura.setCliente(cliente.buscarCliente(listaClientes));
        System.out.println(" - Lista de Empleados -");
        empleado.visualizarEmpleados(listaEmpleados);
        System.out.print("Ingrese el empleado,");
        factura.setEmpleado(empleado.buscarEmpleado(listaEmpleados));
        //
        System.out.println("Detalles: ");
        factura.setListaDetalles(detalle.agregarDetalle(detalles,listaProductos,listaServicios));
        for (Detalle det: detalles) {
            subTotal += det.getSubTotal();
        }
        factura.setSubTotal(subTotal);
        System.out.println("Subtotal: " + subTotal);
        System.out.print("Ingrese el ISV: ");
        isv = teclado.nextDouble();
        factura.setISV(subTotal*isv);
        System.out.print("Ingrese el descuento: ");
        descuento = teclado.nextDouble();
        factura.setDescuento(subTotal*descuento);
        total = subTotal - (subTotal*descuento);
        totalP = total + (total*isv);
        System.out.println("Total a pagar: " + totalP);
        factura.setTotalPagar(totalP);
        //
       listaFacturas.add(factura);
        System.out.println("--Factura Agregada--");
    }
    public boolean validarNumero(ArrayList<Factura> listaFactura, int numeroFactura){
        boolean condicion = false;
        for (Factura facturas: listaFactura) {
            if (numeroFactura == (facturas.getNumFactura())){
                condicion = true;
            }
        }
        return condicion;
    }

    public void visualizarFactura(ArrayList<Factura> listaFactura){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        do {
            ArrayList<Detalle> detalles;
            int num;
            do {
                System.out.print("Ingrese el numero de la factura: ");
                num = teclado.nextInt();
                if (!validarNumero(listaFactura,num))
                System.out.println("Numero invalido!");
            }while (!validarNumero(listaFactura,num));

            for (Factura factura : listaFactura) {
                if (num == factura.getNumFactura()) {
                    System.out.println("\n            Factura #" + factura.getNumFactura());
                    System.out.println("                                         " + factura.getFecha());
                    System.out.println("Cliente: " + factura.getCliente().getNombre() + "    Empleado: " + factura.getEmpleado().getNombre());
                    System.out.println(" ");
                    System.out.println("__________________________ Detalles _____________________");
                    System.out.println("N.   Nombre          Cantidad             Precio");
                    detalles = factura.getListaDetalles();
                    for (Detalle item : detalles) {
                        System.out.println(item.getNumDetalle() + "    " + item.getNombreDetalle() + "        " + item.getCantidadDetalle() + "               " + item.getPrecioDetalle());
                    }
                    System.out.println("_________________________________________________________");
                    System.out.println("Subtotal:                                      " + factura.getSubTotal());
                    System.out.println("ISV:                                           " + factura.getISV());
                    System.out.println("Descuento:                                     " + factura.getDescuento());
                    System.out.println("Total:                                         " + factura.getTotalPagar());

                }
            }

            System.out.print("Imprimir otra factura S/N: ");
        }while(teclado.next().equalsIgnoreCase("S"));
    }

}
