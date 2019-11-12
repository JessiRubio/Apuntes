package com.example.apuntes.ui.cambioAtributos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.apuntes.R;

public class CambioAtributosFragment extends Fragment {

    private CambioAtributosViewModel cambioBackgroundViewModel;

    private Button btn_negrita;
    private Button btn_cursiva;

    private TextView tv_texto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cambioBackgroundViewModel =
                ViewModelProviders.of(this).get(CambioAtributosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cambio_atributos, container, false);

        btn_negrita = root.findViewById(R.id.btn_negrita);
        btn_cursiva = root.findViewById(R.id.btn_cursiva);

        tv_texto = root.findViewById(R.id.tv_texto);

        btn_negrita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_texto.setTextAppearance(getContext(),R.style.negrita);
            }
        });

        btn_cursiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_texto.setTextAppearance(getContext(),R.style.cursiva);
            }
        });
        return root;


    }
}