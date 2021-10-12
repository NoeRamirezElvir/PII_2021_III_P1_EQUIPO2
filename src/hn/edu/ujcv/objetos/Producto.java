package hn.edu.ujcv.objetos;


import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int    stock;

    public Producto(){
    }
    public Producto(String pCodigo,String pNombre,double pPrecio,int pStock){
        this.codigo = pCodigo;
        this.nombre = pNombre;
        this.precio = pPrecio;
        this.stock  = pStock;
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
    public double getPrecio() {
        return precio;
    }
    public void   setPrecio(double precio) {
        this.precio = precio;
    }
    public int    getStock() {
        return stock;
    }
    public void   setStock(int stock) {
        this.stock = stock;
    }

    public void agregarProducto(ArrayList<Producto> listaProductos){
        Scanner  teclado  = new Scanner(System.in).useDelimiter("\n");
        Producto producto = new Producto();
        String   codigo;
        do{
            System.out.print("Ingrese el Codigo del Producto: ");
            codigo = teclado.next();

            if (validarCodigo(listaProductos, codigo))
                System.out.println("Codigo de Producto ya Existe!");

        }while(validarCodigo(listaProductos, codigo));
        producto.setCodigo(codigo);
        System.out.print("Ingrese el Nombre del Producto: ");
        producto.setNombre(teclado.next());
        System.out.print("Ingrese el precio del producto: ");
        producto.setPrecio(teclado.nextDouble());
        System.out.print("Ingrese el stock del producto: ");
        producto.setStock(teclado.nextInt());
        listaProductos.add(producto);
        System.out.println("--Producto Agregado--");
    }

    public boolean validarCodigo(ArrayList<Producto> listaProductos, String codigo){
        boolean condicion = false;
        for (Producto item : listaProductos) {
            if (codigo.equals(item.getCodigo())) {
                condicion=true;
            }
        }
        return condicion;
    }

    public void visualizarProductos(ArrayList<Producto> listaProductos){
        //System.out.println("Codigo " + " Nombre " + " Precio " + " Stock");
        for (Producto item: listaProductos){
            System.out.println("» " + item.getCodigo() +
                    "  " + item.getNombre() +
                    "  " + item.getPrecio() +
                    "  " + item.getStock());
        }
    }

    public void buscarProducto(ArrayList<Producto> listaProductos){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        String  codigo,codigoLista,nombre;
        double  precio;
        int     stock;
        System.out.print("Ingrese el codigo del producto a buscar: ");
        codigo = teclado.next();
        for (Producto listaProducto : listaProductos) {
            if(codigo.equals(listaProducto.getCodigo())) {
                codigoLista = listaProducto.getCodigo();
                nombre = listaProducto.getNombre();
                precio = listaProducto.getPrecio();
                stock = listaProducto.getStock();
                System.out.println("·" + codigoLista + " " + nombre + " " + precio + " " + stock);
            }
        }
    }



}
