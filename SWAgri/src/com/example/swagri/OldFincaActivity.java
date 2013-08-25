package com.example.swagri;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class OldFincaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_old_finca);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.old_finca, menu);
		return true;
	}

}
