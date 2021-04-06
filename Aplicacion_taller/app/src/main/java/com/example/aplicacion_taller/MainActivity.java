package com.example.aplicacion_taller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private Button btn_registro;
     private Button btn_consultar;
    private List<persona> personaList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();
    private empresa empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringList.add("CEO");
        stringList.add("LIDER DE DESARROLLO");
        stringList.add("MAQUETADORES");
        stringList.add("PRUEBAS");
        stringList.add("DESARROLADOR");
        stringList.add("SECRTARIA");
        Intent intent = getIntent();
        personaList = (List<persona>) intent.getSerializableExtra("empleado");

        empresa = new empresa("ELITE GROUP", "01010110", personaList, stringList);

        btn_registro = findViewById(R.id.btn_registro);
        btn_consultar = findViewById(R.id.btn_consultar);
        btn_registro.setOnClickListener(this);
        btn_consultar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_registro)
        {
            Intent myIntentpersona = new Intent(this, formulario.class);
            myIntentpersona.putExtra("empresa", (Serializable) empresa);
            startActivity(myIntentpersona);
        }
        if (v.getId() == R.id.btn_consultar)
        {
            Intent myIntentConsultas = new Intent(this, consulta.class);
            myIntentConsultas.putExtra("empresa", (Serializable) empresa);
            startActivity(myIntentConsultas);
        }

    }
}