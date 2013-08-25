package com.example.swagri;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText etxtUser;
	private EditText etxtPassword;
	private String user;
	private String password;
	private SQLiteDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		DataBaseHelper dbHelper = new DataBaseHelper(this);

		try {
			dbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
		try {
			dbHelper.openDataBase();
		} catch (SQLException sqle) {
			throw sqle;
		}

		database = dbHelper.myDataBase;

		initializeObjects();

	}

	private void initializeObjects() {
		etxtUser = (EditText) findViewById(R.id.etxtUser);
		etxtPassword = (EditText) findViewById(R.id.etxtPassword);

	}

	public void doLogin(View v) {
		validateUser();
	}

	private void validateUser() {
		getCredentials();
		if (!checkEmpty()) {
			if (validateCredentials()) {
				Intent generalIntent = new Intent(getApplicationContext(),
						SelectNewOldFincaActivity.class);
				startActivity(generalIntent);
				database.close();
				finish();
			} else {
				etxtUser.setText("");
				etxtPassword.setText("");
				Toast.makeText(this, "Usuario o contraseña erróneos",
						Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(this,
					"Usuario o contraseña vacíos por favor ingréselos",
					Toast.LENGTH_SHORT).show();
		}

	}

	private boolean validateCredentials() {
		String query = "select * from user where user_name = '" + user
				+ "' and password = '" + password + "'";
		Cursor c = database.rawQuery(query, null);
		c.moveToFirst();
		if (c.getCount() > 0) {
			c.close();
			return true;
		} else {
			c.close();
			return false;
		}
	}

	private void getCredentials() {
		user = etxtUser.getText().toString();
		password = etxtPassword.getText().toString();

	}

	private boolean checkEmpty() {
		return etxtUser.equals("") || etxtPassword.equals("");
	}

}
