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
                            3. Registrar clientes
                            4.
                            5. Listar los datos de las ventas totales por cada vendedor, así como el monto del porcentaje que les corresponde");
                            6. Listar el total de ventas realizadas en un mes determinado
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
    int opcion,mes,anno;
    float precioV;
    String codigo,marca,modelo,nombreF,dnic,nombresc,apellidosc,direccionc,telefonoc;
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
                    Cliente client = new Cliente();
                    System.out.print("\nDigite DNI: ");
                    dnic = sc.nextLine();
                    client.setDni(dnic);
                    
                    System.out.print("\nDigite nombres: ");
                    nombresc = sc.nextLine();
                    client.setNombres(nombresc);
                    
                    System.out.print("\nDigite apellidos: ");
                    apellidosc = sc.nextLine();
                    client.setApellidos(apellidosc);
                    
                    System.out.print("\nDigite direccion: ");
                    direccionc = sc.nextLine();
                    client.setDireccion(direccionc);
                    
                    System.out.print("\nDigite numero telefonico: ");
                    telefonoc = sc.nextLine();
                    client.setTelefono(telefonoc);
                    
                    concesionario.setCliente(client);
                    break;
                case 4:
                    break;
                case 6:
                    System.out.print("\nListado de Ventas de Determinado mes ");
                    do{
                       System.out.print("\n\tDigite el mes:");
                       mes = sc.nextInt(); 
                    }while(!(mes>0 && mes<=12));
                    do{
                        System.out.print("\n\tDigite el anio actual: ");
                        anno = sc.nextInt();
                    }while(!(anno>=1000));
                    int n = 0;
                    switch(mes){
                        case 1 -> System.out.print("Lista de ventas realizadas el mes de Enero del presente anio:");
                        case 2 -> System.out.print("Lista de ventas realizadas el mes de Febrero del presente anio:");
                        case 3 -> System.out.print("Lista de ventas realizadas el mes de Marzo del presente anio:");
                        case 4 -> System.out.print("Lista de ventas realizadas el mes de Abril del presente anio:");
                        case 5 -> System.out.print("Lista de ventas realizadas el mes de Mayo del presente anio:");
                        case 6 -> System.out.print("Lista de ventas realizadas el mes de Junio del presente anio:");
                        case 7 -> System.out.print("Lista de ventas realizadas el mes de Julio del presente anio:");
                        case 8 -> System.out.print("Lista de ventas realizadas el mes de Agosto del presente anio:");
                        case 9 -> System.out.print("Lista de ventas realizadas el mes de Septiembre del presente anio:");
                        case 10 -> System.out.print("Lista de ventas realizadas el mes de Octubre del presente anio:");
                        case 11 -> System.out.print("Lista de ventas realizadas el mes de Noviembre del presente anio:");
                        case 12 -> System.out.print("Lista de ventas realizadas el mes de Diciembre del presente anio:");
                    }
                    for(int i = 0; i < concesionario.getNumeroVentas(); i++){
                        if(anno == concesionario.getBoletaVenta(i).getFechaVenta().getAnno() && 
                                mes == concesionario.getBoletaVenta(i).getFechaVenta().getMes()){
                            System.out.print(concesionario.getBoletaVenta(i).toString());
                            n++;
                        }
                    }
                    if(n == 0)
                        System.out.print("No se han realizado ventas este mes.");
                    break;
                }
    } while(opcion!=7);
  }
}

