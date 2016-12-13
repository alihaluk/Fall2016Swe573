package tr.edu.boun.healthtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServingDialogActivity extends AppCompatActivity
{
    EditText edtNumberOfServing;
    Spinner spnServingSize;

    Button btnOK;
    Button btnCancel;

    Integer selectedUnitIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serving_dialog);

        Integer numberOfServing = getIntent().getIntExtra("selectedNumber", 1);
        String[] servingSizes = (String[]) getIntent().getCharSequenceArrayExtra("sizeList");

        edtNumberOfServing = (EditText) findViewById(R.id.edt_number_of_serving);
        edtNumberOfServing.setText(numberOfServing.toString());
        spnServingSize = (Spinner) findViewById(R.id.spinner_serving_size);

        List<String> servingSizeList = new ArrayList<>(Arrays.asList(servingSizes));

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(ServingDialogActivity.this, android.R.layout.simple_spinner_item, servingSizeList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnServingSize.setAdapter(spinnerAdapter);
        spnServingSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedUnitIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        spnServingSize.setSelection(0);

        btnOK = (Button) findViewById(R.id.btn_dialog_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("numberOfServing", Integer.parseInt(edtNumberOfServing.getText().toString()));
                returnIntent.putExtra("selectedUnitIndex", selectedUnitIndex);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        btnCancel = (Button) findViewById(R.id.btn_dialog_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);
                finish();
            }
        });
    }
}
