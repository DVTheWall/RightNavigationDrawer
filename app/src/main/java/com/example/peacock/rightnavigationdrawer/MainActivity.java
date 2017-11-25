package com.example.peacock.rightnavigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dataArray_right = new ArrayList<String>();

    ArrayList<Object> objectArray_right = new ArrayList<Object>();

    ArrayList<DataModel> list;

    ArrayList<String> dataArray_left = new ArrayList<String>();

    ArrayList<Object> objectArray_left = new ArrayList<Object>();


    LinearLayoutManager lm;
    DrawerLayout mDrawerlayout;
    // set Right side Recyclerview
    RecyclerView Recycler_right;
    ListView mDrawerList_Left;
    ActionBarDrawerToggle mDrawerToggle;
    ImageButton imgLeftMenu, imgRightMenu;


    ListItemsAdapter_Left Left_Adapter;
    RecyclerAdapter Right_Adapter;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;


        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList_Left = (ListView) findViewById(R.id.drawer_list_left);

        // set Right side Recyclerview
        Recycler_right = (RecyclerView) findViewById(R.id.recycler_right);
         lm = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);

        Recycler_right.setLayoutManager(lm);


        imgLeftMenu = (ImageButton) findViewById(R.id.imgLeftMenu);
        imgRightMenu = (ImageButton) findViewById(R.id.imgRightMenu);


        mDrawerlayout.setDrawerListener(mDrawerToggle);


        //============== Define a Custom Header for Navigation drawer=================//


        LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.header, null);


        imgLeftMenu = (ImageButton) v.findViewById(R.id.imgLeftMenu);
        imgRightMenu = (ImageButton) v.findViewById(R.id.imgRightMenu);

        getSupportActionBar().setHomeButtonEnabled(true);

        //	getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayUseLogoEnabled(false);

        getSupportActionBar().setDisplayShowCustomEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1281A9")));

        getSupportActionBar().setIcon(
                new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        getSupportActionBar().setCustomView(v);

        imgLeftMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (mDrawerlayout.isDrawerOpen(Recycler_right)) {
                    mDrawerlayout.closeDrawer(Recycler_right);
                }
                mDrawerlayout.openDrawer(mDrawerList_Left);
            }
        });


        imgRightMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (mDrawerlayout.isDrawerOpen(mDrawerList_Left)) {
                    mDrawerlayout.closeDrawer(mDrawerList_Left);
                }
                mDrawerlayout.openDrawer(Recycler_right);
            }
        });


        Fill_LeftList();
    //    Fill_RightList();


        list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DataModel data = new DataModel();

            data.setName("Option: " + i);

            list.add(data);
        }

        Recycler_right.setAdapter( new RecyclerAdapter(activity, list));
        RefreshListView();


    }

    public void RefreshListView() {
        objectArray_left.clear();
        for (int i = 0; i < dataArray_left.size(); i++) {
            Object obj = new Object();
            objectArray_left.add(obj);
        }
        Log.d("object array", "" + objectArray_left.size());
        Left_Adapter = new ListItemsAdapter_Left(objectArray_left, 1);
        mDrawerList_Left.setAdapter(Left_Adapter);


//        list.clear();


    }


    public void Fill_LeftList() {

        dataArray_left.clear();


        dataArray_left.add("Option 1");
        dataArray_left.add("Option 2");
        dataArray_left.add("Option 3");
        dataArray_left.add("Option 4");
        dataArray_left.add("Option 5");


    }


    public void Fill_RightList() {


        dataArray_right.clear();

        dataArray_right.add("Option 1");
        dataArray_right.add("Option 2");
        dataArray_right.add("Option 3");
        dataArray_right.add("Option 4");
        dataArray_right.add("Option 5");
    }


    //  ==============   Left Listview Adapter Implementation;=====================//


    private class ListItemsAdapter_Left extends ArrayAdapter<Object> {
        ViewHolder holder1;

        public ListItemsAdapter_Left(List<Object> items, int x) {
            // TODO Auto-generated constructor stub
            super(MainActivity.this, android.R.layout.simple_list_item_single_choice, items);
        }

        @Override
        public String getItem(int position) {
            // TODO Auto-generated method stub
            return dataArray_left.get(position);
        }

        public int getItemInteger(int pos) {
            return pos;

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return dataArray_left.size();
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            LayoutInflater inflator = getLayoutInflater();

            convertView = inflator.inflate(R.layout.data, null);


            holder1 = new ViewHolder();

            holder1.text = (TextView) convertView.findViewById(R.id.txtData);


            holder1.iv = (ImageView) convertView.findViewById(R.id.imgView);


            convertView.setTag(holder1);

            String text = dataArray_left.get(position);
            holder1.text.setText(dataArray_left.get(position));


            return convertView;
        }

    }



/*    private  class  RecyclerAdapter extends {

        Context context;




        public  class  viewHolder extends  RecyclerView.ViewHolder{

            TextView txtData;

            public viewHolder(View itemView) {
                super(itemView);


                txtData = itemView.findViewById(R.id.txtData);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Toast.makeText(context, "Position : " + getAdapterPosition(), Toast.LENGTH_SHORT).show();

                    }
                });

            }


        }
    }*/

/*    //=============Right Listview Adapter Implementation;================//


    private class ListItemsAdapter_Right extends ArrayAdapter<Object>
    {
        ViewHolder holder1;

        public ListItemsAdapter_Right(List<Object>items,int x) {
            // TODO Auto-generated constructor stub
            super(MainActivity.this, android.R.layout.simple_list_item_single_choice, items);
        }

        @Override
        public String getItem(int position) {
            // TODO Auto-generated method stub
            return dataArray_right.get(position);
        }

        public int getItemInteger(int pos)
        {
            return pos;

        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return dataArray_right.size();
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            LayoutInflater inflator=getLayoutInflater();

            convertView=inflator.inflate(R.layout.data, null);



            holder1=new ViewHolder();

            holder1.text=(TextView)convertView.findViewById(R.id.txtData);



            holder1.iv=(ImageView)convertView.findViewById(R.id.imgView);


            convertView.setTag(holder1);

            String text=dataArray_right.get(position);
            holder1.text.setText(dataArray_right.get(position));





            return convertView;
        }

    }*/


    private class ViewHolder {
        TextView text, textcounter;
        ImageView iv;

    }


}