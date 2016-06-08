package stephenfahy.com.mobileprojectvotingapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TaoiseachList extends AppCompatActivity {

    private ListView taoiseachCandidateList;//create a new instance variable ListView called taoiseachcandidateList.
    private MyDBManager db;//instance variable for the database.
    private String db_taoiseachCandidate;//a new instance variable called db_candidate to insert into the database.

    //Created instance variables for Strings bundled over from the CandidateList class.
    private String db_candidate;
    private String db_married;
    private String db_doesUserHaveChildren;
    private String db_area;
    private String db_incomeEarned;
    private String db_age;
    private String db_politicalParty;
    private String db_vote;
    private String db_gender;

    private long id;
    //An long id instance variable is called to give each row of information put into the database an id.
    //This gives each row in the database a unique identifier or primary key.

    //Created a String array which contains all the names of the Taoiseach candidates for Ireland.
    private String[] Candidates = {"Enda Kenny", "Michaél Martin", "Gerry Adams", "Richard Boyd Barrett",
            "Joan Burton", "Eamon Ryan", "Various Leaders"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taoiseach_list);
        //the java code is linked to taoiseach_list.xml file which outlines the layout of the android page
        //the onCreate method bundles the java code to the taoiseach.xml file and the javacode makes the ListView function.

        // A MyDBManager object is created called db which links the CandidateList class to the MyDBManager class
        // so the answers to the questions can be inserted into the database in MyDBManager.
        db = new MyDBManager(this);

        //The answers from the CandidateList class are sent to TaoiseachList class using a bundle.
        //The instance variables (db_candidate, db_married, db_doesUserHaveChildren, db_area, db_incomeEarned, db_age, db_political,
        // db_vote, db_gender) are assigned the value of the answers from the
        // CandidateList class which have been bundled to the TaoiseachList class using the intent.putExtra() method and has been
        // received using the getIntent().getExtras() methods.
        Bundle bundle = getIntent().getExtras();
        db_candidate = (bundle.getString("candidate"));
        db_married = (bundle.getString("married"));
        db_doesUserHaveChildren = (bundle.getString("doesUserHaveChildren"));
        db_area = (bundle.getString("area"));
        db_incomeEarned = (bundle.getString("incomeEarned"));
        db_age = (bundle.getString("age"));
        db_politicalParty = (bundle.getString("politicalParty"));
        db_vote = (bundle.getString("vote"));
        db_gender = (bundle.getString("gender"));






        taoiseachCandidateList = (ListView) findViewById(R.id.taoiseach_cand);
        //The "taoiseachCandidateList" ListView is linked to the "taoiseach_cand" ListView in taoiseach_list.xml.
        taoiseachCandidateList.setAdapter(new MyCustomAdapter(TaoiseachList.this, R.layout.rows_taoiseach, Candidates));
        //The taoiseachCandidateList calls a setAdapter method which calls the MyCustomAdapter method in it's parameter's.
        //In the MyCustomAdapters methods parameters it inserts this TaiseachList class, the rows_taoiseach.xml layout, and the Candidates array.

        //The MyCustomAdapter class is carried out before the next command is carried out in CandidateList is carried out.

        //The taoiseachCandidateList Listview calls an OnClickListener when the user selects a candidate in the Listview.
        taoiseachCandidateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = (String) taoiseachCandidateList.getItemAtPosition(position);
                db_taoiseachCandidate = itemvalue;
                //db_taoiseachCandidate assigned the value itemvalue.
                //db_taoiseachCandidate is assigned the value of the name of the candidate selected which has been converted to a String.

                Toast.makeText(getApplicationContext(), itemvalue,
                        Toast.LENGTH_LONG).show();//itemvalue has been toasted to make into text to go in MyDBManager class.


                db.open();//MyDBManager class is opened.

                //The long id instance variable is assigned the value of the insertVoter method in the MyDBManager class.
                //The values of the String instance variables db_age, db_gender, db_vote, db_politicalParty, db_incomeEarned,
                // db_area, db_doesUserHaveChildren, db_married, db_candidate and db_taoiseachCandidate are inserted into
                // the parameters of the insertVoter method and inserted into the database.
                //The answer of each question in the poll has been converted into a String and all these Strings have been
                // inserted into the MyDBManager class using the insertVoter method in the MyDBManager class.
                id = db.insertVoter(db_age, db_gender, db_vote, db_politicalParty, db_incomeEarned, db_area, db_doesUserHaveChildren, db_married,
                        db_candidate, db_taoiseachCandidate);

                db.close();//MyDBManager class is closed.

                //An intent objectbrings the user to another page when the candidate has been selected in the ListView, by clicking a row in the ListView.
                //The OnClickListener is called and the intent object  brings the user  to the ViewDatabase Class.
                //In the parameters of the intent object it calls this class (TaoiseachList.this) and then the ViewDatabase Class(ViewDatabase.Class).
                Intent intent = new Intent(TaoiseachList.this, ViewDatabase.class);
                startActivity(intent);


            }
        });


    }


    public class MyCustomAdapter extends ArrayAdapter<String> {
        //MyCustomAdapter called above in the TaoiseachList class.

        String[] names;
        //A Strings array local variable is called names.

        // Creating our own adaptor because we want to be able to customise each row
        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects) {
            super(context, textViewResourceId, objects);
            names = objects;
        }

        @Override
        // This getview method is called each time a row needs to be formatted for the list

        public View getView(int position, View convertView, ViewGroup parent) {

            //this method creates the layout for the rows_taoiseach.xml and this rows_taoiseach.xml has been added to the
            //taoiseach_list.xml


            //return super.getView(position, convertView, parent);
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.rows, parent, false);
            TextView label = (TextView) row.findViewById(R.id.candidate);
            label.setText(names[position]);
            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            ImageView icon2 = (ImageView) row.findViewById(R.id.icon2);

            //if a string from the Candidates String array is inserted into the TextView label
            //then images are inserted into ImageView icon and ImageView icon2.
            //These images are called from the drawable folder.

            if (Candidates[position] == "Enda Kenny") {
                icon.setImageResource(R.drawable.enda_kenny_small);
                icon2.setImageResource(R.drawable.fine_gael);
            } else if (Candidates[position] == "Michaél Martin") {
                icon.setImageResource(R.drawable.micheal_martin_small);
                icon2.setImageResource(R.drawable.fiannafaillogo_small);
            } else if (Candidates[position] == "Gerry Adams") {
                icon.setImageResource(R.drawable.gerry_adams_small);
                icon2.setImageResource(R.drawable.sinn_fein_logo);
            } else if (Candidates[position] == "Richard Boyd Barrett") {
                icon.setImageResource(R.drawable.richard_boyd_barrett_small);
                icon2.setImageResource(R.drawable.aaa_logo_small);
            } else if (Candidates[position] == "Joan Burton") {
                icon.setImageResource(R.drawable.joan_burton_small);
                icon2.setImageResource(R.drawable.labour_party_logo);
            } else if (Candidates[position] == "Eamon Ryan") {
                icon.setImageResource(R.drawable.eamon_ryan_small);
                icon2.setImageResource(R.drawable.green_party_small);
            } else if (Candidates[position] == "Lucinda Creighton") {
                icon.setImageResource(R.drawable.lucinda_creighton_small);
                icon2.setImageResource(R.drawable.renua_small);
            } else if (Candidates[position] == "Various Leaders") {
                icon.setImageResource(R.drawable.social_democrats);
                icon2.setImageResource(R.drawable.social_democrats);
            }

            return row;
        }
        //when each row is created it is added to rows_taoiseach.xml.
        //all the rows are then created as a list and added to taoiseach_list.xml.
        //When this method is finished and the row is returned
        // then the programme is continued in the TaoiseachList class
        //at taoiseachCandidateList.setOnItemClickListener.
    }





}
