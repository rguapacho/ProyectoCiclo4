package com.upb.cerofilas.interfaz;

public interface LoginIterface {

    interface View {
        void validarLogin(String indicador, String mensaje);
    }

    interface Controlador {
        boolean validarLogin(String editText, String indicador);
    }

    interface Modelo {

    }
}
