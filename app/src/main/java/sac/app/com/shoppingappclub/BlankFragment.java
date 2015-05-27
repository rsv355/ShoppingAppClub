package sac.app.com.shoppingappclub;

/**
 * Created by Android on 27-05-2015.
 */


import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment {



    public BlankFragment() {
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
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView txt1 =  (TextView)view.findViewById(R.id.txt1);
        TextView txt2 =  (TextView)view.findViewById(R.id.txt2);
        TextView txt3 =  (TextView)view.findViewById(R.id.txt3);
        TextView txt4 =  (TextView)view.findViewById(R.id.txt4);
        TextView txt5 =  (TextView)view.findViewById(R.id.txt5);

        TextView txt6 =  (TextView)view.findViewById(R.id.txt6);
        TextView txt7 =  (TextView)view.findViewById(R.id.txt7);
        TextView txt8 =  (TextView)view.findViewById(R.id.txt8);
        TextView txt9 =  (TextView)view.findViewById(R.id.txt9);
        TextView txt10 =  (TextView)view.findViewById(R.id.txt10);

        TextView txt11 =  (TextView)view.findViewById(R.id.txt11);
        TextView txt12 =  (TextView)view.findViewById(R.id.txt12);


        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"fonts/f1.ttf");
        txt1.setTypeface(tf,Typeface.BOLD);
        txt2.setTypeface(tf,Typeface.BOLD);
        txt3.setTypeface(tf,Typeface.BOLD);
        txt4.setTypeface(tf,Typeface.BOLD);
        txt5.setTypeface(tf,Typeface.BOLD);
        txt6.setTypeface(tf,Typeface.BOLD);
        txt7.setTypeface(tf,Typeface.BOLD);
        txt8.setTypeface(tf,Typeface.BOLD);
        txt9.setTypeface(tf,Typeface.BOLD);
        txt10.setTypeface(tf,Typeface.BOLD);
        txt11.setTypeface(tf,Typeface.BOLD);
        txt12.setTypeface(tf,Typeface.BOLD);



        return view;
    }




}