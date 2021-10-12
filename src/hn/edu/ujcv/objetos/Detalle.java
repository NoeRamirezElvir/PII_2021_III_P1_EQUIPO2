package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Detalle {
    private int         numDetalle;
    private TipoDetalle tipoDetalle;
    private String      codigoDetalle;
    private String      nombreDetalle;
    private double      precioDetalle;
    private int         cantidadDetalle;
    private double      subTotal;

    public Detalle(){
    }

    public Detalle(String pCodigoDetalle,String pNombreDetalle,double pPrecioDetalle,double pSubtotal,TipoDetalle pTipoDetalle,
                   int pNumDetalle, int pCantidadDetalle){
        this.codigoDetalle   = pCodigoDetalle;
        this.nombreDetalle   = pNombreDetalle;
        this.precioDetalle   = pPrecioDetalle;
        this.subTotal        = pSubtotal;
        this.tipoDetalle     = pTipoDetalle;
        this.numDetalle      = pNumDetalle;
        this.cantidadDetalle = pCantidadDetalle;
    }

    public TipoDetalle getTipoDetalle() {
        return tipoDetalle;
    }
    public void   setTipoDetalle(TipoDetalle tipoDetalle) {
        this.tipoDetalle = tipoDetalle;
    }
    public int    getNumDetalle() {
        return numDetalle;
    }
    public void   setNumDetalle(int numDetalle) {
        this.numDetalle = numDetalle;
    }
    public String getCodigoDetalle() {
        return codigoDetalle;
    }
    public void   setCodigoDetalle(String codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }
    public String getNombreDetalle() {
        return nombreDetalle;
    }
    public void   setNombreDetalle(String nombreDetalle) {
        this.nombreDetalle = nombreDetalle;
    }
    public double getPrecioDetalle() {
        return precioDetalle;
    }
    public void   setPrecioDetalle(double precioDetalle) {
        this.precioDetalle = precioDetalle;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void   setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public int    getCantidadDetalle() {
        return cantidadDetalle;
    }
    public void   setCantidadDetalle(int cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }



    public ArrayList<Detalle> agregarDetalle(ArrayList<Detalle> listaDetalles, ArrayList<Producto> listaProductos, ArrayList<Servicio> listaServicios){
        Scanner  teclado  = new Scanner(System.in).useDelimiter("\n");
        Producto producto = new Producto();
        Servicio servicio = new Servicio();

        int tDetalle, contador = 1;
        String respuesta;
        do{
            Detalle detalle = new Detalle();
            detalle.setNumDetalle(contador);
            System.out.println("   - Tipo de detalle - ");
            System.out.println("1) Producto   2)Servicio ");
            tDetalle = teclado.nextInt();
            if (tDetalle == 1) {
                String codigo;
                double precio;
                int cantidad;
                System.out.println(" - Lista de Productos - ");
                producto.visualizarProductos(listaProductos);
                //
                detalle.setTipoDetalle(TipoDetalle.PRODUCTO);
                do {
                    System.out.print("Ingrese el Codigo del Producto: ");
                    codigo = teclado.next();
                    for (Producto productos: listaProductos) {
                        if (codigo.equals(productos.getCodigo())){
                            detalle.setCodigoDetalle(productos.getCodigo());
                            detalle.setNombreDetalle(productos.getNombre());
                            precio = productos.getPrecio();
                            detalle.setPrecioDetalle(precio);
                            System.out.print("Ingrese la cantidad: ");
                            cantidad = teclado.nextInt();
                            detalle.setCantidadDetalle(cantidad);
                            detalle.setSubTotal(precio*cantidad);
                            listaDetalles.add(detalle);
                            System.out.println("--Detalle Agregado--");
                        }
                    }
                    if (!producto.validarCodigo(listaProductos,codigo))
                        System.out.println("Escriba un codigo Valido");
                }while (!producto.validarCodigo(listaProductos,codigo));
                contador++;
                //
            } else if (tDetalle == 2) {
                String codigo;
                double precio;
                int cantidad;
                System.out.println(" - Lista de Servicios - ");
                servicio.visualizarServicios(listaServicios);
                //
                detalle.setTipoDetalle(TipoDetalle.SERVICIO);
                do {
                    System.out.print("Ingrese el Codigo del Servicio: ");
                    codigo = teclado.next();
                    for (Servicio servicios: listaServicios) {
                        if (codigo.equals(servicios.getCodigo())){
                            detalle.setCodigoDetalle(servicios.getCodigo());
                            detalle.setNombreDetalle(servicios.getDescripcion());
                            precio = servicios.getPrecio();
                            detalle.setPrecioDetalle(precio);
                            System.out.print("Ingrese la cantidad: ");
                            cantidad = teclado.nextInt();
                            detalle.setCantidadDetalle(cantidad);
                            detalle.setSubTotal(precio*cantidad);
                            listaDetalles.add(detalle);
                            System.out.println("--Detalle Agregado--");
                        }
                    }
                    if (!servicio.validarCodigo(listaServicios,codigo))
                        System.out.println("Escriba un codigo Valido");
                }while (!servicio.validarCodigo(listaServicios,codigo));
                contador++;
                //
            } else {
                System.out.println("Opcion invalida.");
            }
            System.out.print("Agregar otro detalle S/N: ");
            respuesta = teclado.next();
        }while(respuesta.equalsIgnoreCase("S"));

        return listaDetalles;
    }







}
