package sac.app.com.shoppingappclub;

/**
 * Created by Android on 27-05-2015.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class ContactusFragment extends Fragment {
    Data dataobj;


    public ContactusFragment() {
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
        View view = inflater.inflate(R.layout.contact, container, false);
        TextView txt = (TextView)view.findViewById(R.id.txt);
        txt.setText("Hi, Thank for installing our App. You can reach us for any technical queries or partnership queries at\n" +
                "\n\nsudiptaenterprises@gmail.com\n");


        Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.translate);
        anim.reset();
        txt.clearAnimation();
        txt.startAnimation(anim);

        return view;
    }

}