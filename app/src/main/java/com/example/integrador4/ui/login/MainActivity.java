package com.example.integrador4.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.integrador4.R;
import com.example.integrador4.model.Usuario;
import com.example.integrador4.request.ApiClient;
import com.example.integrador4.ui.registro.Regisstro_Activity;

public class MainActivity extends AppCompatActivity {
    private Button login, registrar;
    private EditText pass, email;
    private ApiClient apiClient;
    private ViewModelMain viewModelMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
        viewModelMain= ViewModelProviders.of(this).get(ViewModelMain.class);
        viewModelMain.getUsuarioMutableLiveData().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                Intent i = new Intent(getApplicationContext(), Regisstro_Activity.class);
                i.putExtra("clave", "L");
                startActivity(i);
            }
        });

    }

    public void configView(){

        login=findViewById(R.id.btnlogin);
        pass=findViewById(R.id.tvPassword);
        email=findViewById(R.id.tvEmail);
        registrar=findViewById(R.id.btnregistrar);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String mail = email.getText().toString();
                 String pas = pass.getText().toString();
                viewModelMain.inicioSession(mail,pas);
            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Regisstro_Activity.class);
                i.putExtra("clave", "R");
                startActivity(i);
            }
        });
    }
}
