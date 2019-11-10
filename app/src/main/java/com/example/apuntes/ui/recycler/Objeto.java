package com.example.apuntes.ui.recycler;

import java.util.ArrayList;
import java.util.List;

public class Objeto {

    private String nombre;
    private String apellido;



    public Objeto(String n, String a){
        this.nombre = n;
        this.apellido = a;
    }

    public static List<Objeto> lista(){
        List<Objeto> lista = new ArrayList<Objeto>();
        lista.add(new Objeto("Juan", "Gomez"));
        lista.add(new Objeto("Jess","Rubio"));
        lista.add(new Objeto("Pepe","Rodriguez"));
        lista.add(new Objeto("Miguel","Gonzalez"));
        return lista;
    }


    public  String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
