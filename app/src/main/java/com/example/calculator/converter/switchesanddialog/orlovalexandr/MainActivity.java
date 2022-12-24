package com.example.calculator.converter.switchesanddialog.orlovalexandr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chbs = new CheckBox[4];
    EditText[] etsPrices = new EditText[4];
    EditText[] etsCount = new EditText[4];
    TextView tvResult;
    RadioButton[] rbs = new RadioButton[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etsPrices[0] = findViewById(R.id.etApplePrice);
        etsPrices[1] = findViewById(R.id.etStrberPrice);
        etsPrices[2] = findViewById(R.id.etBlberPrice);
        etsPrices[3] = findViewById(R.id.etPotPrice);

        etsCount[0] = findViewById(R.id.etAppleCount);
        etsCount[1] = findViewById(R.id.etStrberCount);
        etsCount[2] = findViewById(R.id.etBlberCount);
        etsCount[3] = findViewById(R.id.etPotCount);

        chbs[0] = findViewById(R.id.chbApple);
        chbs[1] = findViewById(R.id.chbStrber);
        chbs[2] = findViewById(R.id.chbBlber);
        chbs[3] = findViewById(R.id.chbPot);

        rbs[0] = findViewById(R.id.rbToast); rbs[0].setChecked(true);
        rbs[1] = findViewById(R.id.rbTextView);
        rbs[2] = findViewById(R.id.rbDialog);

        tvResult = findViewById(R.id.tvResult);
    }

    public void Culc(View v)
    {
        double sum = 0, prc; int i, cnt;
        for (i = 0; i < 4; i++)
        {
            if (chbs[i].isChecked())
            {
                try
                {
                    prc = Double.parseDouble(etsPrices[i].getText().toString());
                    cnt = Integer.parseInt(etsCount[i].getText().toString());
                }
                catch (Exception e)
                {
                    Toast toast = Toast.makeText(this, "Ошибка конвертации в числа!", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                sum += prc * cnt;
            }
        }


        if (rbs[0].isChecked())
        {
            Toast toast = Toast.makeText(this, String.format("Total: %.2f", sum), Toast.LENGTH_LONG);
            toast.show();
        }
        if (rbs[1].isChecked())
        {
            tvResult.setText(String.format("Total: %.2f", sum));
        }
        if (rbs[2].isChecked())
        {
            AlertDialog.Builder bld = new AlertDialog.Builder(this);
            AlertDialog dlg = bld.create();
            dlg.setIcon(R.drawable.icon);
            dlg.setTitle("Result");
            dlg.setMessage(String.format("Total: %.2f", sum));
            dlg.show();
        }
    }
}