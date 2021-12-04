package com.upb.cerofilas.controlador;

import com.upb.cerofilas.interfaz.LoginIterface;

public class ControladorLogin implements LoginIterface.Controlador {

    private final LoginIterface.View view;

    public ControladorLogin(LoginIterface.View view) {
        this.view = view;
    }

    @Override
    public boolean validarLogin(String editText, String indicador) {

        if(editText.trim().isEmpty()) {
            view.validarLogin(indicador,"Los campos no pueden estar vacíos");
            return false;
        } else {
            if(editText.length() < 5) {
                view.validarLogin(indicador,"Los campos no deben ser menor o igual a 5");
                return false;
            }
        }

        return true;

    }
}
