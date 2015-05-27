package sac.app.com.shoppingappclub;

/**
 * Created by Android on 27-05-2015.
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MyDrawerActivity extends ActionBarActivity {


    //  private ButtonRectangle btnLogout;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftDrawerList;
    private ArrayAdapter<String> navigationDrawerAdapter;
    private String[] leftSliderData = {"Home", "Profile", "My Recipient", "About Us", "Contact Us", "How It Works", "FAQ", "Settings", "Logout"};
/*
    private int[] imagelist = {R.drawable.icon_home,
            R.drawable.icon_editprofile2,
            R.drawable.icon_myrecipient,
            R.drawable.icon_aboutus,
            R.drawable.icon_contactus,
            R.drawable.icon_how_it_works,
            R.drawable.icon_faq,
            R.drawable.icon_setting,
            R.drawable.icon_logout};*/


    public ProgressBar pb_toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drawer);
        nitView();


        if (toolbar != null) {
            toolbar.setTitle(getResources().getString(R.string.app_name));
            setSupportActionBar(toolbar);
        }


        initDrawer();


       /* Intent i = new Intent(MyDrawerActivity.this, MainActivity.class);
        startActivity(i);*/


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.main_container, new BlankFragment());
        ft.commit();


    }




    private void nitView() {


        //  btnLogout = (ButtonRectangle)findViewById(R.id.btnLogout);
        leftDrawerList = (ListView) findViewById(R.id.left_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#494949"));
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        navigationDrawerAdapter = new ArrayAdapter<String>(MyDrawerActivity.this, android.R.layout.simple_list_item_activated_1, android.R.id.text1, leftSliderData);
        leftDrawerList.setAdapter(new lViewadapter());


        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.TOP | Gravity.RIGHT);


        layoutParams.width = (int) AppUtils.convertDpToPixel(32,MyDrawerActivity.this);
        layoutParams.height = (int)AppUtils.convertDpToPixel(32,MyDrawerActivity.this);
        layoutParams.rightMargin = 16;


        pb_toolbar = new ProgressBar(MyDrawerActivity.this);
        pb_toolbar.setVisibility(View.GONE);
        toolbar.addView(pb_toolbar, layoutParams);
        pb_toolbar.setLayoutParams(layoutParams);





        leftDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawers();
                FragmentManager fm = getSupportFragmentManager();
                switch (position) {


                    case 0:
                        Toast.makeText(MyDrawerActivity.this,"Clicked 1",Toast.LENGTH_SHORT).show();


                     /*   FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction ft = manager.beginTransaction();
                        ft.replace(R.id.main_container, new MyAccountFragment(), "MA");
                        // ft.addToBackStack("");
                        ft.commit();

                        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                            fm.popBackStack();
                        }*/


                        break;
                    case 1:


//                        FragmentManager manager1 = getSupportFragmentManager();
//                        FragmentTransaction ft1 = manager1.beginTransaction();
//                        ft1.replace(R.id.main_container, new Profile());
//                       // ft1.addToBackStack("");
//                        ft1.commit();
//                        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
//                            fm.popBackStack();
//                        }
                        break;
                    case 2:


                        /*FragmentManager manager22 = getSupportFragmentManager();
                        FragmentTransaction ft22 = manager22.beginTransaction();
                        ft22.replace(R.id.main_container, new MyRecipient_home());
                       // ft22.addToBackStack("");
                        ft22.commit();
                        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                            fm.popBackStack();
                        }*/


                        break;
                    case 3:


                   /*     FragmentManager manager2 = getSupportFragmentManager();
                        FragmentTransaction ft2 = manager2.beginTransaction();
                        ft2.replace(R.id.main_container, new Aboutus());
                       // ft2.addToBackStack("");
                        ft2.commit();
                        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                            fm.popBackStack();
                        }*/
                        break;
                }


            }
        });
    }


    public void showToolLoading() {


        pb_toolbar.setVisibility(View.VISIBLE);
    }


    public void hideToolLoading() {
        pb_toolbar.setVisibility(View.GONE);
    }


    public class lViewadapter extends BaseAdapter {
        @Override
        public int getCount() {
            return leftSliderData.length;
        }


        @Override
        public Object getItem(int position) {
            return null;
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row;
            row = inflater.inflate(R.layout.mydrawer_listview_layout, parent, false);
            TextView title = (TextView) row.findViewById(R.id.txtTitle);
        /*    ImageView img_icon = (ImageView) row.findViewById(R.id.imgIcon);
            img_icon.setBackgroundResource(imagelist[position]);
            img_icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
         */   title.setText(leftSliderData[position]);
            title.setTextSize(20);
            return row;
        }
    }


    public void setToolColor(int color) {
        toolbar.setBackgroundColor(color);
    }


    public void setToolTitle(String title) {
        toolbar.setTitle(title);
    }


    public void setToolSubTitle(String subTitle) {


        toolbar.setSubtitle(subTitle);
    }


    public Toolbar getToolBar() {
        return this.toolbar;
    }




    private void initDrawer() {


        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);


            }


            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}