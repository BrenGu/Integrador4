package com.example.integrador4.model;

public class Usuario {
    private long dni;
    private String apellido;
    private String nombre;
    private String email;
    private String password;

    public Usuario(long dni, String apellido, String nombre, String email, String password) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }

    public long getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
