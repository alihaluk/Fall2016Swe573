package tr.edu.boun.healthtracker;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tr.edu.boun.healthtracker.db.DB;
import tr.edu.boun.healthtracker.model.inner.ExerciseObject;
import tr.edu.boun.healthtracker.model.inner.SearchItemObject;
import tr.edu.boun.healthtracker.model.inner.UserObject;
import tr.edu.boun.healthtracker.utils.JsonRequest;

public class AddingActivity extends AppCompatActivity
{
    private final int TRIGGER_SERACH = 1;
    private final long SEARCH_TRIGGER_DELAY_IN_MS = 1000;
    private String searchQuery = "";
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what == TRIGGER_SERACH)
            {
                triggerSearch();
            }
        }
    };

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SearchView mSearchView;

    private String addingType;

    private List<CustomItem> allExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        mRecyclerView = (RecyclerView) findViewById(R.id.adding_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mSearchView = (SearchView) findViewById(R.id.adding_search);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                searchQuery = newText;
                handler.removeMessages(TRIGGER_SERACH);
                handler.sendEmptyMessageDelayed(TRIGGER_SERACH, SEARCH_TRIGGER_DELAY_IN_MS);
                return false;
            }
        });
        mSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean queryTextFocused)
            {
                if(!queryTextFocused)
                {
                    mSearchView.setPressed(true);
                    mSearchView.setQuery("", false);

                    if (addingType.equals("Exercise"))
                    {
                        populateAllExercises();
                    }
                }
            }
        });

        addingType = getIntent().getStringExtra("type");
        BuildScreen(addingType);
    }

    public void triggerSearch()
    {
        SearchItemTask sit = new SearchItemTask();
        sit.execute(searchQuery);
    }

    public void BuildScreen(String type)
    {
        setTitle(type);


        if (type.equals("Food"))
        {
            //TODO: get recent foods and populate list

            List<CustomItem> items = new ArrayList<>();
            populateList(items);

        } else if (type.equals("Exercise"))
        {
            // TODO: get recent exercise and populate list

            // now we will populate all exercise items to search.
            populateAllExercises();
        }

    }

    public void populateAllExercises()
    {
        List<CustomItem> items = new ArrayList<>();

        DB db = new DB(AddingActivity.this);
        db.openDB();
        UserObject user = db.getActiveUser();
        List<ExerciseObject> all_exercises = db.getCalculatedExerciseListWithMass(user.getWeight());
        db.closeDB();

        for (ExerciseObject eo : all_exercises)
        {
            items.add(new CustomItem(eo.getName(), "", String.format(Locale.US, "%d", eo.getCalorie().intValue())));
        }
        populateList(items);

        allExercises = items;
    }

    public class SearchItemTask extends AsyncTask<String, Void, Void>
    {
        List<CustomItem> items = new ArrayList<>();

        @Override
        protected Void doInBackground(String... params)
        {
            if (addingType.equals("Food"))
            {
                JsonRequest jr = new JsonRequest();
                List<SearchItemObject> result_items = jr.sendRequestSearch(params[0], "n");

                for(SearchItemObject so : result_items)
                {
                    items.add(new CustomItem(so.getName(), so.getNdbno(), ""));
                }
            }
            else if (addingType.equals("Exercise"))
            {
                for (CustomItem ci : allExercises)
                {
                    if (ci.getHeader().toLowerCase().contains(params[0].toLowerCase()))
                    {
                        items.add(new CustomItem(ci.getHeader(), "", ci.getValue()));
                    }
                }

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);

            populateList(items);
        }
    }

    public void populateList(List<CustomItem> items)
    {
        mRecyclerView.setAdapter(new MyAdapter(items));
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

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    if (addingType.equals("Food"))
                    {
                        String ndbno = values.get(position).getSubtext();

                        Intent i = new Intent(AddingActivity.this, AddFoodActivity.class);
                        i.putExtra("ndbno", ndbno);
                        startActivityForResult(i, 201);
                    }
                    else if (addingType.equals("Exercise"))
                    {
                        String exerciseName = values.get(position).getHeader();
                        String SixtyMinsCalorie = values.get(position).getValue();

                        Intent i = new Intent(AddingActivity.this, AddExerciseActivity.class);
                        i.putExtra("name", exerciseName);
                        i.putExtra("calorie", SixtyMinsCalorie);
                        startActivityForResult(i, 202);
                    }
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return values.size();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case 201:
                if (resultCode == RESULT_OK)
                {
                    // add food
                    String header = data.getStringExtra("itemHeader");
                    String detail = data.getStringExtra("itemDetail");
                    String value = data.getStringExtra("itemValue");

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("itemHeader", header);
                    returnIntent.putExtra("itemDetail", detail);
                    returnIntent.putExtra("itemValue", value);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
                break;
            case 202:
                if (resultCode == RESULT_OK)
                {
                    // add exercise
                    String header = data.getStringExtra("itemHeader");
                    String detail = data.getStringExtra("itemDetail");
                    String value = data.getStringExtra("itemValue");

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("itemHeader", header);
                    returnIntent.putExtra("itemDetail", detail);
                    returnIntent.putExtra("itemValue", value);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
                break;
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
}
