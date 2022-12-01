package entidades;

public class Persona {
  protected String dni;
  protected String nombres;
  protected String apellidos;
  
  public Persona() {
    dni = "12345678";
    nombres = "NN";
    apellidos = "NA";
  }

  public Persona(String dni, String nombres, String apellidos) {
    this.dni = dni;
    this.nombres = nombres;
    this.apellidos = apellidos;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getDni() {
    return dni;
  }

  public String getNombres() {
    return nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  @Override
  public String toString() {
    return "\nDNI: " + getDni() +
            "\nNombres: " + getNombres() +
            "\nApellidos: " + getApellidos();
  }
}
