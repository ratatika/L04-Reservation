package sg.edu.rp.c346.id20006092.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.function.BiConsumer;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNumber;
    EditText etPax;
    CheckBox cbEnabled;
    DatePicker dp;
    TimePicker tp;
    Button btnReserve;
    Button btnReset;
    TextView tvDisplayName;
    TextView tvDisplayNumber;
    TextView tvDisplayPax;
    TextView tvDisplayReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etNumber = findViewById(R.id.editTextPhoneNum);
        etPax = findViewById(R.id.editTextPax);
        cbEnabled = findViewById(R.id.checkBoxSmoking);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);
        tvDisplayName = findViewById(R.id.textViewDisplayName);
        tvDisplayNumber = findViewById(R.id.textViewDisplayNumber);
        tvDisplayPax = findViewById(R.id.textViewDisplayPax);
        tvDisplayReservation = findViewById(R.id.textViewDisplayReservation);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int day = dp.getMonth();
                int month = dp.getDayOfMonth();
                int year = dp.getYear();

                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                String data1 = etName.getText().toString();
                String data2 = etNumber.getText().toString();
                String data3 = etPax.getText().toString();
                String time = "";

                if (minute < 10) {

                    time = time + hour + ":0" + minute;

                } else {

                    time = time + hour + ":" + minute;

                }

                String date = month + "/" + day + "/" + year;
                String message = "";

                if (cbEnabled.isChecked() == true) {

                    message = message + "in a smoking area";

                } else {

                    message = message + "in a non-smoking area";

                }

                tvDisplayName.setText("Name: " + data1);
                tvDisplayNumber.setText("Contact number: " + data2);
                tvDisplayPax.setText("Table for:" + data3 + " " + message);
                tvDisplayReservation.setText("Booked for " + date + " at " + time);



            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etNumber.setText("");
                etPax.setText("");
                tvDisplayName.setText("");
                tvDisplayNumber.setText("");
                tvDisplayPax.setText("");
                tvDisplayReservation.setText("");
                cbEnabled.setEnabled(true);
            }
        });

    }
}