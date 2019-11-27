package com.example.immadisairaj.codeforces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        EditText handleText = findViewById(R.id.et_handle);
        String handle = handleText.getText().toString();

        if (handle.isEmpty()) {
            TextView reEnter = findViewById(R.id.tv_re_enter);
            reEnter.setText(R.string.msg_enter_handle_again);
            reEnter.setVisibility(View.VISIBLE);
        } else if (handle.contains(",")) {
            TextView reEnter = findViewById(R.id.tv_re_enter);
            reEnter.setText(R.string.msg_only_one_handle);
            reEnter.setVisibility(View.VISIBLE);
        } else {
            TextView reEnter = findViewById(R.id.tv_re_enter);
            reEnter.setVisibility(View.GONE);
            Intent intent = new Intent(this, InfoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(getString(R.string.label_handle), handle);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

}