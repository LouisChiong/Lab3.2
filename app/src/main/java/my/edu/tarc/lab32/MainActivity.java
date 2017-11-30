package my.edu.tarc.lab32;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremiun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremiun = (TextView)findViewById(R.id.textViewPremiun);

        //Create an adapter for spinner
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this, R.array.age_group, android.R.layout.simple_spinner_item
                );
        adapter.setDropDownViewResource(
                android.R.layout.simple_dropdown_item_1line
        );

        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Position :"+position,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void calculatePremium(View view){
        int pos;
        pos= spinnerAge.getSelectedItemPosition();
        int totalPremium = 0;

        switch(pos) {
            case 0:
                totalPremium += 50;
                break;
            case 1:
                totalPremium += 55;
                break;
            case 2:
                totalPremium += 60;
                break;
            case 3:
                totalPremium += 70;
                break;
            case 4:
                totalPremium += 120;
                break;
            case 5:
                totalPremium += 160;
                break;
            case 6:
                totalPremium += 200;
                break;
            case 7:
                totalPremium += 250;
                break;
            default:
        }
        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();
        if(indexGender==R.id.radioButtonMale) {
            //TODO: calculate premium for male
            switch (pos) {
                case 0:
                    totalPremium += 0;
                    break;
                case 1:
                    totalPremium += 0;
                    break;
                case 2:
                    totalPremium += 50;
                    break;
                case 3:
                    totalPremium += 100;
                    break;
                case 4:
                    totalPremium += 100;
                    break;
                case 5:
                    totalPremium += 50;
                    break;
                case 6:
                    totalPremium += 0;
                    break;
                case 7:
                    totalPremium += 0;
                    break;
                default:
            }
        }

            if (checkBoxSmoker.isChecked()) {
                //TODO: calculate premium for smoker
                switch (pos) {
                    case 0:
                        totalPremium += 0;
                        break;
                    case 1:
                        totalPremium += 0;
                        break;
                    case 2:
                        totalPremium += 0;
                        break;
                    case 3:
                        totalPremium += 100;
                        break;
                    case 4:
                        totalPremium += 150;
                        break;
                    case 5:
                        totalPremium += 150;
                        break;
                    case 6:
                        totalPremium += 250;
                        break;
                    case 7:
                        totalPremium += 250;
                        break;
                    default:
                }
            }

        Locale locale =Locale.getDefault();

        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        String currentcyText =fmt.format(totalPremium);

            textViewPremiun.setText(getString(R.string.premium)+ " " +currentcyText);
        }


    public void resetPremium(View view){
        //TODO: Reset
        spinnerAge.setSelection(0);
        textViewPremiun.setText(getString(R.string.premium));
        checkBoxSmoker.setChecked(false);
        radioButtonMale.setChecked(true);
        radioButtonFemale.setChecked(false);

    }

}
