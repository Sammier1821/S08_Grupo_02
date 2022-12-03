package presentacion;

import entidades.*;
import entidades.Concesionario.*;

public class App {
  public static void menu() {
    System.out.println("========== MENU DE FUNCIONES ==========");
    System.out.println("1. Registrar a los empleados");
    System.out.println("2.");
    System.out.println("3.");
    System.out.println("4.");
    System.out.println("5. Listar los datos de las ventas totales por cada vendedor, así como el monto del porcentaje que les corresponde");
    System.out.println("6.");
    System.out.println("7.");
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
  }
}
