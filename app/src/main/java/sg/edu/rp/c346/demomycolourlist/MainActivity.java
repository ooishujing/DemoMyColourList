package sg.edu.rp.c346.demomycolourlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText etColour;
EditText etIndexElement;
Button btnAddItem;
ListView lvColour;
ArrayList <String> alColours;
ArrayAdapter aaColour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etColour = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAddItem = findViewById(R.id.btnAddItem);
        lvColour = findViewById(R.id.lv);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etColour.getText().toString();
                int position = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(position,colour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),alColours.get(position),Toast.LENGTH_SHORT).show();


            }
        });

    }


}
