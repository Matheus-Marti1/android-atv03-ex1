/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.atv3ex1combustivel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etGasolina;
    private EditText etEtanol;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etGasolina = findViewById(R.id.etGasolina);
        etEtanol = findViewById(R.id.etEtanol);
        tvRes = findViewById(R.id.tvRes);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc() {
        tvRes.setText("");
        double precoGasolina = Double.parseDouble(etGasolina.getText().toString());
        double precoEtanol = Double.parseDouble(etEtanol.getText().toString());
        if (precoEtanol <= (precoGasolina * 0.70)) {
            tvRes.setText(R.string.res_etanol);
        } else {
            tvRes.setText(R.string.res_gasolina);
        }
        etGasolina.setText("");
        etEtanol.setText("");
    }
}