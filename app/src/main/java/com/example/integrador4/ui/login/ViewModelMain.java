package com.example.integrador4.ui.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.integrador4.model.Usuario;
import com.example.integrador4.request.ApiClient;

public class ViewModelMain extends AndroidViewModel {

    private MutableLiveData<Usuario> usuarioMutableLiveData;
    private ApiClient apiClient=new ApiClient();
    private Context context;

    public ViewModelMain(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Usuario> getUsuarioMutableLiveData(){
        if(usuarioMutableLiveData==null){
        usuarioMutableLiveData=new MutableLiveData<>();
        }
        return usuarioMutableLiveData;
    }

    public void inicioSession (String mail, String pass){

        Usuario u=ApiClient.login(context,mail, pass);
        if(u!=null){
            usuarioMutableLiveData.setValue(u);
        }
    }

}
