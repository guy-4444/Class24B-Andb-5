package com.guy.class24b_andb_5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.guy.currencydialog.CurrencyManager;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTM_open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_BTM_open = findViewById(R.id.main_BTM_open);
        main_BTM_open.setOnClickListener(v -> openDialog());


    }

    private void openDialog() {
        CurrencyManager.openCurrencyDialog(this, new CurrencyManager.CallBack_Currency() {
            @Override
            public void selected(String name, String Code, String symbol) {
                main_BTM_open.setText(symbol);
            }
        });
    }
}