package entidades;

public class Gerente extends Empleado implements Comision {
  private String profesion;
  private float sueldoMinimo;

  public Gerente() {
    super();
    profesion = "NP";
    sueldoMinimo = 0.0f;
  }

  public Gerente(String dni, String nombres, String apellidos, Fecha fechaNacimiento, String profesion, float sueldoMinimo) {
    super(dni, nombres, apellidos, fechaNacimiento);
    this.profesion = profesion;
    this.sueldoMinimo = sueldoMinimo;
  }

  public void setProfesion(String profesion) {
    this.profesion = profesion;
  }

  public void setSueldoMinimo(float sueldoMinimo) {
    if (sueldoMinimo > 0)
      this.sueldoMinimo = sueldoMinimo;
    else
      System.out.println("Sueldo minimo no establecido.");
  }

  public String getProfesion() {
    return profesion;
  }

  public float getSueldoMinimo() {
    return sueldoMinimo;
  }
  
  public float getSueldoNeto(Concesionario concesionario) {
    if (concesionario.getMontoTotalVentas() >= 5000)
      return getSueldoMinimo() * (1 + getPorcentajeComision());
    else
      return getSueldoMinimo();
  }

  @Override
  public String toString() {
    return super.toString() +
            "\nProfesion: " + getProfesion() +
            "\nSueldo minimo: " + getSueldoMinimo() +
            "\nPorcentaje de comision: " + getPorcentajeComision() +
            "\nSueldo neto: " + getSueldoNeto(concesionario);
  }
  
  @Override
  public float getPorcentajeComision() {
    return 0.50f;
  }
}
