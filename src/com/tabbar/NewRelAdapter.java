package com.tabbar;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class NewRelAdapter extends BaseAdapter{
	
	private LayoutInflater inflater;
	Activity _context;
	List<TopRatedDAta>topRatedList ;
	ImageLoader imageLoader = ImageLoader.getInstance();
	ImageLoaderConfiguration imageconfig;
	ImageLoaderConfiguration imageconf;
	ImageLoaderConfiguration imageconft;

	DisplayImageOptions options = new DisplayImageOptions.Builder()
			.showImageOnLoading(R.drawable.ic_launcher)
			.showImageForEmptyUri(R.drawable.ic_launcher)
			.showImageOnFail(R.drawable.ic_launcher).cacheInMemory(true)
			.cacheOnDisc(true).considerExifParams(true)
			.bitmapConfig(Bitmap.Config.RGB_565).build();

	public NewRelAdapter(Tab1 tab, List<TopRatedDAta> topRatedList) {
		// TODO Auto-generated constructor stub
		this._context = tab;
		this.topRatedList=topRatedList;
		inflater = _context.getLayoutInflater();
		imageconfig = new ImageLoaderConfiguration.Builder(_context).build();
		imageLoader.init(imageconfig);
	}



	public NewRelAdapter(Tab2 tab2, List<TopRatedDAta> topRatedList2) {
		// TODO Auto-generated constructor stub
		this._context =  tab2;
		this.topRatedList=topRatedList2;
		inflater = _context.getLayoutInflater();
		imageconf = new ImageLoaderConfiguration.Builder(_context).build();
		imageLoader.init(imageconf);
	}
public NewRelAdapter(Tab3 tab3, List<TopRatedDAta> topRatedList3) {
		// TODO Auto-generated constructor stub
	this._context = tab3;
	this.topRatedList=topRatedList3;
	inflater = _context.getLayoutInflater();
	imageconft = new ImageLoaderConfiguration.Builder(_context).build();
	imageLoader.init(imageconft);
	}





public NewRelAdapter(Tab4 tab4, List<TopRatedDAta> topRatedList2) {
	// TODO Auto-generated constructor stub
	this._context = tab4;
	this.topRatedList=topRatedList2;
	inflater = _context.getLayoutInflater();
	imageconft = new ImageLoaderConfiguration.Builder(_context).build();
	imageLoader.init(imageconft);
}



@Override
public void notifyDataSetChanged() {
	// TODO Auto-generated method stub
	//super.notifyDataSetChanged();
}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (topRatedList!= null && topRatedList.size()!=0) {
			return topRatedList.size();
		}else {
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int Lastposition = -1;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder _holder = null;
		if (convertView == null) {
			_holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.row_album, null);
			_holder._albumImg = (ImageView) convertView
					.findViewById(R.id.albumImage);
			_holder._albumText = (TextView) convertView
					.findViewById(R.id.album_txt_01);
			_holder.releaseDate = (TextView) convertView
					.findViewById(R.id.album_txt_02);
			
			_holder.vote_count = (TextView) convertView
					.findViewById(R.id.album_txt_03);
			convertView.setTag(_holder);
		} else {
			_holder = (ViewHolder) convertView.getTag();
		}
		if (topRatedList!=null&&topRatedList.size()!=0) {
			_holder._albumText.setText(topRatedList.get(position).getTitle());
			_holder.releaseDate.setText(topRatedList.get(position).getRealeseDate());
			
			_holder.vote_count.setText(topRatedList.get(position).getVote_count());
			imageLoader.displayImage("http://image.tmdb.org/t/p/w300"+topRatedList.get(position).getPosterPAth(),
					_holder._albumImg, options);
			
			
		}
		View view =convertView;
		 Animation animation = AnimationUtils.loadAnimation(getContext(), (position > Lastposition) ? R.anim.up_from_bottom : R.anim.down_from_top);
		    view.startAnimation(animation);
		
		
		return convertView;
	}
	
	private Context getContext() {
		// TODO Auto-generated method stub
		return _context;
	}

	private static class ViewHolder {
		private ImageView _albumImg;
		private TextView _albumText, releaseDate,vote_count;
		
	}

}
