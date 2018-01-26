package sac.app.com.shoppingappclub;

/**
 * Created by Krishna on 30-04-2015.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import android.util.Log;

import com.bumptech.glide.Glide;

class ListAdapter extends BaseAdapter {
    LayoutInflater layoutInflator;
    private Context ctx;
    ArrayList<ShopModel> value;
    public ListAdapter(Context ctx,  ArrayList<ShopModel> obj){
        this.ctx = ctx;
        this.value = obj;


    }

    @Override
    public int getCount() {
        return value.size();
    }

    @Override
    public Object getItem(int i) {
        return value.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        layoutInflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView;
        view = layoutInflator.inflate(R.layout.list_item, viewGroup, false);

       TextView txt = (TextView)view.findViewById(R.id.txt1);
       ImageView icon = (ImageView)view.findViewById(R.id.imgIcon);


//        Typeface tf = Typeface.createFromAsset(ctx.getAssets(),"fonts/f1.ttf");
   //     txt.setTypeface(tf,Typeface.BOLD);
        txt.setText(value.get(position).Name);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;

        String imgName = value.get(position).Image;
         int resId = ctx.getResources().getIdentifier(imgName, "drawable", ctx.getPackageName());

        Bitmap  temp =    BitmapFactory.decodeResource(ctx.getResources(), resId);

       // Bitmap preview_bitmap = BitmapFactory.decodeStream(temp, null, options);

        Glide.with(ctx)
                .load(resId)
                .into(icon);
       // icon.setImageBitmap(temp);

        System.gc();

        return view;
    }
}