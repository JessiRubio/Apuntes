package com.example.apuntes.ui.calendario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.apuntes.R;

public class CalendarioFragment extends Fragment {

    private CalendarioViewModel calendarioViewModel;
    private EditText evento;
    private Button btn_guardar;
    private CalendarView calendario;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calendarioViewModel =
                ViewModelProviders.of(this).get(CalendarioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calendario, container, false);

        evento = root.findViewById(R.id.ed_evento_calendario);
        btn_guardar = root.findViewById(R.id.btn_calendario);
        calendario = root.findViewById(R.id.cv_calendario);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return root;
    }
}