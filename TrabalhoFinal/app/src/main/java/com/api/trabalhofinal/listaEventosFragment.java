package com.api.trabalhofinal;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.api.trabalhofinal.objetos.Eventos;
import com.api.trabalhofinal.objetos.Usuarios;
import com.api.trabalhofinal.objetos.UsuariosEventos;

import java.util.ArrayList;
import java.util.List;


public class listaEventosFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;

    public listaEventosFragment() {
    }

    public static listaEventosFragment newInstance(int columnCount) {
        listaEventosFragment fragment = new listaEventosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventos_lista, container, false);

        DbHelper db = new DbHelper(getActivity());

        int userId = 0;
        if (getArguments() != null) {
            userId = getArguments().getInt("userId");
        }

        List<UsuariosEventos> eventosUserList = db.getUsuariosEventos(db.getUserById(userId));

        List<Eventos> eventosList = new ArrayList<Eventos>();

        if (eventosUserList.size() != 0) {
            for (int position = 0; position < eventosUserList.size(); position++) {
                eventosList.add(eventosUserList.get(position).getIdEvento());
            }

        }

        recyclerView = (RecyclerView) view.findViewById(R.id.listEventos);
        mAdapter = new RecyclerViewAdapter(eventosList, getActivity(), 1);


        // Set the adapter

        recyclerView.setAdapter(mAdapter);


        return view;
    }


}