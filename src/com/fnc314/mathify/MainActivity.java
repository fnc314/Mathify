package com.fnc314.mathify;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.main_view, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void mathify(View view) {
//		Find and extract user inputs
		EditText num1text=(EditText)findViewById(R.id.num1);
		EditText num2text=(EditText)findViewById(R.id.num2);
//		Convert user input to integers for arithmetic manipulation
		Integer num1=Integer.parseInt(num1text.getText().toString());
		Integer num2=Integer.parseInt(num2text.getText().toString());
		
		addInputs(num1, num2);

		differenceInputs(num1, num2);

		multiplyInputs(num1, num2);
		
		quotientInputs(num1, num2);

		moduloInputs(num1, num2);
	}
	
	public void addInputs(Integer num1, Integer num2) {
		Integer sum=num1+num2;
		TextView addition=(TextView)findViewById(R.id.sum);
		addition.setText("Sum ("+num1+" + "+num2+"): " + sum);
	}
	
	public void differenceInputs(Integer num1, Integer num2) {
		Integer diff=Math.abs(num1-num2);
		TextView difference=(TextView)findViewById(R.id.diff);
		difference.setText("Difference (|"+num1+" - "+num2+"|): " + diff);
	}
	
	public void multiplyInputs(Integer num1, Integer num2) {
		Integer prod=num1 * num2;
		TextView product=(TextView)findViewById(R.id.prod);
		product.setText("Product ("+num1+" x "+num2+"): " + prod);
	}
	
	public void quotientInputs(Integer num1, Integer num2) {
		Double quot1= num1.doubleValue() / num2.doubleValue();
		TextView quotient1=(TextView)findViewById(R.id.quot1);
		quotient1.setText("Quotient 1 ("+num1+"/"+num2+"): "+quot1);
		
		Double quot2= num2.doubleValue() / num1.doubleValue();
		TextView quotient2=(TextView)findViewById(R.id.quot2);
		quotient2.setText("Quotient 2 ("+num2+"/"+num1+"): "+quot2);
	}
	
	public void moduloInputs(Integer num1, Integer num2) {
		Integer mod1 = num1 % num2;
		TextView modular1=(TextView)findViewById(R.id.mod1);
		modular1.setText("Mod 1 ("+num1+" mod "+num2+"): "+mod1);

		Integer mod2 = num2 % num1;
		TextView modular2=(TextView)findViewById(R.id.mod2);
		modular2.setText("Mod 2 ("+num2+" mod "+num1+"): "+mod2);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
