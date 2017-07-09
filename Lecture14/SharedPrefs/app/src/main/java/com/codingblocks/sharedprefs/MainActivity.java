package com.codingblocks.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;
    SharedPreferences preferences;

    public static final String PREF_KEY_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        preferences = getPreferences(MODE_PRIVATE);

        String savedValue = preferences.getString(PREF_KEY_TEXT, null);
        if (savedValue != null) {
            textView.setText(savedValue);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(
                        editText.getText().toString()
                );

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(PREF_KEY_TEXT, editText.getText().toString());
                // Write other keys into the editor, and then
                editor.apply();

            }
        });

    }
}
