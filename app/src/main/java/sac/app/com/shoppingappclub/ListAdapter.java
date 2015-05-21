package sac.app.com.shoppingappclub;

/**
 * Created by Krishna on 30-04-2015.
 */
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class ListAdapter extends BaseAdapter {
    LayoutInflater layoutInflator;
    private Context ctx;
   Data value;
    public ListAdapter(Context ctx,Data obj){
        this.ctx = ctx;
        this.value = obj;
    }

    @Override
    public int getCount() {
        return value.names.size();
    }

    @Override
    public Object getItem(int i) {
        return value.names.get(i);
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


       // Typeface tf = Typeface.createFromAsset(ctx.getAssets(),"fonts/Gabriela-Regular.ttf");
        //txt.setTypeface(tf,Typeface.BOLD);
       txt.setText(value.names.get(position));


   //    String imgName = images.get(position);
     //  int resId = ctx.getResources().getIdentifier(imgName, "drawable", ctx.getPackageName());

       //icon.setBackgroundResource(resId);

        return view;
    }
}