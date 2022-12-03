package presentacion;

import entidades.*;
import entidades.Concesionario.*;
import java.util.*;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static int menu() {
        String opcionesMenu = """
                            ========== MENU DE FUNCIONES ==========
                            1. Registrar empleados
                            2. Registrar automoviles
                            3.
                            4.
                            5. Listar los datos de las ventas totales por cada vendedor, asi como el monto del porcentaje que les corresponde;
                            6.
                            7. Salir
                            \tDigite una opcion [1 - 7]:""";
        int opcion;
        do{
          System.out.print("\n\n\tMenu principal\n\n" + opcionesMenu);
          opcion = sc.nextInt();
        } while(opcion<1 || opcion>7);
        sc.nextLine();
        return opcion;
    }
  
  public static void main(String[] args) {
    // Declarando e inicializando gerente
    Gerente gerenteGian = new Gerente("a", "Gian", "Samana", new Fecha(2005,1,18),"IngSistemas", 5000);
    
    Concesionario concesionario = new Concesionario("Matel", gerenteGian);
        
    // Declarando e inicializando vendedor
    Vendedor vendedor = new Vendedor("b", "Lucero", "Samana", new Fecha(2007,9,17), new Fecha(2017, 9, 17), 5);
    concesionario.setVendedor(vendedor);
    
    // Declarando e inicializando cliente
    Cliente cliente = new Cliente("d", "Pedro", "Ramirez", "Ciro Alegria", "949547447");
    
    // Declarando e inicializando automovil
    Automovil automovilA = concesionario.new Automovil("c", "Toyota", "xyz", 2005, "Toyota", 20000);
    
    Automovil automovilB = concesionario.new Automovil("autoB", "Nissan", "abc", 2007, "Nissan", 70000);
    
    // Declarando e inicializando boletaVenta
    BoletaVenta boletaVenta = concesionario.new BoletaVenta(new Fecha(2022, 12, 2), vendedor, cliente, automovilA, false);
    concesionario.setBoletaVenta(boletaVenta);
    
    BoletaVenta boletaVenta2 = concesionario.new BoletaVenta(new Fecha(2022, 12, 3), vendedor, cliente, automovilB, false);
    concesionario.setBoletaVenta(boletaVenta2);
    
    System.out.println(concesionario.getMontoTotalVentas());
    System.out.println(concesionario.getBoletaVenta(0));
    System.out.println(concesionario.getBoletaVenta(1));
    System.out.println(concesionario.getMontoVentasSegunVendedor(vendedor));
    System.out.println(concesionario.getSueldoNetoGerente());
    System.out.println(concesionario.getGerente());
    System.out.println(concesionario.getVendedor(0));
    System.out.println(concesionario.getSueldoNetoVendedor(vendedor));
    
    int opcion,anno;
    float precioV;
    String codigo,marca,modelo,nombreF;
    boolean vendido;
    do{
      opcion = menu();
      switch(opcion) {
        case 1:
          break;
        case 2:
          Automovil auto = concesionario.new Automovil();
          System.out.print("\nDigite codigo: ");
          codigo = sc.nextLine();
          auto.setCodigo(codigo);

          System.out.print("\nDigite la marca: ");
          marca = sc.nextLine();
          auto.setMarca(marca);

          System.out.print("\nDigite el modelo: ");
          modelo = sc.nextLine();
          auto.setModelo(modelo);

          System.out.print("\nDigite el anno de fabricacion: ");
          anno = sc.nextInt();
          auto.setAnnoFabricacion(anno);

          System.out.print("\nDigite el nombre del Fabricante: ");
          nombreF = sc.nextLine();
          auto.setNombreFabricante(nombreF);

          System.out.print("\nDigite el precio de venta: ");
          precioV = sc.nextFloat();
          auto.setPrecioVenta(precioV);

          concesionario.setAutomovil(auto);
          break;
        case 3:

          break;
        case 4:
          break;
        }
    } while(opcion >= 1 || opcion <=7);
  }
}
