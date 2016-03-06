package com.tabbar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utlity {

	public static boolean isOnline(Context ct) {
		// TODO Auto-generated method stub
		ConnectivityManager cm = (ConnectivityManager)ct.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}

}
