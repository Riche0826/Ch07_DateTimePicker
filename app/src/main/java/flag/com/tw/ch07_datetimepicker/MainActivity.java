package flag.com.tw.ch07_datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    Calendar c = Calendar.getInstance();
    TextView txvDate, txvTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvDate = (TextView) findViewById(R.id.txv1);
        txvTime = (TextView) findViewById(R.id.txv2);

        txvDate.setOnClickListener(this);
        txvTime.setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        txvDate.setText("日期 : " + i + "/" + (i1 + 1) + "/" + i2);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        txvTime.setText("時間 : " + i + ":" + i1);
    }

    @Override
    public void onClick(View v) {
       if(v == txvDate){
           new DatePickerDialog(this, this,
                   c.get(Calendar.YEAR),
                   c.get(Calendar.MONTH),
                   c.get(Calendar.DAY_OF_MONTH))
                   .show();
       }else if(v == txvTime){
           new TimePickerDialog(this, this,
                   c.get(Calendar.HOUR_OF_DAY),
                   c.get(Calendar.MINUTE),
                   true)
                   .show();
       }
    }
}
