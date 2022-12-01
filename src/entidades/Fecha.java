package entidades;

public class Fecha {
  private int anno;
  private int mes;
  private int dia;

  public Fecha() {
    anno = 1000;
    mes = 1;
    dia = 1;
  }

  public Fecha(int anno, int mes, int dia) {
    if (anno >= 1000) {
      this.anno = anno;
    } else {
      System.out.println("Año fuera de rango (< 1000)");
    }
    if (mes >= 1 && mes <= 12) {
      this.mes = mes;
    } else {
      System.out.println("Mes fuera de rango (<1 o >12)");
    }
    switch (mes) {
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        if (dia >= 1 && dia <= 31)
          this.dia = dia;
        else
          System.out.println("Dia fuera de rango (<1 o >31)");
        break;
      case 4: case 6: case 9: case 11:
        if (dia >= 1 && dia <= 30)
          this.dia = dia;
        else
          System.out.println("Dia fuera de rango (<1 o >30)");
        break;
      case 2:
        if (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0))
          if (dia >= 1 && dia <= 29)
            this.dia = dia;
          else
            System.out.println("Dia fuera de rango (<1 o >29)");
        else
          if (dia >= 1 && dia <= 28)
            this.dia = dia;
          else
            System.out.println("Dia fuera de rango (<1 o >28)");
        break;
      default:
        System.out.println("Mes incorrecto. Dia no establecido.");
        break;
    }
  }
  
  public void setAnno(int anno) {
    if (anno >= 1000)
      this.anno = anno;
    else
      System.out.println("Año fuera de rango (< 1000)");
  }

  public void setMes(int mes) {
    if (mes >= 1 && mes <= 12)
      this.mes = mes;
    else
      System.out.println("Mes fuera de rango (<1 o >12)");
  }

  public void setDia(int dia) {
    switch (mes) {
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        if (dia >= 1 && dia <= 31)
          this.dia = dia;
        else
          System.out.println("Dia fuera de rango (<1 o >31)");
        break;
      case 4: case 6: case 9: case 11:
        if (dia >= 1 && dia <= 30)
          this.dia = dia;
        else
          System.out.println("Dia fuera de rango (<1 o >30)");
        break;
      case 2:
        if (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0))
          if (dia >= 1 && dia <= 29)
            this.dia = dia;
          else
            System.out.println("Dia fuera de rango (<1 o >29)");
        else
          if (dia >= 1 && dia <= 28)
            this.dia = dia;
          else
            System.out.println("Dia fuera de rango (<1 o >28)");
        break;
      default:
        System.out.println("Mes incorrecto. Dia no establecido.");
        break;
    }
  }

  public int getAnno() {
    return anno;
  }

  public int getMes() {
    return mes;
  }

  public int getDia() {
    return dia;
  }

  @Override
  public String toString() {
    return (getDia()<=9?"0"+getDia():getDia()) + "/" + 
            (getMes()<=9?"0"+getMes():getMes()) + "/" + 
            getAnno();
  }
}
