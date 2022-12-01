package entidades;

public class Vendedor extends Empleado implements Comision {
  private Fecha fechaContrato;
  private int tiempoContrato;

  public Vendedor() {
    super();
    fechaContrato = new Fecha();
    tiempoContrato = 0;
  }

  public Vendedor(String dni, String nombres, String apellidos, Fecha fechaNacimiento, Fecha fechaContrato, int tiempoContrato) {
    super(dni, nombres, apellidos, fechaNacimiento);
    this.fechaContrato = fechaContrato;
    this.tiempoContrato = tiempoContrato;
  }

  public void setFechaContrato(Fecha fechaContrato) {
    this.fechaContrato = fechaContrato;
  }

  public void setTiempoContrato(int meses) {
    tiempoContrato = meses;
  }

  public Fecha getFechaContrato() {
    return fechaContrato;
  }
  
  public int getTiempoContrato() {
    return tiempoContrato;
  }

  @Override
  public String toString() {
    return super.toString() +
            "\nFecha de contrato: " + getFechaContrato() +
            "\nTiempo de contrato (en meses): " + getTiempoContrato();    
  }

  @Override
  public float getPorcentajeComision() {
    return 0.25f;
  }
}
