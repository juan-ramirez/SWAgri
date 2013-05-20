package com.example.swagri;

import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewFincaActivity extends Activity {
	
	private EditText etNombreFinca;
	private EditText etCodigoFinca;
	private EditText etMatriculaInmobiliaria;
	private EditText etDireccionFinca;
	private EditText etTelefonoFinca;
	private EditText etExtensionFinca;
	private EditText etNumeroLotes;
	private Button btnCrear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_finca);
		
		assignEditTexts();
		
		btnCrear = (Button) findViewById(R.id.btnCrearFinca);
		btnCrear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(Validate()){
					submitForm();
				}else{
					Toast.makeText(NewFincaActivity.this, "Existen errores en el formulario", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	private void assignEditTexts(){
		etNombreFinca = (EditText) findViewById(R.id.etNombreFinca);
		etCodigoFinca = (EditText) findViewById(R.id.etCodigoFinca);
		etMatriculaInmobiliaria = (EditText) findViewById(R.id.etMatriculaInmobiliaria);
		etDireccionFinca = (EditText) findViewById(R.id.etDireccionFinca);
		etTelefonoFinca = (EditText) findViewById(R.id.etTelefonoFinca);
		etExtensionFinca = (EditText) findViewById(R.id.etExtensionFinca);
		etNumeroLotes = (EditText) findViewById(R.id.etNumeroLotes);
	}
	
	private boolean Validate(){
		boolean ret = true;
		
		if(!ValidationHelper.isValid(etNombreFinca, 45, "El nombre de la finca no es válido", true)) ret = false;
		if(!ValidationHelper.isCodigoFinca(etCodigoFinca, true)) ret = false;
		if(!ValidationHelper.isMatriculaInmobiliaria(etMatriculaInmobiliaria, true)) ret = false;
		if(!ValidationHelper.isValid(etDireccionFinca, 45, "La dirección de la finca no es válida", true)) ret = false;
		if(!ValidationHelper.isPhoneNumber(etTelefonoFinca, true)) ret = false;
		if(!ValidationHelper.isValid(etExtensionFinca, 8, "La extensión de la finca es muy grande", true)) ret = false;
		if(!ValidationHelper.isValid(etNumeroLotes, 10, "Hay un error en el número de lotes de la finca", true)) ret = false;
		
		
		return ret;
	}
	
	private void submitForm(){
		String dataArray[] =  { etNombreFinca.getText().toString(), etCodigoFinca.getText().toString(), 
								etMatriculaInmobiliaria.getText().toString(), etDireccionFinca.getText().toString(), 
								etTelefonoFinca.getText().toString(), etExtensionFinca.getText().toString(), 
								etNumeroLotes.getText().toString() };
		
		Toast.makeText(this, "Creando finca", Toast.LENGTH_LONG).show();
		System.out.println("arr: " + Arrays.toString(dataArray));
		
	}
	
	

}
