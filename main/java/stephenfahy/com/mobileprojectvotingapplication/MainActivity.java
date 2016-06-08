package stephenfahy.com.mobileprojectvotingapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //instance variables for title text and buttons which bring the user to another page.
    private TextView welcome1;
    private Button generateStatistics;
    private Button takePoll;
    private Button viewDatabaseButton;
    private Button exitApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //the java code is linked to activity_main.xml file which outlines the layout of your android page
        //the onCreate method bundles the java code to the activity_main xml file and the javacode makes the button and text function.

        welcome1 = (TextView) findViewById(R.id.welcome);//the "welcome1" TextView is linked to the "welcome" TextView in activity_main.xml.
        takePoll = (Button) findViewById(R.id.poll); //the "takePoll" Button is linked to the "poll" Button in activity_main.xml.
        viewDatabaseButton = (Button) findViewById(R.id.view_database);//the "viewDatabaseButton" Button is linked to the "view_database" Button in activity_main.xml.
        generateStatistics = (Button) findViewById(R.id.statistics);//the "generateStatistics" Button is linked to the "statistics" Button in activity_main.xml.
        exitApp = (Button) findViewById(R.id.exit);//the "exitApp" Button is linked to the "exit" Button in activity_main.xml.


        takePoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Eligibility.class);
                startActivity(intent);
            }
            //The "takePoll" Button takes the user to the Eligibility Class when clicked.
            //The "takePoll" Button calls an OnClickListener and the user is brought to the Eligibility Class using an intent object.
            //In the parameters it calls this class (MainActivity.this) and then the Eligibility Class(Eligibility.Class).
            //This is the button the user clicks to take the poll.
        });


        viewDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewDatabase.class);
                startActivity(intent);
            }
            //The "viewDatabaseButton" Button takes the user to the ViewDatabase Class when clicked.
            //The "viewDatabaseButton" Button calls an OnClickListener and the user is brought to the ViewDatabase Class using an intent object.
            //In the parameters it calls this class (MainActivity.this) and then the ViewDatabase Class(ViewDatabase.Class).
            //This is the button the user clicks to view the database which is created after the user or multiple users take the poll
        });

        generateStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatisticsMenu.class);
                startActivity(intent);

                //The "generateStatistics" Button takes the user to the StatisticsMenu Class when clicked.
                //The "generateStatistics" Button calls an OnClickListener and the user is brought to the StatisticsMenu Class using an intent object.
                //In the parameters it calls this class (MainActivity.this) and then the StatisticsMenu Class(StatisticsMenu.Class).
                //This is the button the user clicks to view the statistics.
                // The user can only view statistics after records have been added to the the database by answering questions in the classes linked to the "takePoll" button.

            }
        });

        //The "exitApp" Button exits the application when clicked.
        //The "exitApp" Button calls an OnClickListener and calls the finish() method and the system.exit() method.
        exitApp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();
                System.exit(0);
            }
        });
    }


}
