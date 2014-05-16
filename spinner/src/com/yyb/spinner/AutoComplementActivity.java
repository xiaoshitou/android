package com.yyb.spinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.media.audiofx.AutomaticGainControl;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class AutoComplementActivity extends Activity {

	private AutoCompleteTextView autoCompleteTextView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_autocom);
		initComponents();
//		ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
//	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//第二种方法，动态创建adapter
		List<String> list=new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.add("457");
		list.add("126");
		ArrayAdapter adapter  = new ArrayAdapter(this, R.layout.items,R.id.textviewId, list);
		autoCompleteTextView.setAdapter(adapter);
	    
	}
	private void initComponents() {
		autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
	}
	
}
