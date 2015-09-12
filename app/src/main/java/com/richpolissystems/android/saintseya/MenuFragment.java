package com.richpolissystems.android.saintseya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends Fragment{

    private Saga[] sagas =
            new Saga[]{
                    new Saga("Torneo Galactico", "Torneo por la armadura dorada de Sagitario", R.drawable.cz_torneo_galactico),
                    new Saga("Las 12 Casas", "La lucha contra los caballeros dorados, los mas fuertes ",R.drawable.cz_12_casas),
                    new Saga("Asgad", "La lucha contra los dioses de Asgard",R.drawable.cz_asgard),
                    new Saga("Poseidon", "Lucha contra los caballeros de Poseidon", R.drawable.cz_poseidon),
                    new Saga("Hades", "Una nueva guerra santa esta por empezar", R.drawable.cz_hades)
            };

    ListView listaMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        MainActivity activity = (MainActivity)getActivity();

        AdaptadorSagas adaptador;
        adaptador = new AdaptadorSagas(activity, R.layout.fragment_menu, sagas);


        listaMenu = (ListView)view.findViewById(R.id.listaMenu);

        listaMenu.setAdapter(adaptador);

        listaMenu.setOnItemClickListener(activity);

        return view;
    }

}