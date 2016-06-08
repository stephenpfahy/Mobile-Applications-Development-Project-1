package stephenfahy.com.mobileprojectvotingapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AgePoliticalPartyStatistics extends AppCompatActivity {

    //instance variables for the Spinners and for a button which brings the user to another page.
    private Spinner spinner1, spinner2;
    private Button submit;

    //The String instance variables (db_age, db_politicalParty) are for putting the answers of the question into the database to query.
    private String db_age;
    private String db_politicalParty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age_political_party_statistics);
        //the java code is linked to age_political_party_statistics.xml file which outlines the layout of your android page
        //the onCreate method bundles the java code to the age_political_party_statistics.xml file and the javacode makes the Spinners
        // and Button function.

        spinner1 = (Spinner) findViewById(R.id.agebracket);//The "spinner1" Spinner is linked to the "agebracket" Button in age_political_party_statistics.xml.
        spinner2 = (Spinner) findViewById(R.id.party);//The "spinner2" Spinner is linked to the "party" Button in age_political_party_statistics.xml.
        submit = (Button) findViewById(R.id.submitstats);//The "submit" Spinner is linked to the "submitstats" Button in age_political_party_statistics.xml.


        // For the "Spinner spinner1" instance variable you have to first create an ArrayList which gives the user a list of possible answers
        // to the question "Which of the following age bracket's do you want statistics for?"" asked in age_political_party_statistics.xml.
        // The ageList gives you a list of Strings with the possible answers
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

        //An ArrayAdapter object called dataAdapter creates a spinner menu and adds the ageList ArrayList to the spinner.
        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ageList);

        //dataAdapter calls the layout for a dropdown spinner menu.
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //the spinner1 instance variable calls a setAdapter and this becomes a method with dataAdapter as a parameter.
        spinner1.setAdapter(dataadapter);

        //spinner1 instance variable  calls an OnItemSelectedListener which selects whatever option the user picks from the list
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), "On Item " +
                                "Selected" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();//the answer selected from the list is made into a String and toasted out.

                db_age = parent.getItemAtPosition(pos).toString();
                //the instance variable db_age is assigned the value of the string selected from the list by the user.
            }

            public void onNothingSelected(AdapterView<?> paren) {
                //method for when nothing is selected.
            }

        });

        // For the "Spinner spinner2" instance variable you have to first create an ArrayList which gives the user a list of possible answers
        // to the question "What political party do you want statistics for?"" asked in age_political_party_statistics.xml.
        // The list2 Arraylist gives you a list of Strings with the possible answers
        // and puts them into an array.
        List<String> list2 = new ArrayList<String>();
        list2.add("No");
        list2.add("Yes, but I'd rather not say which party.");
        list2.add("Yes, a member of Fianna Fail");
        list2.add("Yes, a member of Fine Gael");
        list2.add("Yes, a member of Labour");
        list2.add("Yes, a member of Sinn Fein");
        list2.add("Yes, a member of Anti-Austerity Alliance");
        list2.add("Yes, a member of Renua");
        list2.add("Yes, a member of Social Democrats");
        list2.add("Yes, a member of the Green Party");
        list2.add("Yes, a member of the Workers Party");
        list2.add("Yes, a member of Workers & Unemployed Action");

        //An ArrayAdapter object called dataadapter2 creates a spinner menu and adds the list2 ArrayList to the spinner.
        ArrayAdapter<String> dataadapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);

        //dataadapter2 calls the layout for a dropdown spinner menu.
        dataadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //the spinner2 instance variable calls a setAdapter and this becomes a method with dataadapter2 as a parameter.
        spinner2.setAdapter(dataadapter2);

        //spinner2 instance variable  calls an OnItemSelectedListener which selects whatever option the user picks from the list
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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

        //The "submit" Button takes the user to the AgePoliticalPartyStatisticsResult Class when clicked.
        //The "submit" Button calls an OnClickListener and the user is brought to the AgePoliticalPartyStatisticsResult Class using an intent object.
        //In the parameters of the intent object it calls this class (AgePoliticalPartyStatistics.this) and then the AgePoliticalPartyStatisticsResult Class(AgePoliticalPartyStatisticsResult.Class).

        //This is the button the user clicks and that shows them all the records in the database which match the answers of their questions.
        //The assigned values of the instance variables (db_age, db_political) are put in
        // the parameters of an intent.putExtra()method and the answers of the questions are bundled to the AgePoliticalPartyStatisticsResult Class.
        //Each answer is given a String name (example: "age") which is called in the AgePoliticalPartyStatisticsResult Class.

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgePoliticalPartyStatistics.this, AgePoliticalPartyStatisticsResult.class);
                intent.putExtra("age", db_age);
                intent.putExtra("politicalParty", db_politicalParty);
                startActivity(intent);
            }
        });


    }


}

