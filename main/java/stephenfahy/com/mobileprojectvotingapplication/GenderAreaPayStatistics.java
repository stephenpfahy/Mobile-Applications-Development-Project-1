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


public class GenderAreaPayStatistics extends AppCompatActivity {

    private Spinner genderSpinner, areaSpinner, incomeSpinner;
    private Button submit;

    private String db_gender;
    private String db_area;
    private String db_income;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_area_pay_statistics);

        genderSpinner = (Spinner) findViewById(R.id.gender_statistics);
        areaSpinner = (Spinner) findViewById(R.id.area_stats);
        incomeSpinner = (Spinner) findViewById(R.id.wage_statistics);
        submit = (Button) findViewById(R.id.submitstats2);

        //start of genderSpinner below
        // Create a list of strings for the Spinner
        List<String> genderList = new ArrayList<String>();
        genderList.add("ALL");
        genderList.add("Male");
        genderList.add("Female");


        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, genderList);

        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genderSpinner.setAdapter(dataadapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), "On Item " +
                                "Selected" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

                db_gender = parent.getItemAtPosition(pos).toString();
            }

            public void onNothingSelected(AdapterView<?> paren) {


            }

        });

        //start of areaSpinner below.
        List<String> areaList = new ArrayList<String>();
        areaList.add("ALL");
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


        ArrayAdapter<String> dataadapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, areaList);

        dataadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        areaSpinner.setAdapter(dataadapter2);


        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), "On Item " +
                                "Selected" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

                db_area = parent.getItemAtPosition(pos).toString();
            }

            public void onNothingSelected(AdapterView<?> paren) {


            }

        });

        //Start of Spinner incomeSpinner.
        //incomeList arrayList for the incomeSpinner Spinner.
        List<String> incomeList = new ArrayList<String>();
        incomeList.add("ALL");
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


        ArrayAdapter<String> dataadapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, incomeList);

        dataadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        incomeSpinner.setAdapter(dataadapter3);


        incomeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(parent.getContext(), "On Item " +
                                "Selected" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();

                db_income = parent.getItemAtPosition(pos).toString();
            }

            public void onNothingSelected(AdapterView<?> paren) {


            }

        });

        //submit button which rings the user to the GenderAreaPayStatisticsResult Class using an intent.
        //and bundles the answers of all the spinners to the GenderAreaPayStatisticsResult Class
        // using the intent.putExtra() method.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GenderAreaPayStatistics.this, GenderAreaPayStatisticsResult.class);
                intent.putExtra("gender", db_gender);
                intent.putExtra("area", db_area);
                intent.putExtra("income", db_income);
                startActivity(intent);
            }
        });


    }


}


