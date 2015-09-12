package com.richpolissystems.android.saintseya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MenuFragment extends Fragment{

    ListView listaMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu2, container, false);

        MainActivity activity = (MainActivity)getActivity();


        RecyclerView recyclerView;
        recyclerView = (RecyclerView) view.findViewById(R.id.myRecyclerView);


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        AdapterSagasRecyclerView adapterRecyclerView =
                new AdapterSagasRecyclerView(activity, activity.getSagaList());

        recyclerView.setAdapter(adapterRecyclerView);

        adapterRecyclerView.setMyOnItemClickListener(activity);

        return view;
    }

}