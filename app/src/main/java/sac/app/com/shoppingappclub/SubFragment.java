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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.CurlEffect;


public class SubFragment extends Fragment {
    Data dataobj;


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

        //slideeffect is good;FadeEffect()
        list.setTransitionEffect(new CurlEffect());

        ListAdapter adp = new ListAdapter(getActivity(),dataobj);
        list.setAdapter(adp);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Data obj = new Data();

                Bundle bnd = new Bundle();
                bnd.putString("url", obj.links.get(pos));

                FragmentManager manager1 = getActivity().getSupportFragmentManager();
                FragmentTransaction ft1 = manager1.beginTransaction();

                WebViewFragment web = new WebViewFragment();
                web.setArguments(bnd);
                ft1.replace(R.id.main_container, web);

                ft1.addToBackStack("");
                ft1.commit();

              /*  Intent ii = new Intent(getActivity(), webview.class);
                ii.putExtra("url", obj.links.get(pos));
                startActivity(ii);*/
            }
        });

        return view;
    }


    private void filldata(){
        dataobj = new Data();

    }
}