package entidades;

import java.util.ArrayList;

public class Concesionario {
  
  public class Automovil {
    private String codigo;
    private String marca;
    private String modelo;
    private int annoFabricacion;
    private String nombreFabricante;
    private float precioVenta;
    private boolean vendido;
    private static final float PORCENTAJE_DESCUENTO = 0.05f;

    public Automovil() {
      codigo = "NC";
      marca = "NM";
      modelo = "NM";
      annoFabricacion = 1000;
      nombreFabricante = "NF";
      precioVenta = 0f;
      vendido = false;
    }

    public Automovil(String codigo, String marca, String modelo, int annoFabricacion, String nombreFabricante, float precioVenta) {
      this.codigo = codigo;
      this.marca = marca;
      this.modelo = modelo;
      this.annoFabricacion = annoFabricacion;
      this.nombreFabricante = nombreFabricante;
      this.precioVenta = precioVenta;
      this.vendido = false;
    }

    public void setCodigo(String codigo) {
      this.codigo = codigo;
    }

    public void setMarca(String marca) {
      this.marca = marca;
    }

    public void setModelo(String modelo) {
      this.modelo = modelo;
    }

    public void setAnnoFabricacion(int annoFabricacion) {
      this.annoFabricacion = annoFabricacion;
    }

    public void setNombreFabricante(String nombreFabricante) {
      this.nombreFabricante = nombreFabricante;
    }

    public void setPrecioVenta(float precioVenta) {
      this.precioVenta = precioVenta;
    }
    
    public void setVendido() {
      this.vendido = true;
    }

    public String getCodigo() {
      return codigo;
    }

    public String getMarca() {
      return marca;
    }

    public String getModelo() {
      return modelo;
    }

    public int getAnnoFabricacion() {
      return annoFabricacion;
    }

    public String getNombreFabricante() {
      return nombreFabricante;
    }

    public float getPrecioVenta() {
      return precioVenta;
    }

    public boolean isVendido() {
      return vendido;
    }

    public static float getPorcentajeDescuento() {
      return PORCENTAJE_DESCUENTO;
    }

    @Override
    public String toString() {
      return "\nCodigo: " + getCodigo() +
              "\nMarca: " + getMarca() +
              "\nModelo: " + getModelo() +
              "\nAño de fabricacion: " + getAnnoFabricacion() +
              "\nNombre de fabricante: " + getNombreFabricante() +
              "\nPrecio de venta: " + getPrecioVenta() +
              "\nPorcentaje de (posible) descuento: " + getPorcentajeDescuento();
    }
  }
  
  public class BoletaVenta {
    private Fecha fechaVenta;
    private String dniVendedor;
    private String dniCliente;
    private String codigoAutomovil;
    private boolean descuento;
    private float montoVenta;

    public BoletaVenta(Fecha fechaVenta, Vendedor vendedor, Cliente cliente, Automovil automovil, boolean descuento) {
      if (!automovil.isVendido()) {
        this.fechaVenta = fechaVenta;
        dniVendedor = vendedor.getDni();
        dniCliente = cliente.getDni();
        codigoAutomovil = automovil.getCodigo();
        this.descuento = descuento;
        if (descuento)
          montoVenta = automovil.getPrecioVenta() * (1 - Automovil.getPorcentajeDescuento());
        else
          montoVenta = automovil.getPrecioVenta();
        automovil.setVendido();
      } else {
        System.out.println("Automovil ya esta vendido. Boleta de venta no creada.");
      }
        
    }

    public Fecha getFechaVenta() {
      return fechaVenta;
    }

    public String getDniVendedor() {
      return dniVendedor;
    }

    public String getDniCliente() {
      return dniCliente;
    }

    public String getCodigoAutomovil() {
      return codigoAutomovil;
    }

    public boolean tieneDescuento() {
      return descuento;
    }

    public float getMontoVenta() {
      return montoVenta;
    }

