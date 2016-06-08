package stephenfahy.com.mobileprojectvotingapplication;

        import android.database.Cursor;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import java.lang.*;


public class AgePoliticalPartyStatisticsResult extends AppCompatActivity {

    //instance variables called here such as the TextView, LinearLayout, ints,
    // MyDBManager to call the database, and Strings for the results bundled through from AgePoliticalPartyStatistics.class.


    private TextView results;
    private MyDBManager db;
    private int upperage;
    private int lowerage;
    private LinearLayout container;
    private String age;
    private String politicalParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age_political_party_statistics_results);
        //the java code is linked to age_political_party_statistics_results.xml file which outlines the layout of the android page.
        //the onCreate method bundles the java code to the age_political_party_statistics_results.xml file and the javacode makes the TextView and LinearLayout function.


        results = (TextView)findViewById(R.id.results);//the "results" TextView is linked to the "results" TextView in age_political_party_statistics_results.xml.
        container = (LinearLayout)findViewById(R.id.database);//the "container" LinearLayout is linked to the "database" Button in age_political_party_statistics_results.xml.

        db = new MyDBManager(this);//calls MyDBManager class.

        //The answers from the AgePoliticalPartyStatistics class are sent to this class using a bundle.
        //The instance variables (age, politicalParty) are assigned the value of the answers from the
        // AgePoliticalPartyStatistics class which have been bundled to the AgePoliticalPartyStatisticsResults class
        // using the intent.putExtra() method and has been
        // received using the getIntent().getExtras() methods.
        Bundle bundle = getIntent().getExtras();
        age = (bundle.getString("age"));
        politicalParty = (bundle.getString("politicalParty"));


        //// Do Database Lookup

        db.open();//database opened.

        getRows(age,politicalParty);
        //The get rows method is called and the results from the spinners in AgePoliticalPartyStatistics.class
        // are matched with the records in the MyDBManager.class with the records with the same information in them.
        //The records in the database with the same results as the answers are printed out to screen.

        db.close();//database closed.
    }


    //---get all tasks---
    public void getRows(String age, String politicalParty) {
        Cursor c = db.getAgeAndPoliticalParty(age, politicalParty);//c is assigned the value of getAgeAndPoliticalParty() method in MyDBManager Class.
        //Cursor c = db.getAllVotingInformation();
        if (c.moveToFirst()) {
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }

    public void ShowTask(Cursor c)
    {

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

}
