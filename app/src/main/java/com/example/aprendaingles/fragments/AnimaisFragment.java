package com.example.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimaisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimaisFragment extends Fragment implements View.OnClickListener {

    private ImageButton botaoCao,botaoGato,botaoLeao,botaoMacaco,botaoOvelha,botaoVaca;
    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimaisFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimaisFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimaisFragment newInstance(String param1, String param2) {
        AnimaisFragment fragment = new AnimaisFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_animais, container, false);

        botaoCao = view.findViewById(R.id.botaoCao);
        botaoGato = view.findViewById(R.id.botaoGato);
        botaoLeao = view.findViewById(R.id.botaoLeao);
        botaoMacaco = view.findViewById(R.id.botaoMacaco);
        botaoOvelha = view.findViewById(R.id.botaoOvelha);
        botaoVaca = view.findViewById(R.id.botaoVaca);

        botaoCao.setOnClickListener(this);
        botaoGato.setOnClickListener(this);
        botaoLeao.setOnClickListener(this);
        botaoMacaco.setOnClickListener(this);
        botaoOvelha.setOnClickListener(this);
        botaoVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.botaoCao:
                Log.i("Cachorro","Msg " + view.getId());
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.dog);
                reproduz();
                break;
            case R.id.botaoGato:
                Log.i("gato","Msg " + view.getId());
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cat);
                reproduz();
                break;
            case R.id.botaoLeao:
                Log.i("leao","Msg " + view.getId());
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                reproduz();
                break;
            case R.id.botaoMacaco:
                Log.i("macaco","Msg " + view.getId());
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.monkey);
                reproduz();
                break;
            case R.id.botaoOvelha:
                Log.i("Ovelha","Msg " + view.getId());
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                reproduz();
                break;
            case R.id.botaoVaca:
                Log.i("vaca","Msg " + view.getId());
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
                reproduz();
                break;
        }
    }

    private void reproduz () {
        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
}