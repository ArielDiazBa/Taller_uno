package com.example.aplicacion_taller;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class empresa  implements Serializable {
    private String nombre;
    private String nit;
    List<persona> personaList = new ArrayList<>();
    List<String>  stringList = new ArrayList<>();

    public empresa(String nombre, String nit, List<persona> personaList, List<String> stringList) {
        this.nombre = nombre;
        this.nit = nit;
        this.personaList = personaList;
        this.stringList = stringList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<persona> personaList) {
        this.personaList = personaList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<persona> empleadoMasJoven(){

        List<persona> listEmpleados = new ArrayList<>();
        int EdadMenor;
        persona emple = personaList.get(0);
        EdadMenor = emple.getEdad();

        for (persona emp: personaList)
        {
            if (EdadMenor >= emp.getEdad())
            {
                EdadMenor = emp.getEdad();
            }
        }

        for (persona emp: personaList)
        {
            if (EdadMenor == emp.getEdad())
            {
                listEmpleados.add(emp);
            }
        }

        return listEmpleados;
    }

    public List<persona> empleadoMasViejo(){

        List<persona> listEmpleados = new ArrayList<>();
        int EdadMayor;
        persona emple = personaList.get(0);
        EdadMayor = emple.getEdad();

        for (persona emp: personaList)
        {
            if (EdadMayor <= emp.getEdad())
            {
                EdadMayor = emp.getEdad();
            }
        }

        for (persona emp: personaList)
        {
            if (EdadMayor == emp.getEdad())
            {
                listEmpleados.add(emp);
            }
        }

        return listEmpleados;
    }

    public List<persona> salarioMasAlto(){

        List<persona> listEmpleados = new ArrayList<>();
        double SalarioMayor;
        persona emple = personaList.get(0);
        SalarioMayor = emple.getSalario();

        for (persona emp: personaList)
        {
            if (SalarioMayor <= emp.getSalario())
            {
                SalarioMayor = emp.getSalario();
            }
        }

        for (persona emp: personaList)
        {
            if (SalarioMayor == emp.getSalario())
            {
                listEmpleados.add(emp);
            }
        }

        return listEmpleados;
    }

    public List<persona> salarioMasBajo(){

        List<persona> listEmpleados = new ArrayList<>();
        double SalarioMenor;
        persona emple = personaList.get(0);
        SalarioMenor = emple.getSalario();

        for (persona emp: personaList)
        {
            if (SalarioMenor >= emp.getSalario())
            {
                SalarioMenor = emp.getSalario();
            }
        }

        for (persona emp: personaList)
        {
            if (SalarioMenor == emp.getSalario())
            {
                listEmpleados.add(emp);
            }
        }

        return listEmpleados;
    }

    public double promedioSalarios(){

        int cont = 0;
        double totalSalarios = 0;

        for (persona emp: personaList)
        {
            totalSalarios = totalSalarios + emp.getSalario();
            cont++;
        }

        double promedio = totalSalarios / cont;

        return promedio;
    }

    public String ponderadoCargos(){

        int cont = 0;
        double promedio = 0;
        double suma = 0;
        String informe = "";

        for (int i = 0; i <= stringList.size()-1; i++){

            for (int j = 0; j <= personaList.size()-1; j++){

                if (stringList.get(i).equals(personaList.get(j).getCargo())){

                    cont = cont + 1;
                    suma = suma + personaList.get(j).getSalario();
                }else {

                    suma = suma + 0;
                    cont = cont + 0;
                }
            }

            if (cont == 0){
                promedio = 0;
            }else {
                promedio = suma/cont;
            }

            informe = informe + "\n" + "* Cargo: " + stringList.get(i) + "\n-- # de empleados cargo: " + cont
                    + "\n-- Promedio Salarios cargo: " + promedio;
            cont = 0;
            suma = 0;
        }

        return informe;
    }

}
