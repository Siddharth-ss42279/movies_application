package com.tabbar;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DataPage extends Activity {
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_page);
		
		Intent i = getIntent();
		String posterPath = i.getStringExtra("posterPath");
		
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.ic_launcher)
		.showImageForEmptyUri(R.drawable.ic_launcher)
		.showImageOnFail(R.drawable.ic_launcher).cacheInMemory(true)
		.cacheOnDisc(true).considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565).build();
		
		ImageLoader imageLoader = ImageLoader.getInstance();
		ImageView img = (ImageView) findViewById(R.id.detailedImg);
		
		
		
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(DataPage.this).build();
		imageLoader.init(config);
		
		
		imageLoader.displayImage("http://image.tmdb.org/t/p/w300"+posterPath,img, options);
		
		
		TextView title = (TextView)findViewById(R.id.detailedTitle);
		
		title.setText(i.getStringExtra("title"));
		TextView overView = (TextView)findViewById(R.id.detailedOverView);
		overView.setText(i.getStringExtra("overView"));
		
		TextView adult = (TextView)findViewById(R.id.detailedAdult);
		adult.setText(i.getStringExtra("adult"));
		TextView popularity = (TextView)findViewById(R.id.detailedPopularity);
		popularity.setText(i.getStringExtra("popularity"));
		TextView releaseDate = (TextView)findViewById(R.id.detailedRelease);
		releaseDate.setText(i.getStringExtra("releaseDate"));
		TextView vote_count = (TextView)findViewById(R.id.detailedVote);
		vote_count.setText(i.getStringExtra("vote_count"));
		TextView avg_count = (TextView)findViewById(R.id.detailedRating);
		avg_count.setText(i.getStringExtra("vote_average"));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data_page, menu);
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
