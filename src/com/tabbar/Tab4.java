package com.tabbar;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Tab4 extends Activity {
	
	List<TopRatedDAta> topRatedList = new ArrayList<TopRatedDAta>();
	private ListView mainList;
	Activity context;
	private Handler mHandler = null;
	private LayoutInflater inflater;
	boolean loadingMore;
	private NewRelAdapter mainListAdapter;
	//View footer;
	private ProgressDialog dialog = null;
	int pageNo = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab4);
		
		mainList = (ListView) findViewById(R.id.listView4);
		//footer = inflater.inflate(R.layout.footer, null);
		mHandler = new Handler();
		//get TopRated Movie and set on listview....
		setTopRatedList();
	}

	private void setTopRatedList() {
		// TODO Auto-generated method stub
		
		
		try {

			dialog = ProgressDialog.show(Tab4.this, "",
					"Loading content please wait...");
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					JSONData h = new JSONData(Tab4.this);
					try {
						if (Utlity.isOnline(Tab4.this)) {
							
							
							topRatedList = h.getAlbumList(pageNo,"now_playing");
							
							if (topRatedList == null) {
								Log.d("albumlist is null", "-111");
								mHandler.post(new Runnable() {
									@Override
									public void run() {
										Toast.makeText(Tab4.this,	"No Data Found",Toast.LENGTH_LONG).show();
										if (dialog != null && dialog.isShowing())
											dialog.dismiss();
										loadingMore = false;
										mainListAdapter = new NewRelAdapter(Tab4.this,topRatedList);
										
										mainList.setAdapter( mainListAdapter);
										mainListAdapter.notifyDataSetChanged();

									}
								});
							} else {
								mHandler.post(new Runnable() {
									

									@Override
									public void run() {
										if (dialog != null && dialog.isShowing())
											dialog.dismiss();
										
										
                                        mainListAdapter = new NewRelAdapter(Tab4.this,topRatedList);
										
										mainList.setAdapter(mainListAdapter);
										mainListAdapter.notifyDataSetChanged();
										
										
										mainList.setOnItemClickListener(new OnItemClickListener() {

										

											@Override
											public void onItemClick(AdapterView<?> parent, View view, int position,
													long id) {
												
												if(position < topRatedList.size())
												{
													Intent i = new Intent(Tab4.this,DataPage.class);
													i.putExtra("title", topRatedList.get(position).getTitle().toString());
													i.putExtra("adult", topRatedList.get(position).getAdult().toString());
													i.putExtra("overView", topRatedList.get(position).getOverView().toString());
													i.putExtra("popularity", topRatedList.get(position).getPopularity().toString());
													i.putExtra("releaseDate", topRatedList.get(position).getRealeseDate().toString());
													i.putExtra("posterPath", topRatedList.get(position).getPosterPAth().toString());
													i.putExtra("vote_count", topRatedList.get(position).getVote_count().toString());
													i.putExtra("vote_average", topRatedList.get(position).getVote_average().toString());
													startActivity(i);	
																						
												}
												
												
											}

											private Context getContext() {
												// TODO Auto-generated method stub
												return context;
											}
										});
										
									}
								});
							}
						}else{
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(Tab4.this,	"No Network Detected",Toast.LENGTH_LONG).show();
									dialog.dismiss();
								}
							});
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab4, menu);
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
}
