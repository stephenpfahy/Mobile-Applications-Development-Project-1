package stephenfahy.com.mobileprojectvotingapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.*;


public class GenderAreaPayStatisticsResult extends AppCompatActivity {

    //instance variables called here such as the TextView, LinearLayout.
    // MyDBManager to call the database, and Strings for the results bundled through from GenderAreaPayStatistics.class.
    private TextView results;
    private MyDBManager db;
    private LinearLayout container;
    private String gender;
    private String area;
    private String incomeEarned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_area_pay_statistics_results);
        //the java code is linked to gender_area_pay_statistics_results.xml file which outlines the layout of the android page.
        //the onCreate method bundles the java code to the gender_area_pay_statistics_results.xml file and the javacode makes the TextView and LinearLayout function.


        results = (TextView) findViewById(R.id.results2);//the "results" TextView is linked to the "results2" TextView in gender_area_pay_statistics_results.xml.
        container = (LinearLayout) findViewById(R.id.database2);//the "container" LinearLayout is linked to the "database2" Button in gender_area_pay_statistics_results.xml.

        db = new MyDBManager(this);//calls MyDBManager class.

        //The answers from the GenderAreaPayStatisticsResults class are sent to this class using a bundle.
        //The instance variables (gender, area, incomeEarned) are assigned the value of the answers from the
        // GenderAreaPayStatisticsResults class which have been bundled to the GenderAreaPayStatisticsResultsResults class
        // using the intent.putExtra() method and has been
        // received using the getIntent().getExtras() methods.
        Bundle bundle = getIntent().getExtras();
        gender = (bundle.getString("gender"));
        area = (bundle.getString("area"));
        incomeEarned = (bundle.getString("income"));


        //// Do Database Lookup
        db.open();

        //if the answer is "ALL" for any of the questions then select all records in that category.
        if (!gender.equals("ALL") && !incomeEarned.equals("ALL") && area.equals("ALL")) {
            getGenderAndIncomeEarned(gender, incomeEarned);
        }
        if (gender.equals("ALL") && incomeEarned.equals("ALL") && area.equals("ALL")) {
            getRows();
        }
        if (gender.equals("ALL") && !incomeEarned.equals("ALL") && !area.equals("ALL")) {
            getIncomeEarnedAndArea(incomeEarned, area);
        }
        if (!gender.equals("ALL") && incomeEarned.equals("ALL") && area.equals("ALL")) {
            getGender(gender);
        }
        if (!gender.equals("ALL") && incomeEarned.equals("ALL") && !area.equals("ALL")) {
            getGenderAndArea(gender, area);
        }
        if (gender.equals("ALL") && !incomeEarned.equals("ALL") && area.equals("ALL")) {
            getIncomeEarned(incomeEarned);
        }
        if (gender.equals("ALL") && incomeEarned.equals("ALL") && !area.equals("ALL")) {
            getArea(area);
        } else {
            // getStatistics();
            getRows(gender, area, incomeEarned);
        }


        db.close();//database closed
    }

    //methods linking to database below!

    //---get all tasks---
    public void getRows(String gender, String area, String incomeEarned) {
        Cursor c = db.getGenderAreaIncome(gender, area, incomeEarned);
        //Cursor c = db.getAllVotingInformation();
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }

   /* public void getStatistics() {
        Cursor c = db.getStatistics(gender, incomeEarned, area);

        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }*/


    public void ShowTask(Cursor c) {//printing selected records to the screen.

        TextView text = new TextView(this);

        results.append(" ID: " + c.getString(0) + "\n" +
                "AGE: " + c.getString(1) + "\n" +
                "GENDER: " + c.getString(2) + "\n" +
                "VOTE" + c.getString(3) + "\n" +
                "POLITICAL PARTY: " + c.getString(4) + "\n" +
                "INCOME EARNED: " + c.getString(5) + "\n" +
                "AREA: " + c.getString(6) + "\n" +
                "DOES USER HAVE CHILDREN: " + c.getString(7) + "\n" +
                "MARRIED: " + c.getString(8) + "\n" +
                "PREFERRED GALWAY WEST CANDIDATE: " + c.getString(9) + "\n" +
                "PREFERRED TAOISEACH CANDIDATE: " + c.getString(10) + "\n" + "\n");


        container.addView(text);


    }


    public void getGenderAndIncomeEarned(String gender, String incomeEarned) {
        Cursor c = db.getGenderAndIncomeEarned(gender, incomeEarned);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }

    public void getRows() {
        Cursor c = db.getAllVotingInformation();
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }


    public void getIncomeEarnedAndArea(String incomeEarned, String area) {
        Cursor c = db.getIncomeEarnedAndArea(incomeEarned, area);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }

    public void getGender(String gender) {
        Cursor c = db.getGender(gender);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }


    public void getGenderAndArea(String gender, String area) {
        Cursor c = db.getGenderAndArea(gender, area);

        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }


    public void getIncomeEarned(String incomeEarned) {
        Cursor c = db.getIncomeEarned(incomeEarned);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }


    public void getArea(String area) {
        Cursor c = db.getArea(area);
        if (c.moveToFirst()) {
            do {
                ShowTask(c);
            }
            while (c.moveToNext());
        }
    }


}

