package tr.edu.boun.healthtracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import tr.edu.boun.healthtracker.db.DB;
import tr.edu.boun.healthtracker.model.inner.UserObject;

public class ProfileActivity extends AppCompatActivity
{
    UserObject currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DB db = new DB(ProfileActivity.this);
        db.openDB();

        currentUser = db.getActiveUser();
        db.closeDB();

        setTitle(currentUser.getUsername().isEmpty() ? currentUser.getEmail() : currentUser.getUsername());

        FrameLayout contentLayout = (FrameLayout) findViewById(R.id.profile_content_id);

        TextView txt_username = (TextView) contentLayout.findViewById(R.id.profile_username_txt);
        txt_username.setText(currentUser.getUsername());

        TextView txt_email = (TextView) contentLayout.findViewById(R.id.profile_email_txt);
        txt_email.setText(currentUser.getEmail());

        TextView txt_age = (TextView) contentLayout.findViewById(R.id.profile_age_txt);
        txt_age.setText(currentUser.getAge().toString());

        TextView txt_height = (TextView) contentLayout.findViewById(R.id.profile_height_txt);
        txt_height.setText(currentUser.getHeight().toString());

        TextView txt_weight = (TextView) contentLayout.findViewById(R.id.profile_weight_txt);
        txt_weight.setText(currentUser.getWeight().toString());

        TextView txt_bmi = (TextView) contentLayout.findViewById(R.id.profile_bmi_txt);
        txt_bmi.setText(String.format("%.2f", currentUser.getBmi()));

        TextView txt_goal = (TextView) contentLayout.findViewById(R.id.profile_goal_txt);
        txt_goal.setText(currentUser.getCalGoal().toString());
    }
}
