package tr.edu.boun.healthtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import tr.edu.boun.healthtracker.db.DB;
import tr.edu.boun.healthtracker.model.inner.UserObject;

public class RegisterActivity extends AppCompatActivity
{
    EditText edt_email;
    EditText edt_username;
    EditText edt_pass;
    EditText edt_confirm_pass;
    EditText edt_age;
    Spinner spn_gender;
    EditText edt_height;
    EditText edt_weight;
    EditText edt_cal_goal;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Register");

        // set email from params
        String param_email = getIntent().getStringExtra("email");

        edt_email = (EditText) findViewById(R.id.register_edt_email);
        edt_email.setText(param_email);

        edt_username = (EditText) findViewById(R.id.register_edt_username);
        edt_pass = (EditText) findViewById(R.id.register_edt_password);
        edt_confirm_pass = (EditText) findViewById(R.id.register_edt_repassword);
        edt_confirm_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    // control with pass
                    // if not equal set Error
                    EditText self = (EditText) v;
                    String value = self.getText().toString();
                    if (!edt_pass.getText().toString().equals(value))
                    {
                        self.setError(getString(R.string.pass_confirm_error));
                    }
                }
            }
        });
        edt_age = (EditText) findViewById(R.id.register_edt_age);
        spn_gender = (Spinner) findViewById(R.id.register_spin_gender);
        edt_height = (EditText) findViewById(R.id.register_edt_height);
        edt_weight = (EditText) findViewById(R.id.register_edt_weight);
        edt_cal_goal = (EditText) findViewById(R.id.register_edt_cal_goal);

        btn_register = (Button) findViewById(R.id.register_button);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                View current = getCurrentFocus();
                if (current != null) current.clearFocus();

                if (validateForm())
                {
                    // register
                    DB db = new DB(RegisterActivity.this);
                    db.openDB();

                    if (db.doesExistsUser(edt_email.getText().toString()))
                    {
                        db.closeDB();
                        Toast.makeText(RegisterActivity.this, R.string.already_registered, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    UserObject newUser = new UserObject();
                    newUser.setEmail(edt_email.getText().toString());
                    newUser.setUsername(edt_username.getText().toString());
                    newUser.setPassword(edt_pass.getText().toString());
                    newUser.setAge(edt_age.getText().toString().isEmpty() ? 0 : Integer.parseInt(edt_age.getText().toString()));
                    newUser.setGender(spn_gender.getSelectedItemPosition() > 0 ? getResources().getStringArray(R.array.gender_list)[spn_gender.getSelectedItemPosition()] : "");

                    Double height = Double.parseDouble(edt_height.getText().toString());
                    newUser.setHeight(height);
                    Double weight = Double.parseDouble(edt_weight.getText().toString());
                    newUser.setWeight(weight);

                    Double height_in_metric = height / 100.0;
                    Double bmi = weight / (height_in_metric * height_in_metric);
                    newUser.setBmi(bmi);

                    newUser.setCalGoal(edt_cal_goal.getText().toString().isEmpty() ? 2700 : Integer.parseInt(edt_cal_goal.getText().toString()));


                    db.insertUser(newUser);

                    db.closeDB();

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("email", newUser.getEmail());
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, R.string.fill_correctly, Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }

    public Boolean validateForm()
    {
        Boolean IsValid = true;

        // email
        if (!Patterns.EMAIL_ADDRESS.matcher(edt_email.getText().toString()).matches())
        {
            edt_email.setError(getString(R.string.valid_email_error));
            IsValid = false;
        }

        // username is not mandatory

        // password
        if (edt_pass.getText().toString().isEmpty())
        {
            edt_pass.setError(getString(R.string.empty_password_error));
            IsValid = false;
        }

        // confirm_password should be handled onFocusChangeListener, therefore no need to control
        if (edt_confirm_pass.getError() != null)
        {
            IsValid = false;
        }

        // age is not mandatory

        // gender is not mandatory

        // height
        if (edt_height.getText().toString().isEmpty())
        {
            edt_height.setError(getString(R.string.empty_height_error));
            IsValid = false;
        }

        // weight
        if (edt_weight.getText().toString().isEmpty())
        {
            edt_weight.setError(getString(R.string.empty_weight_error));
            IsValid = false;
        }

        // daily calorie goal is not mandatory


        return IsValid;
    }
}
