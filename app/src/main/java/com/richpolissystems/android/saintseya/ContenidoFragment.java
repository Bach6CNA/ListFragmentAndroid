package com.richpolissystems.android.saintseya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ContenidoFragment extends Fragment{
    ImageView imgPoster;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contenido,container,false);

        imgPoster = (ImageView)view.findViewById(R.id.img_poster);

        return view;
    }

    public void setImagePoster(int poster){
        this.imgPoster.setImageResource(poster);
    }
}