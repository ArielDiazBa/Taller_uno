package com.example.aplicacion_taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class consulta extends AppCompatActivity implements View.OnClickListener {

    private Spinner spin_consultas;
    private TextView txt_mensaje;
    private Button btn_dos;
    private Button btn_resultados;
    private empresa empresa;
    private List<persona> personaResultado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        Intent intent = getIntent();
        empresa = (empresa) intent.getSerializableExtra("empresa");

        spin_consultas = findViewById(R.id.spin_consultas);
        txt_mensaje = findViewById(R.id.txt_mensaje);
        btn_dos = findViewById(R.id.btn_dos);
        btn_resultados = findViewById(R.id.btn_resultados);
        btn_dos.setOnClickListener(this);
        btn_resultados.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.opciones,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spin_consultas.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_dos){
            Intent myIntent_cuatro = new Intent(this,MainActivity.class);
            startActivity(myIntent_cuatro);
        }
        if (v.getId() == R.id.btn_resultados)
        {
            int IdSeleccion = (int)spin_consultas.getSelectedItemId();

            switch (IdSeleccion)
            {
                case 0:
                    String ResultadoLista = "El empleado mas joven es: \n";
                    personaResultado = empresa.empleadoMasJoven();
                    for (int i = 0; i <= personaResultado.size()-1; i++){
                        ResultadoLista = ResultadoLista + "\n" + "Nombre: "+ personaResultado.get(i).getNombre()
                                + " " + personaResultado.get(i).getApellido()
                                + "\nEdad: " + personaResultado.get(i).getEdad();
                    }
                    txt_mensaje.setText(ResultadoLista);

                    break;
                case 1:
                    ResultadoLista = "El empleado mas viejo es: \n";
                    personaResultado = empresa.empleadoMasViejo();
                    for (int i = 0; i <= personaResultado.size()-1; i++){
                        ResultadoLista = ResultadoLista + "\n" + "Nombre: "+ personaResultado.get(i).getNombre()
                                + " " + personaResultado.get(i).getApellido()
                                + "\nEdad: " + personaResultado.get(i).getEdad();
                    }
                    txt_mensaje.setText(ResultadoLista);

                    break;
                case 2:
                    ResultadoLista = "El empleado con salario mas alto es: \n";
                    personaResultado = empresa.salarioMasAlto();
                    for (int i = 0; i <= personaResultado.size()-1; i++){
                        ResultadoLista = ResultadoLista + "\n" + "Nombre: "+ personaResultado.get(i).getNombre()
                                + " " + personaResultado.get(i).getApellido()
                                + "\nSalario: " + personaResultado.get(i).getSalario();
                    }
                    txt_mensaje.setText(ResultadoLista);

                    break;
                case 3:
                    ResultadoLista = "El empleado con salario mas bajo es: \n";
                    personaResultado = empresa.salarioMasBajo();
                    for (int i = 0; i <= personaResultado.size()-1; i++){
                        ResultadoLista = ResultadoLista + "\n" + "Nombre: "+ personaResultado.get(i).getNombre()
                                + " " + personaResultado.get(i).getApellido()
                                + "\nSalario: " + personaResultado.get(i).getSalario();
                    }
                    txt_mensaje.setText(ResultadoLista);

                    break;
                case 4:
                    ResultadoLista = "El promedio de los salarios es: \n";

                    double promedio = empresa.promedioSalarios();

                    txt_mensaje.setText(ResultadoLista + "\n" + promedio);

                    break;
                case 5:
                    String informe = "";
                    informe = empresa.ponderadoCargos();
                   txt_mensaje.setText(informe);

                    break;
            }
        }


    }
}