package com.tabbar;

import com.tabbar.R.style;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class MainActivity extends TabActivity   {

	 TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tabHost = getTabHost();
		
		//tabHost.setOnTabChangedListener(MainActivity.this);
	       
        TabHost.TabSpec spec;
        Intent intent;
        
        
        intent = new Intent().setClass(MainActivity.this, Tab1.class);
        spec = tabHost.newTabSpec("First").setIndicator("TopRated")
                      .setContent(intent);
       
        tabHost.addTab(spec);
        
        /************* TAB2 ************/
        intent = new Intent().setClass(MainActivity.this, Tab2.class);
        spec = tabHost.newTabSpec("Second").setIndicator("UpComing")
                      .setContent(intent);  
        tabHost.addTab(spec);
   
        /************* TAB3 ************/
        intent = new Intent().setClass(MainActivity.this, Tab3.class);
        spec = tabHost.newTabSpec("Third").setIndicator("Popular")
                      .setContent(intent);
        tabHost.addTab(spec);

        
        intent = new Intent().setClass(MainActivity.this, Tab4.class);
        spec = tabHost.newTabSpec("Fourth").setIndicator("nowplaying")
                      .setContent(intent);
        tabHost.addTab(spec);
        // Set Tab1 as Default tab
        
        tabHost.getTabWidget().setCurrentTab(0);
        
        //tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.images);
        
        
        //tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.images);
        //tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.images);
           
        
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



	
	/*@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab1);
            else if(i==1)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab2);
            else if(i==2)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab3);
        }
         
         
        Log.i("tabs", "CurrentTab: "+tabHost.getCurrentTab());
         
    if(tabHost.getCurrentTab()==0)
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab1_over);
    else if(tabHost.getCurrentTab()==1)
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab2_over);
    else if(tabHost.getCurrentTab()==2)
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab3_over);
         
	}*/



	public void onTabChanged(String tabId) {

        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FF0000")); // unselected
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
            tv.setTextColor(Color.parseColor("#144C4D"));
        }

        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#144C4D")); // selected
        TextView tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
        tv.setTextColor(Color.parseColor("#0080FF"));

    }
	
}
