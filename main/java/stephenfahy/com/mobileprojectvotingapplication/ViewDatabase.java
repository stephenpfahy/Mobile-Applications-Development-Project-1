package stephenfahy.com.mobileprojectvotingapplication;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewDatabase extends AppCompatActivity {


    private MyDBManager db;//instance variable for the database.
    private Button menu;//instance variable for a button called menu which brings the user back to MainActivity.class.
    private LinearLayout container;//ListView container instance variable for a ListView which displays the database that has been created.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_database);
        //the java code is linked to view_database.xml file which outlines the layout of the android page.
        //the onCreate method bundles the java code to the view_database.xml file and the javacode makes the ListView and Button function.


        container = (LinearLayout) findViewById(R.id.database);//the "container" LinearLayout is linked to the "database" Button in view_database.xml.
        menu = (Button) findViewById(R.id.main_menu);//the "menu" Button is linked to the "main_menu" Button in view_database.xml.

        // A MyDBManager object is created called db which links the ViewDatabase class to the MyDBManager class
        // so that data from the database in MyDBManager can be printed out to ViewDatabase.
        db = new MyDBManager(this);

        db.open();//MyDBManager class is opened

        getRows(); //calls the getRows method below.

        db.close();//MyDBManager is closed

        //The "menu" Button takes the user to the MainActivity Class when clicked.
        //The "menu" Button calls an OnClickListener and the user is brought to the MainActivity Class using an intent object.
        //In the parameters of the intent object it calls this class (ViewDatabase.this) and then the MainActivity Class(MainActivity.Class).
        //This button brings the user back to the main menu after the database has been viewed or created.
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewDatabase.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }


    //---get all tasks--- with the getRows method
    public void getRows() {
        Cursor c = db.getAllVotingInformation();
        //Cursor c is assigned the value of the getAllVotingInformation()method in the MyDBManager
        if (c.moveToFirst()) {
            //if c calls the moveToFirst() method in MyDBManager than carry out the ShowTask method.
            do {
                ShowTask(c);

            }
            while (c.moveToNext());
        }
    }

    public void ShowTask(Cursor c) {//ShowTask method has Cursor c in it's parameters

        TextView text = new TextView(this);//A TextView object is created which displays the database in text format.

        //text calls setText method which prints the database out to Strings.
        text.setText("ID: " + c.getString(0) + "\n" +
                "AGE: " + c.getString(1) + "\n" +
                "GENDER: " + c.getString(2) + "\n" +
                "DID USER VOTE: " + c.getString(3) + "\n" +
                "POLITICAL PARTY: " + c.getString(4) + "\n" +
                "INCOME EARNED: " + c.getString(5) + "\n" +
                "AREA: " + c.getString(6) + "\n" +
                "DOES USER HAVE CHILDREN: " + c.getString(7) + "\n" +
                "MARRIED: " + c.getString(8) + "\n" +
                "PREFERRED GALWAY WEST CANDIDATE: " + c.getString(9) + "\n" +
                "PREFERRED TAOISEACH: " + c.getString(10) + "\n");

        container.addView(text);//the text is added to the container LinearLayout.

    }


}













