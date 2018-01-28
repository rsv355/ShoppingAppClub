package sac.app.com.shoppingappclub;

/**
 * Created by Krishna on 30-04-2015.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.tfc.webviewer.ui.WebViewerActivity;

class ListAdapter extends BaseAdapter implements Filterable{
    LayoutInflater layoutInflator;
    private Context ctx;
    ArrayList<ShopModel> value;
    ArrayList<ShopModel> mStringFilterList;
    public ListAdapter(Context ctx,  ArrayList<ShopModel> obj){
        this.ctx = ctx;
        this.value = obj;
        this.mStringFilterList = obj;


    }

    @Override
    public int getCount() {
        return mStringFilterList.size();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        layoutInflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView;
        view = layoutInflator.inflate(R.layout.list_item, viewGroup, false);

       TextView txt = (TextView)view.findViewById(R.id.txt1);
       ImageView icon = (ImageView)view.findViewById(R.id.imgIcon);
        LinearLayout liRow = (LinearLayout)view.findViewById(R.id.liRow);

//        Typeface tf = Typeface.createFromAsset(ctx.getAssets(),"fonts/f1.ttf");
   //     txt.setTypeface(tf,Typeface.BOLD);
        txt.setText(mStringFilterList.get(position).Name);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;

        String imgName = mStringFilterList.get(position).Image;
         int resId = ctx.getResources().getIdentifier(imgName, "drawable", ctx.getPackageName());

        Bitmap  temp =    BitmapFactory.decodeResource(ctx.getResources(), resId);

       // Bitmap preview_bitmap = BitmapFactory.decodeStream(temp, null, options);

        Glide.with(ctx)
                .load(resId)
                .into(icon);
       // icon.setImageBitmap(temp);


        liRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, WebViewerActivity.class);
                intent.putExtra(WebViewerActivity.EXTRA_URL, mStringFilterList.get(position).Url);
                ctx.startActivity(intent);
            }
        });

        System.gc();

        return view;
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.equalsIgnoreCase("0")) {
                    mStringFilterList = value;
                } else {
                    ArrayList<ShopModel> filteredList = new ArrayList<>();
                    for (ShopModel row : value) {

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