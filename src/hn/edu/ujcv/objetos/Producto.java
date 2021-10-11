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
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void agregarProducto(ArrayList<Producto> listaProductos){
        Producto producto = new Producto();
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        String  codigo,nombre;
        double  precio;
        int     stock,contador;
        do{
            System.out.print("Ingrese el codigo del producto: ");
            codigo = teclado.next();
            contador = validarCodigo(listaProductos, codigo);
            //System.out.println(contador);
        }while(contador > 0);
        producto.setCodigo(codigo);
        System.out.print("Ingrese el nombre del producto: ");
        nombre = teclado.next();
        producto.setNombre(nombre);
        System.out.print("Ingrese el precio del producto: ");
        precio = teclado.nextDouble();
        producto.setPrecio(precio);
        System.out.print("Ingrese el stock del producto: ");
        stock = teclado.nextInt();
        producto.setStock(stock);
        listaProductos.add(producto);
    }

    public int validarCodigo(ArrayList<Producto> listaProductos, String codigo){
        int contador = 0;
        for (Producto listaProducto : listaProductos) {
            if (codigo.equals(listaProducto.getCodigo())) {
                contador++;
            }
        }
        return contador;
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
