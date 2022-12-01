package entidades;

public class Cliente extends Persona {
  private String direccion;
  private String telefono;

  public Cliente() {
    super();
    direccion = "ND";
    telefono = "123456789";
  }

  public Cliente(String dni, String nombres, String apellidos, String direccion, String telefono) {
    super(dni, nombres, apellidos);
    this.direccion = direccion;
    this.telefono = telefono;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  @Override
  public String toString() {
    return super.toString() +
            "\nDireccion: " + getDireccion() +
            "\nTelefono: " + getTelefono();
  }
}
