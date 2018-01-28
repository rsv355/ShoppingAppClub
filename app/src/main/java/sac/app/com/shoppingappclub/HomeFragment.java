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
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tfc.webviewer.ui.WebViewerActivity;
import com.thefinestartist.finestwebview.FinestWebView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    EditText etSearchBox;
    GridView gridView;
    TextView txtBottom;
    DatabaseHandler mDatabaseHandler;

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


        mDatabaseHandler = new DatabaseHandler(getActivity());

        etSearchBox = (EditText) view.findViewById(R.id.etSearchBox);
        gridView = (GridView) view.findViewById(R.id.gridView);
        txtBottom = (TextView) view.findViewById(R.id.txtBottom);
        txtBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager1 = getActivity().getSupportFragmentManager();
                FragmentTransaction ft1 = manager1.beginTransaction();
                ft1.replace(R.id.main_container, new SubFragment());
                ft1.addToBackStack("");
                ft1.commit();
            }
        });


        ArrayList<ShopModel> DBM = new ArrayList<>();
        try {
            DatabaseHandler mDatabaseHandler = new DatabaseHandler(getActivity());
            mDatabaseHandler.openDataBase();
            DBM = mDatabaseHandler.getHomeShopItem(getActivity());

            mDatabaseHandler.close();

        } catch (Exception e) {
        }


        final CustomImageAdapter adp = new CustomImageAdapter(getActivity(), DBM);
        gridView.setAdapter(adp);


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

    class CustomImageAdapter extends BaseAdapter implements Filterable {
        LayoutInflater layoutInflator;
        private Context ctx;
        ArrayList<ShopModel> images;
        private ArrayList<ShopModel> mStringFilterList;

        public CustomImageAdapter(Context ctx, ArrayList<ShopModel> img) {
            this.ctx = ctx;
            this.images = img;
            this.mStringFilterList = img;
        }

        @Override
        public int getCount() {
            return mStringFilterList.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            layoutInflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = convertView;
            view = layoutInflator.inflate(R.layout.grid_item, parent, false);

            ImageView imageView = (ImageView) view.findViewById(R.id.imgIcon);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            //TextView txtSubtitle= (TextView) view.findViewById(R.id.txtSubtitle);
            //txtSubtitle.setText(nutritionData.get(position).name);

            // Log.e("id",nutritionData.get(position).nutritional_guideline_id);

            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 8;

                String imgName = mStringFilterList.get(position).Image;
                Log.e("imageName", imgName);

                if (imgName != "") {
                    int resId = ctx.getResources().getIdentifier(imgName, "drawable", ctx.getPackageName());

                    Glide.with(ctx)
                            .load(resId)
                            .into(imageView);

                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            openWebView(mStringFilterList.get(position).Url);
                        }
                    });
                } else {
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }
            } catch (Exception e) {
            }       //imageView.setImageResource(R.mipmap.ic_launcher);

            return view;


        }


        void openWebView(String url) {


           Intent intent = new Intent(getActivity(), WebViewerActivity.class);
            intent.putExtra(WebViewerActivity.EXTRA_URL, url);
            startActivity(intent);


   /* new FinestWebView.Builder(getActivity())
                    .toolbarScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS)
                    .gradientDivider(false)
                    .iconDisabledColorRes(R.color.gray)
                    .backPressToClose(false)
                    .setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit)
                    .show(url);
*/

       /*    Intent ii = new Intent(getActivity(), WebViewActivity.class);
        ii.putExtra("url", url);
        startActivity(ii);*/

            /*Bundle bnd = new Bundle();
            bnd.putString("url", url);

            FragmentManager manager1 = getActivity().getSupportFragmentManager();
            FragmentTransaction ft1 = manager1.beginTransaction();

            WebViewFragment web = new WebViewFragment();
            web.setArguments(bnd);
            ft1.replace(R.id.main_container, web);

            ft1.addToBackStack("");
            ft1.commit();*/
        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    String charString = charSequence.toString();
                    if (charString.equalsIgnoreCase("0")) {
                        mStringFilterList = images;
                    } else {
                        ArrayList<ShopModel> filteredList = new ArrayList<>();
                        for (ShopModel row : images) {

                            // name match condition. this might differ depending on your requirement
                            // here we are looking for name or phone number match
                            if (row.Name.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                                filteredList.add(row);
                            }
                        }

                        mStringFilterList = filteredList;
                    }

                    FilterResults filterResults = new FilterResults();
                    filterResults.values = mStringFilterList;
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    mStringFilterList = (ArrayList<ShopModel>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
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



    void callWebview(int pos) {
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