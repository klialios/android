package com.example.hd384;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class MainActivity {
	Double resistivity=0.023;
	Double Ib=5.0;
	Double cosphi=1.0;
	
	protected void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Spinner spinner = (Spinner) findViewById(R.id.circuit_breaker);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.auto_circuit_breaker, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        
        Spinner spinnerw = (Spinner) findViewById(R.id.wire_section);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterw = ArrayAdapter.createFromResource(this,
                R.array.wire_sections, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterw.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerw.setAdapter(adapterw);
       
       //TextView cable_length =(TextView) findViewById(R.id.cable_length);


       //String Text = spinner.getSelectedItem().toString();

       //cable_length.setText(Text);
       
       
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.max_length) {
        	double I;
	    	double s;
	    	int maxL;
	    	String ss;
	    	TextView cable_length =(TextView) findViewById(R.id.cable_length);
	    	TextView textview1 = (TextView) findViewById(R.id.textView1);
	    	
	    	Spinner spinner = (Spinner) findViewById(R.id.circuit_breaker);
	    	Spinner spinnerw = (Spinner) findViewById(R.id.wire_section);
	    	ss=spinner.getSelectedItem().toString();
	    	I=ss.indexOf("A");
	    	I=Double.valueOf(ss.substring(0, (int)I));
	    	
	    	ss=spinnerw.getSelectedItem().toString();
	    	s=ss.indexOf("mm2");
	    	s=Double.valueOf(ss.substring(0, (int)s));
	    	maxL=(int)(0.8*230*s/(resistivity*2*Ib*I));
	    	
	    	
	    	ss="Μέγιστο μήκος καλωδίου ";
	    	ss += Double.toString(maxL);
	    	ss += " m";
	    	cable_length.setText(ss);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

   	
    	
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio0:
                if (checked)
                    resistivity=0.037;
                
                break;
            case R.id.radio1:
                if (checked)
                	resistivity=0.023;
                break;
            
            case R.id.radioB:
                if (checked)
                	Ib=5.0;
                break;
            case R.id.radioC:
                if (checked)
                	Ib=10.0;
                break;
            case R.id.radioD:
            	if (checked)
            		Ib=20.0;
            	break;
           
        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        boolean single_phase;
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
                if (checked)
                	single_phase=true;
                	
                else
                    // Remove the meat
                break;
            
        }
    }
    

    
    public class SpinnerActivity extends Activity implements OnItemSelectedListener {
    	
    	  public void onItemSelected(AdapterView<?> parent, View view, 
                int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
    		
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
        
        public void setOnIemSelectedListener() {
        Spinner spinner = (Spinner) findViewById(R.id.circuit_breaker);
        Spinner spinnerw = (Spinner) findViewById(R.id.wire_section);
        spinner.setOnItemSelectedListener(this);
        spinnerw.setOnItemSelectedListener(this);
        }
        
    }
}
