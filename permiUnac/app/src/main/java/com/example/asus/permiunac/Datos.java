package com.example.asus.permiunac;

public class Datos {

    public String Nombre;
    public String Apellidos;
    public String salida;
    public String fecha;
    public String motivo;

    public Datos() {
    }

    public Datos(String nombre, String apellidos, String salida, String fecha, String motivo) {
        Nombre = nombre;
        Apellidos = apellidos;
        this.salida = salida;
        this.fecha = fecha;
        this.motivo = motivo;
    }
}
