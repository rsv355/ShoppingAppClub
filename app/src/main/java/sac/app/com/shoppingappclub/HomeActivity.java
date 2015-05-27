package sac.app.com.shoppingappclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;

import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.CurlEffect;


public class HomeActivity extends ActionBarActivity {
   Data dataobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filldata();
        JazzyListView list = (JazzyListView) findViewById(R.id.list);

        //slideeffect is good;FadeEffect()
        list.setTransitionEffect(new CurlEffect());

        ListAdapter adp = new ListAdapter(HomeActivity.this,dataobj);
        list.setAdapter(adp);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Data obj = new Data();

                Intent ii = new Intent(HomeActivity.this, webview.class);
                ii.putExtra("url", obj.links.get(pos));
                startActivity(ii);
            }
        });
    }

    private void filldata(){
        dataobj = new Data();

    }
}
