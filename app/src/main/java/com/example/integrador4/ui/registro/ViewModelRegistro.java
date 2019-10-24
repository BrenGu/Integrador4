package com.example.integrador4.ui.registro;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.integrador4.model.Usuario;
import com.example.integrador4.request.ApiClient;


public class ViewModelRegistro extends AndroidViewModel {

    private MutableLiveData<Usuario>usuarioMutableLiveData;
    private Context context;

    public LiveData<Usuario> getUsuarioMutableLiveData() {
        if(usuarioMutableLiveData==null){
            usuarioMutableLiveData=new MutableLiveData<>();
        }
        return usuarioMutableLiveData;
    }

    public ViewModelRegistro(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public void guardar(Usuario usuario){
        ApiClient.guardar(context,usuario);
    }
    public void leer(){
      Usuario u= ApiClient.leer(context);
      if(u != null) {
          usuarioMutableLiveData.setValue(u);
      }
    }
}
