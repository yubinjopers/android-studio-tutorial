package kr.ai.exfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Activity의 setContentView(R.Layout.activity_main)
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // MainActivity 구해온다
                MainActivity activity = (MainActivity)getActivity();
                // MainActivity 함수 수행
                activity.onFragmentChanged(0);
            }
        });

        return rootView;
    }
}