package sg.edu.rp.c346.id19022397.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btnSub;
    Spinner spn1;
    Spinner spn2;
    ArrayList<String> alSchool, alSub;
    ArrayAdapter<String> aaSchool, aaSub;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSub = findViewById(R.id.button);
        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setBuiltInZoomControls(true);


        //Initialise the arraylist
        alSchool = new ArrayList<>();
        alSchool.add("RP");
        alSchool.add("SOI");

        alSub = new ArrayList<>();
        alSub.add("Homepage");
        alSub.add("Student Life");
        alSub.add("DMSD");
        alSub.add("DIT");
        //Create an ArrayAdapter using the default Spinner layout
        aaSchool = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alSchool);
        aaSub = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alSub);
        //bind aa to spinner
        spn1.setAdapter(aaSchool);
        spn2.setAdapter(aaSub);
        //get string array to store as array
        String[] strSchool = getResources().getStringArray(R.array.sch);
        String[] strSub = getResources().getStringArray(R.array.sub);
        //convert array to list
        alSchool.addAll(Arrays.asList(strSchool));
        alSub.addAll(Arrays.asList(strSub));
        //implement onclick
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = spn1.getSelectedItemPosition();
                int pos1 = spn2.getSelectedItemPosition();
                alSchool.clear();
                if (pos == 0) {
                    if(pos1 == 0) {
                        String url = "https://www.rp.edu.sg/";
                        webView.loadUrl(url);
                    } else {
                        String url = "https://www.rp.edu.sg/student-life";
                        webView.loadUrl(url);
                    }
                } else {
                    if(pos1 == 2) {
                        String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                        webView.loadUrl(url);
                    } else {
                        String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                        webView.loadUrl(url);
                    }
                }
            }
        });
    }
}
