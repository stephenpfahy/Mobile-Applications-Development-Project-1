package stephenfahy.com.mobileprojectvotingapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StatisticsMenu extends AppCompatActivity {

    //instance variables for title text and buttons which bring the user to another page.
    private TextView statisticsMenu;
    private Button agePoliticalParty;
    private Button areaGenderPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_menu);
        //the java code is linked to statistics_menu.xml file which outlines the layout of your android page
        //the onCreate method bundles the java code to the statistics_menu.xml file and the javacode makes the button and text function.

        statisticsMenu = (TextView) findViewById(R.id.statistics_menu_title);//the "statisticsMenu" TextView is linked to the "statistics_menu_title" TextView in statistics_menu.xml.
        agePoliticalParty = (Button) findViewById(R.id.age_political_party);//the "agePoliticalParty" Button is linked to the "age_political_party" Button in statistics_menu.xml.
        areaGenderPay = (Button) findViewById(R.id.age_gender_pay);//the "areaGenderPay" Button is linked to the "age_gender_pay" Button in statistics_menu.xml.

        //The "agePoliticalParty" Button takes the user to the AgePoliticalPartyStatistics Class when clicked.
        //The "agePoliticalParty" Button calls an OnClickListener and the user is brought to the AgePoliticalPartyStatistics Class using an intent object.
        //In the parameters it calls this class (StatisticsMenu.this) and then the AgePoliticalPartyStatistics Class(AgePoliticalPartyStatistics.Class).
        //This is the button the user clicks to check the statistics of database and
        // selecting records in the database by the answers on questions based on age of the person
        // and their preferred political party.
        agePoliticalParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsMenu.this, AgePoliticalPartyStatistics.class);
                startActivity(intent);
            }


        });

        //The "areaGenderPay" Button takes the user to the GenderAreaPayStatistics Class when clicked.
        //The "areaGenderPay" Button calls an OnClickListener and the user is brought to the GenderAreaPayStatistics Class using an intent object.
        //In the parameters it calls this class (StatisticsMenu.this) and then the GenderAreaPayStatistics Class(GenderAreaPayStatistics.Class).
        //This is the button the user clicks to check the statistics of database and
        // selecting records in the database by the answers of the questions based on the area that people taking part in the poll live in,
        // , their gender and also the income that they earn per year.
        areaGenderPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsMenu.this, GenderAreaPayStatistics.class);
                startActivity(intent);
            }
        });


    }


}



