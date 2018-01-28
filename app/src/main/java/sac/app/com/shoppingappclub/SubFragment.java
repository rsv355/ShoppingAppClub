package sac.app.com.shoppingappclub;

/**
 * Created by Android on 27-05-2015.
 */


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.tfc.webviewer.ui.WebViewerActivity;
import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.CurlEffect;

import java.util.ArrayList;


public class SubFragment extends Fragment {
    ArrayList<ShopModel> dataobj;
    EditText etSearchBox;
    ListAdapter adp;
    public SubFragment() {
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
        View view = inflater.inflate(R.layout.activity_main, container, false);


        filldata();
        JazzyListView list = (JazzyListView)view. findViewById(R.id.list);
        etSearchBox = (EditText)view.findViewById(R.id.etSearchBox);


        //slideeffect is good;FadeEffect()
        list.setTransitionEffect(new CurlEffect());

         adp = new ListAdapter(getActivity(),dataobj);
        list.setAdapter(adp);


        etSearchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adp.getFilter().filter(editable.toString());
                adp.notifyDataSetChanged();
            }
        });

        return view;
    }


    private void filldata(){
        try{
            dataobj = new ArrayList<>();
            DatabaseHandler mDatabaseHandler = new DatabaseHandler(getActivity());
            mDatabaseHandler.openDataBase();
            dataobj = mDatabaseHandler.getAllShopItem(getActivity());

            mDatabaseHandler.close();
        }catch (Exception e){}


    }
}