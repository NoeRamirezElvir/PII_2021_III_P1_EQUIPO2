package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Detalle2 {
    private String codigoDetalle;
    private String nombreDetalle;
    private double precioDetalle;
    private double subTotal;
    private TipoDetalle tipoDetalle;
    private int numDetalle;
    private int cantidadDetalle;

    public Detalle2(){
    }
    public Detalle2(String pCodigoDetalle,String pNombreDetalle,double pPrecioDetalle,double pSubtotal,TipoDetalle pTipoDetalle,
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
    public void setTipoDetalle(TipoDetalle tipoDetalle) {
        this.tipoDetalle = tipoDetalle;
    }
    public int getNumDetalle() {
        return numDetalle;
    }
    public void setNumDetalle(int numDetalle) {
        this.numDetalle = numDetalle;
    }
    public String getCodigoDetalle() {
        return codigoDetalle;
    }
    public void setCodigoDetalle(String codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }
    public String getNombreDetalle() {
        return nombreDetalle;
    }
    public void setNombreDetalle(String nombreDetalle) {
        this.nombreDetalle = nombreDetalle;
    }
    public double getPrecioDetalle() {
        return precioDetalle;
    }
    public void setPrecioDetalle(double precioDetalle) {
        this.precioDetalle = precioDetalle;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public int getCantidadDetalle() {
        return cantidadDetalle;
    }
    public void setCantidadDetalle(int cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }



    public ArrayList<Detalle2> agregarDetalle(ArrayList<Detalle2> listaDetalles, ArrayList<Producto> listaProductos, ArrayList<Servicio> listaServicios){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Producto producto = new Producto();
        Servicio servicio = new Servicio();
        int tDetalle, contador = 1;
        String respuesta;
        do{
            Detalle2 detalle = new Detalle2();
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
                System.out.print("Ingrese el codigo del producto: ");
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
                    }
                }
                //
            } else if (tDetalle == 2) {
                String codigo;
                double precio;
                int cantidad;
                System.out.println(" - Lista de Servicios - ");
                servicio.visualizarServicios(listaServicios);
                //
                detalle.setTipoDetalle(TipoDetalle.SERVICIO);
                System.out.print("Ingrese el codigo del servicio: ");
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
                    }
                }
                //
            } else {
                System.out.println("Opcion invalida.");
            }


            System.out.print("Agregar otro detalle S/N: ");
            respuesta = teclado.next();
            contador++;
        }while(respuesta.equalsIgnoreCase("S"));


        return listaDetalles;
    }







}