    @Override
    public String toString() {
      return "\nFecha de venta: " + getFechaVenta() +
              "\nDNI del vendedor: " + getDniVendedor() + 
              "\nDNI del cliente: " + getDniCliente() + 
              "\nCodigo del automovil: " + getCodigoAutomovil() + 
              "\nExiste descuento: " + tieneDescuento() + 
              "\nMonto de venta: " + getMontoVenta();
    }
  }
  
  String compañia;
  Gerente gerente;
  ArrayList<Automovil> automoviles;
  ArrayList<Vendedor> vendedores;
  ArrayList<Cliente> clientes;
  ArrayList<BoletaVenta> boletasVenta;

  public Concesionario(String compañia, Gerente gerente) {
    this.compañia = compañia;
    this.gerente = gerente;
    automoviles = new ArrayList<>();
    vendedores = new ArrayList<>();
    clientes = new ArrayList<>();
    boletasVenta = new ArrayList<>();
  }
  
  public void setCompañia(String compañia) {
    this.compañia = compañia;
  }

  public void setGerente(Gerente gerente) {
    this.gerente = gerente;
  }

  public void setAutomovil(Automovil automovil) {
    automoviles.add(automovil);
  }
  
  public void setVendedor(Vendedor vendedor) {
    vendedores.add(vendedor);
  }
  
  public void setCliente(Cliente cliente) {
    clientes.add(cliente);
  }
  
  public void setBoletaVenta(BoletaVenta boletaVenta) {
    if (boletaVenta.getCodigoAutomovil() == null) {
      System.out.println("Boleta de venta no listada.");
    } else {
      boletasVenta.add(boletaVenta);
    }
    
  }

  public String getCompañia() {
    return compañia;
  }

  public Gerente getGerente() {
    return gerente;
  }
  
  public Automovil getAutomovil(int pos) {
    if (pos >= 0 && pos < automoviles.size()) {
      return automoviles.get(pos);
    } else {
      System.out.println("Automovil no encontrado.");
      return null;
    }
    
  }
  
  public Vendedor getVendedor(int pos) {
    if (pos >= 0 && pos < vendedores.size()) {
      return vendedores.get(pos);
    } else {
      System.out.println("Vendedor no encontrado.");
      return null;
    }
  }
  
  public Cliente getCliente(int pos) {
    if (pos >= 0 && pos < clientes.size()) {
      return clientes.get(pos);
    } else {
      System.out.println("Cliente no encontrado.");
      return null;
    }
  }
  
  public BoletaVenta getBoletaVenta(int pos) {
    if (pos >= 0 && pos < boletasVenta.size()) {
      return boletasVenta.get(pos);
    } else {
      System.out.println("Boleta de venta no encontrada.");
      return null;
    }
  }
  
  public float getMontoTotalVentas() {
    float montoTotalVentas = 0f;
    for (int i = 0; i < boletasVenta.size(); i++) {
      montoTotalVentas += boletasVenta.get(i).montoVenta;
    }
    return montoTotalVentas;
  }
  
  public float getMontoVentasSegunVendedor(Vendedor vendedor) {
    float montoTotalVentasVendedor = 0f;
    for (int i = 0; i < boletasVenta.size(); i++) {
      if (boletasVenta.get(i).getDniVendedor().equals(vendedor.getDni())) {
        montoTotalVentasVendedor += boletasVenta.get(i).getMontoVenta();
      }
    }
    return montoTotalVentasVendedor;
  }
  
  public float getSueldoNetoGerente() {
    if (getMontoTotalVentas() >= 50000) {
      return gerente.getSueldoMinimo() * (1 + gerente.getPorcentajeComision());
    } else {
      return gerente.getSueldoMinimo();
    }
  }
  
  public float getSueldoNetoVendedor(Vendedor vendedor) {
    float sueldoNetoVendedor = 0f;
    for (int i = 0; i < boletasVenta.size(); i++) {
      if (boletasVenta.get(i).getDniVendedor().equals(vendedor.getDni())) {
        sueldoNetoVendedor += vendedor.getPorcentajeComision() * boletasVenta.get(i).getMontoVenta();
      }
    }
    return sueldoNetoVendedor;
  }
}
