package tr.edu.boun.healthtracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tr.edu.boun.healthtracker.model.inner.FoodObject;
import tr.edu.boun.healthtracker.model.inner.MeasureObject;
import tr.edu.boun.healthtracker.model.inner.NutrientObject;
import tr.edu.boun.healthtracker.utils.JsonRequest;

public class AddFoodActivity extends AppCompatActivity
{
    FoodObject currentFood;

    TextView tvFoodHeader;
//    EditText edtNumberOfServing;
    Button btnNumberOfServing;
//    AppCompatSpinner spnServingSize;
    Button btnServingSize;
    TextView tvTotalCarb;
    TextView tvTotalFat;
    TextView tvTotalProtein;
    TextView tvTotalCalorie;

    Integer numberOfServing;
    String selectedUnitLabel;
    List<String> servingSizeList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        String ndbno = getIntent().getStringExtra("ndbno");

        tvFoodHeader = (TextView) findViewById(R.id.tv_addfood_header);
//        edtNumberOfServing = (EditText) findViewById(R.id.edt_number_of_serving);
        btnNumberOfServing = (Button) findViewById(R.id.btn_number_of_serving);
        btnNumberOfServing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openServingDialog();
            }
        });
//        spnServingSize = (AppCompatSpinner) findViewById(R.id.spinner_serving_size);
        btnServingSize = (Button) findViewById(R.id.btn_serving_size);
        btnServingSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openServingDialog();
            }
        });

        tvTotalCarb = (TextView) findViewById(R.id.txt_total_carbo);
        tvTotalFat = (TextView) findViewById(R.id.txt_total_fat);
        tvTotalProtein = (TextView) findViewById(R.id.txt_total_protein);
        tvTotalCalorie = (TextView) findViewById(R.id.txt_total_calorie);


        FoodReportTask frt = new FoodReportTask();
        frt.execute(ndbno);
    }

    public void openServingDialog()
    {
        Intent i = new Intent(AddFoodActivity.this, ServingDialogActivity.class);
        i.putExtra("selectedNumber", numberOfServing);
        String[] sizeList = new String[servingSizeList.size()];
        i.putExtra("sizeList", servingSizeList.toArray(sizeList));
        startActivityForResult(i, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case 101:
                if (resultCode == RESULT_OK)
                {
                    numberOfServing = data.getIntExtra("numberOfServing", 1);
                    btnNumberOfServing.setText(numberOfServing.toString());
                    int servingSizeIndex = data.getIntExtra("selectedUnitIndex", 0);

                    selectedUnitLabel = currentFood.getNutrients().get(0).getMeasures().get(servingSizeIndex).getLabel();
                    btnServingSize.setText(servingSizeList.get(servingSizeIndex));

                    calculateValues();
                }
                break;
        }
    }

    public void populateScreen()
    {
        tvFoodHeader.setText(currentFood.getName());
//        edtNumberOfServing.setText("1");

        numberOfServing = 1;
        btnNumberOfServing.setText(String.valueOf(numberOfServing));
        selectedUnitLabel = "";
        servingSizeList = new ArrayList<>();

        for(MeasureObject measureObject : currentFood.getNutrients().get(0).getMeasures())
        {
            servingSizeList.add(measureObject.getQty().toString() + " " + measureObject.getLabel() + " " + measureObject.getEqv().toString() + "g");
        }

        selectedUnitLabel = currentFood.getNutrients().get(0).getMeasures().get(0).getLabel();
        btnServingSize.setText(servingSizeList.get(0));

        calculateValues();
    }

    public void calculateValues()
    {
        for(NutrientObject no : currentFood.getNutrients())
        {
            if (no.getGroup().equals("Proximates") && no.getName().equals("Energy"))
            {
                for (MeasureObject mo : no.getMeasures())
                {
                    if (mo.getLabel().equals(selectedUnitLabel))
                    {
                        Double totalCalorie = Double.parseDouble(mo.getValue()) * numberOfServing.doubleValue();
                        tvTotalCalorie.setText(String.format(Locale.US, "%d", totalCalorie.intValue()));
                        break;
                    }
                }
            }
            if (no.getGroup().equals("Proximates") && no.getName().equals("Protein"))
            {
                for (MeasureObject mo : no.getMeasures())
                {
                    if (mo.getLabel().equals(selectedUnitLabel))
                    {
                        tvTotalProtein.setText(String.format(Locale.US, "%.2f", Double.parseDouble(mo.getValue()) * numberOfServing.doubleValue()));
                        break;
                    }
                }
            }
            if (no.getGroup().equals("Proximates") && no.getName().equals("Total lipid (fat)"))
            {
                for (MeasureObject mo : no.getMeasures())
                {
                    if (mo.getLabel().equals(selectedUnitLabel))
                    {
                        tvTotalFat.setText(String.format(Locale.US, "%.2f", Double.parseDouble(mo.getValue()) * numberOfServing.doubleValue()));
                        break;
                    }
                }
            }
            if (no.getGroup().equals("Proximates") && no.getName().equals("Carbohydrate, by difference"))
            {
                for (MeasureObject mo : no.getMeasures())
                {
                    if (mo.getLabel().equals(selectedUnitLabel))
                    {
                        tvTotalCarb.setText(String.format(Locale.US, "%.2f", Double.parseDouble(mo.getValue()) * numberOfServing.doubleValue()));
                        break;
                    }
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.activity_add_food, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int itemId = item.getItemId();
        if(item.getItemId() == R.id.action_add_food)
        {
            // add food
            Intent returnIntent = new Intent();
            returnIntent.putExtra("itemHeader", currentFood.getName());
            returnIntent.putExtra("itemDetail", "Food");
            returnIntent.putExtra("itemValue", tvTotalCalorie.getText().toString());
            setResult(RESULT_OK, returnIntent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public class FoodReportTask extends AsyncTask<String, Void, Void>
    {
        FoodObject fo;

        ProgressDialog mProgressDialog;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            mProgressDialog = new ProgressDialog(AddFoodActivity.this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Getting food...");
            mProgressDialog.setProgress(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(String... params)
        {
            JsonRequest jr = new JsonRequest();
            fo = jr.sendRequestFoodReport(params[0], "b");

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            mProgressDialog.hide();
            mProgressDialog.dismiss();

            if (fo.getName() != null)
            {
                currentFood = fo;
                populateScreen();
            }
        }
    }
}
