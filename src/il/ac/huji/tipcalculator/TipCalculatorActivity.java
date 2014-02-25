package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	protected static final double TIP = 0.12;
	EditText edtBillAmount ;
	Button btnCalculate; 
	CheckBox chkRound ;
	TextView txtTipResult ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		
		edtBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		btnCalculate = (Button)findViewById(R.id.btnCalculate);
		chkRound = (CheckBox) findViewById(R.id.chkRound);
		txtTipResult = (TextView)findViewById(R.id.txtTipResult);
		
		btnCalculate.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Double billAmount;
				try{	
				 billAmount = Double.parseDouble(edtBillAmount.getText().toString());
				}catch(Exception e){
					return;
				}
				billAmount*=TIP;
				Object o = Math.round(billAmount*100)/(double)100;
				if(chkRound.isChecked()){
					o =  Math.round(billAmount);
				}

				txtTipResult.setText("Tip:$"+o.toString());
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
