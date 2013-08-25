package com.example.swagri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectNewOldFincaActivity extends Activity {

	Intent generalIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_new_old_finca);
	}

	public void goNewFincaActivity(View v) {
		generalIntent = new Intent(getApplicationContext(),
				NewFincaActivity.class);
		startActivity(generalIntent);
	}

	public void goOldFincaActivity(View v) {
		generalIntent = new Intent(getApplicationContext(),
				NewFincaActivity.class);
		startActivity(generalIntent);
	}

}
