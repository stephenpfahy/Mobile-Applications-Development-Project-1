package stephenfahy.com.mobileprojectvotingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Questionnaire extends AppCompatActivity {

    //instance variables for the button which brings the user to another page,
    // and spinners and Radiogroups for different questions in the questionnaire,
    // and a MyDBManager which links up to the MyDBManager class.
    //The String instance variables (db_age, db_politicalParty, db_vote, db_gender) are for putting information into the database.


    private Spinner age;
    private Spinner politicalParty;
    private RadioGroup vote;
    private RadioGroup gender;

    private Button nextPage;

    private String db_age;
    private String db_politicalParty;
    private String db_vote;
    private String db_gender;

    private MyDBManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire);
        //the java code is linked to questionnaire.xml file which outlines the layout of your android page
        //the onCreate method bundles the java code to the questionnaire.xml file and the javacode makes the Spinners, RadioGroups
        // and Button function.

        age = (Spinner) findViewById(R.id.age_of_user);//The "age" Spinner is linked to the "age_of_user" Button in questionnaire.xml.
        politicalParty = (Spinner) findViewById(R.id.political_party);//The "politicalParty" Spinner is linked to the "political_party" Button in questionnaire.xml.
        vote = (RadioGroup) findViewById(R.id.vote); //The "vote" RadioGroup is linked to the "vote" RadioGroup in questionnaire.xml.
        gender = (RadioGroup) findViewById(R.id.gender);//The "gender" RadioGroup is linked to the "gender" RadioGroup in questionnaire.xml.
        nextPage = (Button) findViewById(R.id.next); //The "nextPage" Button is linked to the "next" Button in questionnaire.xml.
        db = new MyDBManager(this);
        // A MyDBManager object is created called db which links the Questionnaire class to the MyDBManager class
        // so the answers to the questions can be inserted into the database in MyDBManager.


        //For the "Spinner age" instance variable you have to first create an ArrayList which gives the user a list of possible answers
        // to the question "What is your age?" asked in questionnaire.xml. The ageList gives you a list of Strings with the possible answers
        // and puts them into an array.
        // Create a list of strings for the Spinner
        List<String> ageList = new ArrayList<String>();
        ageList.add("Between 18 and 29.");
        ageList.add("Between 30 and 39.");
        ageList.add("Between 40 and 49.");
        ageList.add("Beween 50 and 59.");
        ageList.add("Between 60 and 69.");
        ageList.add("Between 70 and 79.");
        ageList.add("Between 80 and 89.");
        ageList.add("Between 90 and 99.");
        ageList.add("100 years or older.");


        //An ArrayAdapter object called ageDataAdapter creates a spinner menu and adds the ageList ArrayList to the spinner.
        ArrayAdapter<String> ageDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ageList);

        ageDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //ageDataAdapter calls the layout for a dropdown spinner menu.

        age.setAdapter(ageDataAdapter);
        //the age instance variable calls a setAdapter and this becomes a method with setDataAdapter as a parameter.


        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //age instance variable  calls an OnItemSelectedListener which selects whatever option the user picks from the list

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), "On Item " +
                                "Selected" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show(); //the answer selected from the list is made into a String and toasted out.

                db_age = parent.getItemAtPosition(pos).toString();
                //the instance variable db_age is assigned the value of the string selected from the list by the user.
            }

            public void onNothingSelected(AdapterView<?> paren) {
                //method for when nothing is selected.
            }

        });

        //For the "Spinner politicalParty" instance variable you have to first create an ArrayList which gives the user a list of possible answers
        // to the question "Are you a member of a political party?" asked in questionnaire.xml. The list gives you a list of Strings with the possible answers
        // and puts them into an array.
        // Create a list of strings for the Spinner
        List<String> list = new ArrayList<String>();
        list.add("No");
        list.add("Yes, but I'd rather not say which party.");
        list.add("Yes, a member of Fianna Fail");
        list.add("Yes, a member of Fine Gael");
        list.add("Yes, a member of Labour");
        list.add("Yes, a member of Sinn Fein");
        list.add("Yes, a member of Anti-Austerity Alliance");
        list.add("Yes, a member of Renua");
        list.add("Yes, a member of Social Democrats");
        list.add("Yes, a member of the Green Party");
        list.add("Yes, a member of the Workers Party");
        list.add("Yes, a member of Workers & Unemployed Action");

        //An ArrayAdapter object called dataAdapter creates a spinner menu and adds the list ArrayList to the spinner.
        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);

        //dataAdapter calls the layout for a dropdown spinner menu.
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        politicalParty.setAdapter(dataadapter);
        //the politicalParty instance variable calls a setAdapter and this becomes a method with dataAdapter as a parameter.

        politicalParty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //politicalParty instance variable  calls an OnItemSelectedListener which selects whatever option the user picks from the list

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), "On Item " +
                                "Selected" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();//the answer selected from the list is made into a String and toasted out.

                db_politicalParty = parent.getItemAtPosition(pos).toString();
                //the instance variable db_politicalParty is assigned the value of the string selected from the list by the user.
            }

            public void onNothingSelected(AdapterView<?> paren) {
                //method for when nothing is selected.
            }

        });


        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                //the instance variable gender calls OnCheckedChangeListener with a RadioGroup as a parameter
                //if one of the options are selected the then the db_gender instance variable will be assigned the value of the answer.
                //In this case db_vote will be assigned the value of "Male" or "Female".
                //Once one of these options are selected than it will break with the switch and continue reading code below this method.
                switch (id) {
                    case R.id.radio0:
                        db_gender = "Male";
                        break;
                    case R.id.radio1:
                        db_gender = "Female";
                        break;
                }
            }
        });

        vote.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup arg0, int id) {
                //the instance variable vote calls OnCheckedChangeListener with a RadioGroup as a parameter
                //if one of the options are selected the then the db_vote instance variable will be assigned the value of the answer.
                //In this case db_vote will be assigned the value of "yes" or "no".
                //Once one of these options are selected than it will break with the switch and continue reading code below this method.
                switch (id) {
                    case R.id.yes_i_will_vote:
                        db_vote = "Yes";
                        break;
                    case R.id.i_will_not_vote:
                        db_vote = "No";
                        break;
                }
            }
        });


        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //The "nextPage" Button takes the user to the Questions2 Class when clicked.
                //The "nextPage" Button calls an OnClickListener and the user is brought to the Questions2 Class using an intent object.
                //In the parameters of the intent object it calls this class (Questionnaire.this) and then the Questions2 Class(Questions2.Class).

                //This is the button the user clicks and this brings the user to the next page of questions in the poll.
                //The assigned values of the instance variables (db_age, db_political, db_vote, db_gender) are put in
                // the parameters of an intent.putExtra()method and the answers of the questions are bundled to the Questions2 Class.
                //Each answer is given a String name (example: "age") which is called in the Questions2 Class.
                Intent intent = new Intent(Questionnaire.this, Questions2.class);
                intent.putExtra("age", db_age);
                intent.putExtra("politicalParty", db_politicalParty);
                intent.putExtra("vote", db_vote);
                intent.putExtra("gender", db_gender);
                startActivity(intent);
                finish();
            }


        });
    }


}

