package entidades;

public class Empleado extends Persona {
  protected Fecha fechaNacimiento;

  public Empleado() {
    super();
    fechaNacimiento = new Fecha();
  }

  public Empleado(String dni, String nombres, String apellidos, Fecha fechaNacimiento) {
    super(dni, nombres, apellidos);
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setFechaNacimiento(Fecha fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Fecha getFechaNacimiento() {
    return fechaNacimiento;
  }

  @Override
  public String toString() {
    return super.toString() + 
            "\nFecha de nacimiento: " + getFechaNacimiento();
  }
}
