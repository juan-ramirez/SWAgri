package com.example.swagri;
import android.widget.EditText;
import java.util.regex.Pattern;


public class ValidationHelper {

	//Codigo goliado de otra parte (en parte)
	 // Regular Expression
    // you can change the expression based on your need
    //private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
	private static final String PHONE_REGEX = "\\d{7}";
    private static final String CODIGOFINCA_REGEX = "\\d{10}";
    private static final String MATRICULAINMOBILIARIA_REGEX = "\\w{10}";

    
    // Error Messages
    private static final String REQUIRED_MSG = "Requerido, no debe estar en blanco";
    private static final String PHONE_MSG = "Debe ser un teléfono de 7 dígitos, seguidos";
    private static final String CODIGOFINCA_MSG ="Debe ser un código de 10 dígitos";
    private static final String MATRICULAINMOBILIARIA_MSG = "Debe ser un código de 10 dígitos";
 
 
    // call this method when you need to check phone number validation
    public static boolean isPhoneNumber(EditText editText, boolean required) {
        return isValid(editText, PHONE_REGEX, PHONE_MSG, required);
    }
    
    //this method checks finca's code is right
    public static boolean isCodigoFinca(EditText editText, boolean required) {
        return isValid(editText, CODIGOFINCA_REGEX, CODIGOFINCA_MSG, required);
    }

    //same check for matricula inmobiliaria
    public static boolean isMatriculaInmobiliaria(EditText editText, boolean required) {
        return isValid(editText, MATRICULAINMOBILIARIA_REGEX, MATRICULAINMOBILIARIA_MSG, required);
    }
 
    // return true if the input field is valid, based on the parameter passed, when Regex are needed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {
 
        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);
 
        // text required and editText is blank, so return false
        if ( required && !hasText(editText) ) return false;
 
        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };
 
        return true;
    }
    
 // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, int numberCharacters, String errMsg, boolean required) {
 
        // clearing the error, if it was previously set by some other values
        editText.setError(null);
 
        // text required and editText is blank, so return false
        if ( required && !hasText(editText) ) return false;
 
        // pattern doesn't match so returning false
        if (editText.getText().toString().length() >= numberCharacters) {
            editText.setError(errMsg);
            return false;
        };
 
        return true;
    }
    
 // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {
 
        String text = editText.getText().toString().trim();
        editText.setError(null);
 
        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }
 
        return true;
    }

    


}