package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Factura2 {
    private int      numFactura;
    private String   fecha;
    private Cliente  cliente;
    private Empleado empleado;
    private double   subTotal;
    private double   ISV;
    private double   descuento;
    private double   totalPagar;
    private ArrayList<Detalle2> listaDetalles;
    //private Detalle  detalle;

    public Factura2(){
    }
    public Factura2(int numFactura,String fecha,Cliente cliente,Empleado empleado,double subTotal,double isv,double descuento,
                    double totalPagar,ArrayList<Detalle2> listaDetalles){
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.subTotal = subTotal;
        this.ISV = isv;
        this.descuento = descuento;
        this.totalPagar = totalPagar;
        this.listaDetalles = listaDetalles;
    }

    public int getNumFactura() {
        return numFactura;
    }
    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public double getISV() {
        return ISV;
    }
    public void setISV(double ISV) {
        this.ISV = ISV;
    }
    public double getDescuento() {
        return descuento;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    public double getTotalPagar() {
        return totalPagar;
    }
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    public ArrayList<Detalle2> getListaDetalles() {
        return listaDetalles;
    }
    public void setListaDetalles(ArrayList<Detalle2> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }


    public void agregarFactura(ArrayList<Factura2> listaFacturas, ArrayList<Empleado> listaEmpleados, ArrayList<Cliente> listaClientes,
                               ArrayList<Producto> listaProductos, ArrayList<Servicio> listaServicios){
        Scanner  teclado  = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Detalle2> detalles = new ArrayList<>();
        Detalle2 detalle  = new Detalle2();
        Factura2  factura  = new Factura2();
        Cliente  cliente  = new Cliente();
        Empleado empleado = new Empleado();
        int numFactura;
        double   subTotal = 0,isv,descuento,total, totalP;

        //
        do{
            System.out.print("Ingrese el numero de factura: ");
            numFactura = teclado.nextInt();
           //validarNumero(listaFacturas,numFactura);
        }while((validarNumero(listaFacturas,numFactura)) > 0);
        factura.setNumFactura(numFactura);
        System.out.print("Escriba la fecha de ingreso (dd/mm/yyyy): ");
        factura.setFecha(teclado.next());
        System.out.println(" - Lista de Clientes - ");
        cliente.visualizarClientes(listaClientes);
        System.out.print("Ingrese el cliente,");
        factura.setCliente(cliente.buscarCliente1(listaClientes));
        System.out.println(" - Lista de Empleados -");
        empleado.visualizarEmpleados(listaEmpleados);
        System.out.print("Ingrese el empleado,");
        factura.setEmpleado(empleado.buscarEmpleado1(listaEmpleados));
        //
        System.out.println(" - Detalles - ");
        factura.setListaDetalles(detalle.agregarDetalle(detalles,listaProductos,listaServicios));
        for (Detalle2 det: detalles) {
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


    }
    public int validarNumero(ArrayList<Factura2> listaFactura, int numeroFactura){
        int contador = 0;
        for (Factura2 facturas: listaFactura) {
            if (numeroFactura == (facturas.getNumFactura())){
                contador++;
            }
        }
        return contador;
    }

    public void visualizarFactura(ArrayList<Factura2> listaFactura){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        do {
            ArrayList<Detalle2> detalles;
            int num, i = 1;
            System.out.print("Ingrese el numero de la factura: ");
            num = teclado.nextInt();
            for (Factura2 factura : listaFactura) {
                if (num == factura.getNumFactura()) {
                    System.out.println("\n            Factura #" + factura.getNumFactura());
                    System.out.println("                                         " + factura.getFecha());
                    System.out.println("Cliente: " + factura.getCliente().getNombre() + "    Empleado: " + factura.getEmpleado().getNombre());
                    System.out.println(" ");
                    System.out.println("_____________________________ Detalles ______________________________________");
                    System.out.println("N.            Nombre         Cantidad             Precio");
                    detalles = factura.getListaDetalles();
                    for (Detalle2 item : detalles) {
                        System.out.println(i + "            " + item.getNombreDetalle() + "             " + item.getCantidadDetalle() + "              " + item.getPrecioDetalle());
                        i++;
                    }
                    System.out.println("_____________________________________________________________________________");
                    System.out.println("                                      Subtotal: " + factura.getSubTotal());
                    System.out.println("                                           ISV: " + factura.getISV());
                    System.out.println("                                     Descuento: " + factura.getDescuento());
                    System.out.println("                                         Total: " + factura.getTotalPagar());

                }
            }


            System.out.print("Imprimir otra factura S/N: ");
        }while(teclado.next().equalsIgnoreCase("S"));
    }



}
