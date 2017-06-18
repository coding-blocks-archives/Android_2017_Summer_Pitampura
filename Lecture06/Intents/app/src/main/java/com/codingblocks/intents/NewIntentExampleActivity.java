package com.codingblocks.intents;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewIntentExampleActivity extends AppCompatActivity {

    EditText etWebAddr;
    Button btnOpenLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_intent_example);

        btnOpenLink = (Button) findViewById(R.id.btnOpenLink);
        etWebAddr = (EditText) findViewById(R.id.etWebAddr);

        btnOpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkToGo = etWebAddr.getText().toString();

                try {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(linkToGo));
                    startActivity(i);
                } catch (ActivityNotFoundException anfe) {
                    Toast.makeText(NewIntentExampleActivity.this, "Activity not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
