package sac.app.com.shoppingappclub;

/**
 * Created by Android on 27-05-2015.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextView;

import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.CurlEffect;


public class AboutusFragment extends Fragment {
    Data dataobj;


    public AboutusFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.abotus, container, false);
        TextView txt = (TextView)view.findViewById(R.id.txt);
        txt.setText("About us details will be there");


        Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.translate);
        anim.reset();
        txt.clearAnimation();
        txt.startAnimation(anim);

        return view;
    }

}