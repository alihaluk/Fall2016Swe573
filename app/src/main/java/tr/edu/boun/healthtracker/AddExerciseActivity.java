package tr.edu.boun.healthtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import tr.edu.boun.healthtracker.model.inner.ExerciseObject;

public class AddExerciseActivity extends AppCompatActivity
{
    TextView tvExerciseHeader;
    EditText edtMinutes;
    EditText edtCalories;

    String CalculatedCalValue;

    ExerciseObject currentExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        currentExercise = new ExerciseObject();
        currentExercise.setName(getIntent().getStringExtra("name"));
        currentExercise.setCalorie(Double.parseDouble(getIntent().getStringExtra("calorie")));

        tvExerciseHeader = (TextView) findViewById(R.id.tv_addexercise_header);
        tvExerciseHeader.setText(currentExercise.getName());

        edtMinutes = (EditText) findViewById(R.id.edt_mins_performed);
        edtCalories = (EditText) findViewById(R.id.edt_cal_burned);

        edtMinutes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                String str = s.toString();

                Double newValue = 0.0;
                if (str.length() > 0)
                {
                    newValue = Double.parseDouble(str);
                }

                Double sixtyMinValue = currentExercise.getCalorie();

                Double newCalBurnedValue = (sixtyMinValue / 60.0 * newValue);
                CalculatedCalValue = "" + newCalBurnedValue.intValue();

                edtCalories.setText(CalculatedCalValue);
            }
        });

        edtCalories.setText("" + currentExercise.getCalorie().intValue());
        edtMinutes.setHint("e.g. 30");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.activity_add_exercise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int itemId = item.getItemId();
        if(itemId == R.id.action_add_exercise)
        {

            Intent returnIntent = new Intent();
            returnIntent.putExtra("itemHeader", currentExercise.getName());
            returnIntent.putExtra("itemDetail", "Exercise");
            returnIntent.putExtra("itemValue", edtCalories.getText().toString());
            setResult(RESULT_OK, returnIntent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
