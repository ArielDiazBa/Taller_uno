package com.example.aplicacion_taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class formulario extends AppCompatActivity implements View.OnClickListener {

    private EditText txt_nombre;
    private EditText txt_apellido;
    private EditText txt_edad;
    private EditText txt_email;
    private Spinner spin_cargo;
    private EditText txt_salario;
    private Button btn_uno;
    private Button btn_guardar;
    static List<persona> personaList = new ArrayList<>();

    private empresa empresa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_apellido = findViewById(R.id.txt_apellido);
        txt_edad = findViewById(R.id.txt_edad);
        txt_email = findViewById(R.id.txt_email);
        spin_cargo = findViewById(R.id.spin_cargo);
        txt_salario = findViewById(R.id.txt_salario);
        btn_uno = findViewById(R.id.btn_uno);
        btn_guardar = findViewById(R.id.btn_guardar);
        btn_uno.setOnClickListener(this);
        btn_guardar.setOnClickListener(this);



        Intent intent = getIntent();
        empresa = (empresa) intent.getSerializableExtra("empresa");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,empresa.getStringList());
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spin_cargo.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_guardar){
            String nombre = txt_nombre.getText().toString();
            String apellido = txt_apellido.getText().toString();
            String edad = txt_edad.getText().toString();
            String email = txt_email.getText().toString();
            String salario = txt_salario.getText().toString();
            if (nombre.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar el Nombre",R.layout.custom_toast ).show();
                return;
            }
            if (apellido.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar el Apellido",R.layout.custom_toast ).show();
                return;
            }
            if (edad.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar la Edad",R.layout.custom_toast ).show();
                return;
            }
            if (!isvalidemail(email)){
                CustomToastView.makeErrorToast(this,"Error al validar el Email",R.layout.custom_toast ).show();
                return;
            }
            if (salario.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar la salario",R.layout.custom_toast ).show();
                return;
            }

            AgregarEmpleado();
            LimpiarCampos();
            CustomToastView.makeSuccessToast(this, "Empleado agregado correctamente",R.layout.custom_toast).show();

        }
        if (v.getId() == R.id.btn_uno){
            Intent intent_tres = new Intent(this,MainActivity.class);
            intent_tres.putExtra("empleado",(Serializable) personaList );
            startActivity(intent_tres);
        }

    }

    private boolean isvalidemail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }

    private void AgregarEmpleado () {
        persona empleados = new persona(txt_nombre.getText().toString(),txt_apellido.getText().toString(),
                Integer.parseInt(txt_edad.getText().toString()),txt_email.getText().toString(),spin_cargo.getSelectedItem().toString(),
                Double.parseDouble(txt_salario.getText().toString()));

        personaList.add(empleados);
    }

    private void LimpiarCampos(){
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_edad.setText("");
        txt_email.setText("");
        spin_cargo.setSelection(0);
        txt_salario.setText("");
        txt_nombre.requestFocus();
    }

}