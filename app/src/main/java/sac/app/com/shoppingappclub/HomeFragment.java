package sac.app.com.shoppingappclub;

/**
 * Created by Android on 27-05-2015.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    GridView gridView;

    public HomeFragment() {
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

        gridView = (GridView)view.findViewById(R.id.gridView);

        ArrayList<String> img = new ArrayList<>();
        img.add("flipkart");
        img.add("amazon");
        img.add("sanpdeal");
        img.add("paytm");

        img.add("myntra");
        img.add("jabong");
        img.add("justeat");
        img.add("greendust");


        img.add("yepme");
        img.add("ticketgoose");
        img.add("babyoye");
        img.add("freecharge");

        CustomImageAdapter adp = new CustomImageAdapter(getActivity(),img);
        gridView.setAdapter(adp);





        return view;
    }

    class CustomImageAdapter extends BaseAdapter {
        LayoutInflater layoutInflator;
        private Context ctx;
        ArrayList<String>  images;
        public CustomImageAdapter(Context ctx,ArrayList<String> img){
            this.ctx = ctx;
            this.images=img;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public Object getItem(int position) {
            return 0;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = convertView;
            view = layoutInflator.inflate(R.layout.grid_item, parent, false);

            ImageView imageView = (ImageView)view.findViewById(R.id.imgIcon);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            //TextView txtSubtitle= (TextView) view.findViewById(R.id.txtSubtitle);
            //txtSubtitle.setText(nutritionData.get(position).name);

            // Log.e("id",nutritionData.get(position).nutritional_guideline_id);


            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;

            String imgName = images.get(position);
            int resId = ctx.getResources().getIdentifier(imgName, "drawable", ctx.getPackageName());

            Glide.with(ctx)
                    .load(resId)
                    .into(imageView);
            //imageView.setImageResource(R.mipmap.ic_launcher);

            return view;


        }
    }


  /*  @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.txt1:
                callWebview(9);
                break;
            case R.id.txt2:
                callWebview(0);
                break;
            case R.id.txt3:
                callWebview(32);
                break;
            case R.id.txt4:
                callWebview(26);
                break;
            case R.id.txt5:
                callWebview(25);
                break;
            case R.id.txt6:
                callWebview(19);
                break;
            case R.id.txt7:
                callWebview(21);
                break;
            case R.id.txt8:
                callWebview(14);
                break;
            case R.id.txt9:
                callWebview(39);
                break;
            case R.id.txt10:
                callWebview(33);
                break;
            case R.id.txt11:
                callWebview(1);
                break;
            case R.id.txt12:
                callWebview(6);
                break;
        }
    }*/


    void callWebview(int pos){
        Data obj = new Data();
      /*  Intent ii = new Intent(getActivity(), webview.class);
        ii.putExtra("url", obj.links.get(pos));
        startActivity(ii);*/

        Bundle bnd = new Bundle();
        bnd.putString("url", obj.links.get(pos));

        FragmentManager manager1 = getActivity().getSupportFragmentManager();
        FragmentTransaction ft1 = manager1.beginTransaction();

        WebViewFragment web = new WebViewFragment();
        web.setArguments(bnd);
        ft1.replace(R.id.main_container, web);

        ft1.addToBackStack("");
        ft1.commit();
    }
}