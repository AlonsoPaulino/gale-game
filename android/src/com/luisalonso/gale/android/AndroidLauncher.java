package com.luisalonso.gale.android;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.luisalonso.gale.GaleGame;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new GaleGame() {
			@Override
			public void share() {
				Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		        sharingIntent.setType("text/plain");
		        String sharingText = "Find out playing this game! " +
		                getString(R.string.app_url, getPackageName());
		        sharingIntent.putExtra(Intent.EXTRA_TEXT, sharingText);
		        startActivity(Intent.createChooser(sharingIntent, "Share using"));
				super.share();
				super.share();
			}
		}, config);
	}
}
