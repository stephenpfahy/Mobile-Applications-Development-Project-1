package stephenfahy.com.mobileprojectvotingapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Eligibility extends AppCompatActivity {

    //instance variables for two TextViews and Buttons which bring the user to another page.

    private TextView areYouEligible;
    private TextView areYouEligible2;
    private Button Yes;
    private Button No;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eligibility);
        //the java code is linked to eligibility.xml file which outlines the layout of your android page
        //the onCreate method bundles the java code to the eligibility.xml file and the javacode makes the button and text function.


        areYouEligible = (TextView) findViewById(R.id.eligible);//the "areYouEligible" TextView is linked to the "eligible" TextView in eligibility.xml.
        areYouEligible2 = (TextView) findViewById(R.id.eligible2);//the "areYouEligible2" TextView is linked to the "eligible2" TextView in eligibility.xml.
        Yes = (Button) findViewById(R.id.yes);//The "Yes" Button is linked to the "yes" Button in eligibility.xml.
        No = (Button) findViewById(R.id.no);//The "No" Button is linked to the "no" Button in eligibility.xml.

        // The intents will not display the page on the screen unless the class is called in the AndroidManifest.xml as follows:
        // <activity android:name=".Eligibility"
        //android:screenOrientation="portrait"> </activity>
        //The screenOrientation makes sure that the screen is displayed as a portrait.


        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Eligibility.this, MainActivity.class);
                startActivity(intent);
                //The "No" Button takes the user to the MainActivity Class when clicked.
                //The "No" Button calls an OnClickListener and the user is brought to the MainActivity Class using an intent object.
                //In the parameters it calls this class (Eligibility.this) and then the MainActivity Class(MainActivity.Class).
                //This is the button the user clicks and it brings the user back to the MainActivity Class.
                //The user is then asked not to partake in the survey if they are not eligible to vote.
            }
        });


        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Eligibility.this, Questionnaire.class);
                startActivity(intent);
                //The "Yes" Button takes the user to the Questionnaire Class when clicked.
                //The "Yes" Button calls an OnClickListener and the user is brought to the Questionnaire Class using an intent object.
                //In the parameters it calls this class (Eligibility.this) and then the Questionnaire Class(Questionnaire.Class).
                //This is the button the user clicks and it brings the user to the questions in the poll.
            }


        });

    }


}

