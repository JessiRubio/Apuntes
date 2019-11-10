package com.example.apuntes.ui.recycler;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.apuntes.R;

public class RecyclerFragment extends Fragment {

    private RecyclerViewModel RecyclerViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutmanager;
    private adaptadorRecycler adaptador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        RecyclerViewModel = ViewModelProviders.of(this).get(RecyclerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recycler, container, false);

        recyclerView = root.findViewById(R.id.recycler);
        adaptador = new adaptadorRecycler(getContext(),Objeto.lista());
        recyclerView.setAdapter(adaptador);

        layoutmanager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutmanager);

        return root;
    }
}