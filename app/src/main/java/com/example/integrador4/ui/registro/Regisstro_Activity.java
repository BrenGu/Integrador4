package com.example.integrador4.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.integrador4.R;
import com.example.integrador4.model.Usuario;
import com.example.integrador4.request.ApiClient;

public class Regisstro_Activity extends AppCompatActivity {

    private EditText dni, apellido, nombre, email, pass;
    private Button guardar;
    private ApiClient apiClient;
    private ViewModelRegistro viewModelRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        configView();
        viewModelRegistro= ViewModelProviders.of(this).get(ViewModelRegistro.class);
        viewModelRegistro.getUsuarioMutableLiveData().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                dni.setText(usuario.getDni() + "");
                apellido.setText(usuario.getApellido());
                nombre.setText(usuario.getNombre());
                email.setText(usuario.getEmail());
                pass.setText(usuario.getPassword());
            }
        });

        Intent i = getIntent();
        String valor=i.getStringExtra("clave");
        if(valor.equals("L")){
            viewModelRegistro.leer();
        }

    }

    public void configView(){

        dni=findViewById(R.id.etDni);
        apellido=findViewById(R.id.etApellido);
        nombre=findViewById(R.id.etNombre);
        email=findViewById(R.id.etEmail);
        pass=findViewById(R.id.etPassword);
        guardar=findViewById(R.id.btnGuardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u= new Usuario();
                u.setDni(Long.parseLong(dni.getText().toString()));
                u.setApellido(apellido.getText().toString());
                u.setNombre(nombre.getText().toString());
                u.setEmail(email.getText().toString());
                u.setPassword(pass.getText().toString());

                viewModelRegistro.guardar(u);
            }
        });

    }
}
