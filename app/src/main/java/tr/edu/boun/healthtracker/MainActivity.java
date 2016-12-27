package tr.edu.boun.healthtracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tr.edu.boun.healthtracker.db.DB;
import tr.edu.boun.healthtracker.model.inner.UserObject;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<CustomItem> dailyItems;

    TextView tvGoal;
    TextView tvTotalFood;
    TextView tvTotalExercise;
    TextView tvRemainingCalories;

    UserObject currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                final CharSequence[] items = {"Food","Exercise"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Intent i = new Intent(MainActivity.this, AddingActivity.class);
                        i.putExtra("type", items[which]);
                        startActivityForResult(i, 1001);
                    }
                });
                builder.create().show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String user_email = getIntent().getStringExtra("user_email");

        DB db = new DB(MainActivity.this);
        db.openDB();
        currentUser = db.getActiveUser();
        db.closeDB();

        tvGoal = (TextView) findViewById(R.id.txt_main_goal);
        tvGoal.setText(currentUser.getCalGoal().toString());
        tvTotalFood = (TextView) findViewById(R.id.txt_main_total_food);
        tvTotalExercise = (TextView) findViewById(R.id.txt_main_total_exercise);
        tvRemainingCalories = (TextView) findViewById(R.id.txt_main_total_calorie);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        dailyItems = new ArrayList<>();

        populateList(dailyItems);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case 1001:
                if (resultCode == RESULT_OK)
                {

                    String header = data.getStringExtra("itemHeader");
                    String detail = data.getStringExtra("itemDetail");
                    String value = data.getStringExtra("itemValue");

                    CustomItem ci = new CustomItem(header, detail, value);

                    dailyItems.add(ci);

                    populateList(dailyItems);
                }
                break;
        }
    }

    public void calculateRemainingCalories()
    {
        Double totalFood = 0.0;
        Double totalExercise = 0.0;

        for (CustomItem ci : dailyItems)
        {
            if (ci.getSubtext().equals("Food"))
            {
                totalFood += Double.parseDouble(ci.getValue());
            }
            if (ci.getSubtext().equals("Exercise"))
            {
                totalExercise += Double.parseDouble(ci.getValue());
            }
        }

        tvTotalFood.setText(String.format(Locale.US, "%d", totalFood.intValue()));
        tvTotalExercise.setText(String.format(Locale.US, "%d", totalExercise.intValue()));
        Double remaining = currentUser.getCalGoal() - totalFood + totalExercise;
        tvRemainingCalories.setText(String.format(Locale.US, "%d", remaining.intValue()));
        if (remaining > 0.0)
        {
            tvRemainingCalories.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        else if (remaining < 0.0)
        {
            String str = "-";
            str += tvRemainingCalories.getText().toString();
            tvRemainingCalories.setTextColor(getResources().getColor(R.color.colorMinus));
        }

    }

    public void populateList(List<CustomItem> items)
    {
        mRecyclerView.setAdapter(new MyAdapter(items));
        calculateRemainingCalories();
    }

    public class ItemHolder extends RecyclerView.ViewHolder
    {
        TextView item_header;
        TextView item_subtext;
        TextView item_value;

        public ItemHolder(View itemView)
        {
            super(itemView);

            item_header = (TextView) itemView.findViewById(R.id.tv_name_adding_item);
            item_subtext = (TextView) itemView.findViewById(R.id.tv_detail_adding_item);
            item_value = (TextView) itemView.findViewById(R.id.tv_value_adding_item);
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<ItemHolder>
    {
        List<CustomItem> values;

        public MyAdapter(List<CustomItem> array)
        {
            values = array;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adding_list, parent, false));
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, final int position)
        {
            CustomItem item = values.get(position);
            holder.item_header.setText(item.getHeader());
            holder.item_subtext.setText(item.getSubtext());
            holder.item_value.setText(item.getValue());
        }

        @Override
        public int getItemCount()
        {
            return values.size();
        }

    }

    public class CustomItem
    {
        String header;
        String subtext;
        String value;

        public CustomItem(String header, String subtext, String value)
        {
            this.header = header;
            this.subtext = subtext;
            this.value = value;
        }

        public String getHeader()
        {
            return header;
        }

        public void setHeader(String header)
        {
            this.header = header;
        }

        public String getSubtext()
        {
            return subtext;
        }

        public void setSubtext(String subtext)
        {
            this.subtext = subtext;
        }

        public String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // if else

        if (id == R.id.nav_profile)
        {
            Intent i = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(i);
        }
        if (id == R.id.nav_logout)
        {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
