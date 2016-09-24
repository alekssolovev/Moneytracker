package com.example.sani4.moneytracker.ui.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;


import com.example.sani4.moneytracker.R;

public class StatisticsFragment extends Fragment{

    public void onCreate(@Nullable Bundle savedInstanceState){
        Log.d("Fragment", "onCreate");
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.statistics_fragment,container,false);
        Log.d("Fragment", "onCreate");
        return rootView;
    }

    public void onAttach(Activity activity){
        Log.d("Fragment", "onAttach");
        super.onAttach(activity);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        Log.d("Fragment", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);

    }

    public void onStart(){
        Log.d("Fragment", "onStart");
        super.onStart();
    }

    public void onResume(){
        Log.d("Fragment", "onResume");
        super.onResume();
    }

    public void onPause(){
        Log.d( "Frag","onPause" );
        super.onPause();
    }

    public void onStop(){
        Log.d("Fragment", "onStop");
        super.onStop();
    }

    public void onDestroyView(){
        Log.d("Fragment", "onDestroyView");
        super.onDestroyView();
    }


    public void onDestroy() {
        Log.d("Fragment", "onDestroy");
        super.onDestroy();
    }

    public void onDetach(){
        Log.d("Fragment", "onDetach");
        super.onDetach();
    }
}
