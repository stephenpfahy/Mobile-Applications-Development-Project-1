package stephenfahy.com.mobileprojectvotingapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Questions2 extends AppCompatActivity {

    //instance variables for the button which brings the user to another page,
    // and the TextView, Spinners and Radiogroups are for different questions in the questionnaire,
    // and a MyDBManager which links up to the MyDBManager class.
    //The String instance variables (db_married, db_doesUserHaveChildren, db_area, db_incomeEarned)
    // are for putting information into the database.
    //The String instance variables (db_age, db_politicalParty, db_vote, db_gender)
    // also contain Strings for putting information into the database.


    private TextView title;
    private RadioGroup married;
    private RadioGroup doesUserHaveChildren;
    private Spinner area;
    private Spinner incomeEarned;
    private Button submit;


    private String db_married;
    private String db_doesUserHaveChildren;
    private String db_area;
    private String db_incomeEarned;

    private MyDBManager db;

    private String db_age;
    private String db_politicalParty;
    private String db_vote;
    private String db_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_2);
        //the java code is linked to questions_2.xml file which outlines the layout of your android page
        //the onCreate method bundles the java code to the questions_2.xml file and the javacode makes the TextView, Spinners,
        // RadioGroups
        // and Button function.

        Bundle bundle = getIntent().getExtras();
        //The answers from the Questionnaire class are sent to this class using a bundle.
        //The instance variables (db_age, db_political, db_vote, db_gender) are assigned the value of the answers from the
        // Questionnaire class which have been bundled to the Questions2 class using the intent.putExtra() method and has been
        // received using the getIntent().getExtras() methods.
        db_age = (bundle.getString("age"));
        db_politicalParty = (bundle.getString("politicalParty"));
        db_vote = (bundle.getString("vote"));
        db_gender = (bundle.getString("gender"));


        title = (TextView) findViewById(R.id.title);//The "title" TextView is linked to the "title" TextView in questions_2.xml.
        submit = (Button) findViewById(R.id.submit);//The "submit" Button is linked to the "submit" Button in questions_2.xml.
        married = (RadioGroup) findViewById(R.id.married);//The "married" RadioGroup is linked to the "married" RadioGroup in questions_2.xml.
        doesUserHaveChildren = (RadioGroup) findViewById(R.id.children);//The "doesUserHaveChildren" RadioGroup is linked to the "children" RadioGroup in questions_2.xml.
        area = (Spinner) findViewById(R.id.galway_west);//The "area" Spinner is linked to the "galway_west" Spinner in questions_2.xml.
        incomeEarned = (Spinner) findViewById(R.id.income);//The "incomeEarned" Spinner is linked to the "income" Spinner in questions_2.xml.

        db = new MyDBManager(this);// A MyDBManager object is created called db which links the Questions2 class to the MyDBManager class
        // so the answers to the questions can be inserted into the database in MyDBManager.

        married.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                //the instance variable married calls OnCheckedChangeListener with a RadioGroup as a parameter
                //if one of the options are selected the then the db_married instance variable will be assigned the value of the answer.
                //In this case db_married will be assigned the value of "Yes" or "No".
                //Once one of these options are selected than it will break with the switch and continue reading code below this method.
                switch (id) {
                    case R.id.i_am_married:
                        db_married = "Yes";
                        break;
                    case R.id.i_am_not_married:
                        db_married = "No";
                        break;
                }
            }
        });

        doesUserHaveChildren.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                //the instance variable doesUserHaveChildren calls OnCheckedChangeListener with a RadioGroup as a parameter
                //if one of the options are selected the then the db_doesUserHaveChildren instance variable will be assigned the value of the answer.
                //In this case db_doesUserHaveChildren will be assigned the value of "Yes" or "No".
                //Once one of these options are selected than it will break with the switch and continue reading code below this method.
                switch (id) {
                    case R.id.yes_i_have_children:
                        db_doesUserHaveChildren = "Yes";
                        break;
                    case R.id.i_have_no_children:
                        db_doesUserHaveChildren = "No";
                        break;
                }
            }
        });

        //For the Spinner area instance variable you have to first create an ArrayList which gives the user a list of possible answers
        // to the question "What area of Galway West do you live in?" asked in questions_2.xml.
        // The areaList gives the user a list of Strings with the possible answers and puts them into an array.
        // Create a list of strings for the Spinner

        List<String> areaList = new ArrayList<String>();
        areaList.add("Abhainn Ghabhla");
        areaList.add("An Carn Mór");
        areaList.add("An Chorr");
        areaList.add("An Cnoc Buí");
        areaList.add("An Crompán");
        areaList.add("An Fhairche ");
        areaList.add("An Ros");
        areaList.add("An Spidéal");
        areaList.add("An Uillinn");
        areaList.add("An Turlach");
        areaList.add("Árainn");
        areaList.add("Aughrim");
        areaList.add("Baile Chláir");
        areaList.add("Baile an Teampaill");
        areaList.add("Ballinrobe");
        areaList.add("Ballynakill");
        areaList.add("Ballynacourty");
        areaList.add("Bearna");
        areaList.add("Belleville");
        areaList.add("Binn an Choire ");
        areaList.add("Bunowen");
        areaList.add("Camas");
        areaList.add("Ceathrú an Bhrúnaigh ");
        areaList.add("Cill Aithnín");
        areaList.add("Cill Chuimín");
        areaList.add("Clarinbridge");
        areaList.add("Cleggan");
        areaList.add("Clifden");
        areaList.add("Cloch na Rón");
        areaList.add("Cong");
        areaList.add("Conga");
        areaList.add("Cushkillary");
        areaList.add("Dalgan");
        areaList.add("Deerpark");
        areaList.add("Derrycunlagh");
        areaList.add("Derrylea");
        areaList.add("Doonloughan");
        areaList.add("Eanach Dhúin");
        areaList.add("Errislannan");
        areaList.add("Galway City");
        areaList.add("Galway Rural ");
        areaList.add("Garmna");
        areaList.add("Garrymore");
        areaList.add("Houndswood");
        areaList.add("Inishbofin");
        areaList.add("Kilcummin");
        areaList.add("Kilcommon");
        areaList.add("Kilmaine");
        areaList.add("Leacach Beag ");
        areaList.add("Leitir Breacáin ");
        areaList.add("Leitir Móir ");
        areaList.add("Letterfore");
        areaList.add("Liscananaun");
        areaList.add("Lisín an Bhealaigh");
        areaList.add("Maigh Cuilinn");
        areaList.add("Maíros ");
        areaList.add("Na Forbacha");
        areaList.add("Neale");
        areaList.add("Oughterard");
        areaList.add("Oranmore");
        areaList.add("Rinvyle");
        areaList.add("Sailearna");
        areaList.add("Scainimh");
        areaList.add("Shrule");
        areaList.add("Sillerna");
        areaList.add("Sliabh an Aonaigh");
        areaList.add("Stradbally");
        areaList.add("Tulaigh Mhic Aodháin");
        areaList.add("Wormhole");

        //An ArrayAdapter object called areaDataAdapter creates a spinner menu and adds the areaList ArrayList to the spinner.
        ArrayAdapter<String> areaDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, areaList);

        //areaDataAdapter calls the layout for a dropdown spinner menu.
        areaDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        area.setAdapter(areaDataAdapter);
        //the area instance variable calls a setAdapter and this becomes a method with areaDataAdapter as a parameter.

        area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //area instance variable  calls an OnItemSelectedListener which selects whatever option the user picks from the list

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), "On Item " +
                                "Selected" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();//the answer selected from the list is made into a String and toasted out.

                db_area = parent.getItemAtPosition(pos).toString();
                //the instance variable db_area is assigned the value of the string selected from the list by the user.
            }

            public void onNothingSelected(AdapterView<?> paren) {
                //method for when nothing is selected.
            }
        });


        //For the Spinner incomeEarned instance variable you have to first create an ArrayList which gives the user
        // a list of possible answers to the question "What income bracket are you in?" asked in questions_2.xml.
        // The incomeList gives the user a list of Strings with the possible answers and puts them into an array.
        // Create a list of strings for the Spinner
        List<String> incomeList = new ArrayList<String>();
        incomeList.add("None");
        incomeList.add("Less than €18,000 per annum.");
        incomeList.add("Between €18,000 and €20,000 per annum.");
        incomeList.add("Between €20,000 and €30,000 per annum.");
        incomeList.add("Between €30,000 and €40,000 per annum.");
        incomeList.add("Between €40,000 and €50,000 per annum.");
        incomeList.add("Between €50,000 and €60,000 per annum.");
        incomeList.add("Between €60,000 and €70,000 per annum.");
        incomeList.add("Between €70,000 and €80,000 per annum.");
        incomeList.add("Between €80,000 and €90,000 per annum.");
        incomeList.add("Between €90,000 and €100,000 per annum.");
        incomeList.add("Between €100,000 and €110,000 per annum.");
        incomeList.add("Between €110,000 and €120,000 per annum.");
        incomeList.add("Between €120,000 and €130,000 per annum.");
        incomeList.add("Between €130,000 and €140,000 per annum.");
        incomeList.add("More than €140,000 per annum.");


        //An ArrayAdapter object called incomeDataAdapter creates a spinner menu and adds the incomeList ArrayList to the spinner.
        ArrayAdapter<String> incomeDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, incomeList);

        //incomeDataAdapter calls the layout for a dropdown spinner menu.
        incomeDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //the incomeEarned instance variable calls a setAdapter and this becomes a method with incomeDataAdapter as a parameter.
        incomeEarned.setAdapter(incomeDataAdapter);

        //incomeEarned instance variable  calls an OnItemSelectedListener which selects whatever option the user picks from the list
        incomeEarned.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), "On Item " +
                                "Selected" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();//the answer selected from the list is made into a String and toasted out.

                db_incomeEarned = parent.getItemAtPosition(pos).toString();
                //the instance variable db_incomeEarned is assigned the value of the string selected from the list by the user.
            }

            public void onNothingSelected(AdapterView<?> paren) {
                //method for when nothing is selected.
            }

        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //The "submit" Button takes the user to the CandidateList Class when clicked.
                //The "submit" Button calls an OnClickListener and the user is brought to the CandidateList Class using an intent object.
                //In the parameters of the intent object it calls this class (Questions2.this) and then the CandidateList Class(CandidateList.Class).

                //The user clicks this button and it brings the user to the question in the poll which contains a candidate list.
                //The assigned values of the instance variables (db_age, db_political, db_vote, db_gender, db_married,
                //db_doesUserHaveChildren, db_area, db_incomeEarned) are put in
                // the parameters of an intent.putExtra()method and the answers of the questions are bundled to the CandidateList Class.
                //Each answer is given a String name (example: "age", "area") which is called in the CandidateList Class.


                Intent intent = new Intent(Questions2.this, CandidateList.class);
                intent.putExtra("age", db_age);
                intent.putExtra("politicalParty", db_politicalParty);
                intent.putExtra("vote", db_vote);
                intent.putExtra("gender", db_gender);
                intent.putExtra("married", db_married);
                intent.putExtra("doesUserHaveChildren", db_doesUserHaveChildren);
                intent.putExtra("area", db_area);
                intent.putExtra("incomeEarned", db_incomeEarned);
                startActivity(intent);
                finish();
            }


        });
    }
}




