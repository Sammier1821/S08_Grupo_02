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
                          5. Listar los datos de las ventas totales (por cada vendedor)
                          6. Listar el total de ventas realizadas en un mes determinado
                          7. 
                          8. Salir
                          \tDigite una opcion [1 - 8]: """;
    int opcion;
    do{
      System.out.print("\n\n\tMenu principal\n\n" + opcionesMenu);
      opcion = sc.nextInt();
    } while(opcion < 1 || opcion > 8);
    sc.nextLine();
    return opcion;
  }
  
  public static void main(String[] args) {
    
    Gerente gerenteInicial = new Gerente("aaa", "Pedro", "Quiroz", new Fecha(2005,1,18),"IngSistemas", 5000);
    Concesionario concesionario = new Concesionario("CompañiaInicial", gerenteInicial);
    
    int opcion,mes,anno;
    do{
      opcion = menu();

      switch(opcion) {
        case 1:
          break;
        case 2:
          Automovil auto = concesionario.new Automovil();
          
          System.out.print("\nDigite codigo: ");
          auto.setCodigo(sc.nextLine());

          System.out.print("\nDigite la marca: ");
          auto.setMarca(sc.nextLine());

          System.out.print("\nDigite el modelo: ");
          auto.setModelo(sc.nextLine());

          System.out.print("\nDigite el anno de fabricacion: ");
          auto.setAnnoFabricacion(sc.nextInt());
          sc.nextLine();
          
          System.out.print("\nDigite el nombre del Fabricante: ");
          auto.setNombreFabricante(sc.nextLine());

          System.out.print("\nDigite el precio de venta: ");
          auto.setPrecioVenta(sc.nextFloat());

          concesionario.setAutomovil(auto);
          break;
        case 3:
          Cliente client = new Cliente();
          
          System.out.print("\nDigite DNI: ");
          client.setDni(sc.nextLine());

          System.out.print("\nDigite nombres: ");
          client.setNombres(sc.nextLine());

          System.out.print("\nDigite apellidos: ");
          client.setApellidos(sc.nextLine());

          System.out.print("\nDigite direccion: ");
          client.setDireccion(sc.nextLine());

          System.out.print("\nDigite numero telefonico: ");
          client.setTelefono(sc.nextLine());

          concesionario.setCliente(client);
          break;
        case 4:
          break;
        case 5:
          for (int i = 0; i < concesionario.getNumeroVendedores(); i++) {
            System.out.println("\nVENDEDOR " + (i+1) + ":");
            System.out.println("DNI: " + concesionario.getVendedor(i).getDni() +
                    " Nombres: " + concesionario.getVendedor(i).getNombres());
            System.out.println("VENTAS REALIZADAS:");
            int n = 0;
            for (int j = 0; j < concesionario.getNumeroVentas(); j++) {
              if (concesionario.getBoletaVenta(j).getDniVendedor().equals(concesionario.getVendedor(i).getDni())) {
                System.out.println(concesionario.getBoletaVenta(j));
                n++;
              }
            }
            if (n == 0) {
              System.out.println("No se han realizado ventas con este vendedor.");
            }
          }
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
          for(int i = 0; i < concesionario.getNumeroVentas(); i++)
            if(anno == concesionario.getBoletaVenta(i).getFechaVenta().getAnno() &&
                    mes == concesionario.getBoletaVenta(i).getFechaVenta().getMes()){
              System.out.print(concesionario.getBoletaVenta(i).toString());
              n++;
            }
          if(n == 0)
            System.out.print("No se han realizado ventas este mes.");
          break;
      }
    } while(opcion != 8);
  }
  
}

