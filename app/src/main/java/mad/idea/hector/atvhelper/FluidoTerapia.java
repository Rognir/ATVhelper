package mad.idea.hector.atvhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class FluidoTerapia extends AppCompatActivity {

    TextView fade_text;

    RadioGroup vInfusion;
    RadioButton radioInfusion;
    SeekBar vPerdidas;
    EditText vMantenimiento;
    TextView total;
    Button calcular;
    Double infusion;
    Double perdidas;
    Double mantenimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fluido_terapia);

        vInfusion = (RadioGroup)findViewById(R.id.radiovInfusionButton);
        fade_text = (TextView)findViewById(R.id.textView1);
        vPerdidas = (SeekBar)findViewById(R.id.VPerdidas);
        vPerdidas.setMax(12);
        vPerdidas.setProgress(1);

        vPerdidas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                say_minutes_left(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                fade_text.setText("");
            }
        });
        vMantenimiento = (EditText)findViewById(R.id.VMantenimiento);
        total = (TextView)findViewById(R.id.textView);
        calcular = (Button)findViewById(R.id.Calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = vInfusion.getCheckedRadioButtonId();
                radioInfusion = (RadioButton) findViewById(selectedId);
                radioInfusion.getText();
                if(radioInfusion.getText().toString().contains("200")) {
                    infusion = 200.0;
                }
                if(radioInfusion.getText().toString().contains("400")){
                    infusion=400.0;
                }
                if (radioInfusion.getText().toString().contains("Sin vómito")){
                    infusion =0.0;
                }
                perdidas = (double)vPerdidas.getProgress();
                if(TextUtils.isEmpty(vMantenimiento.getText())) {
                    Toast.makeText(FluidoTerapia.this,"No has introducido Kg",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mantenimiento = Double.parseDouble(vMantenimiento.getText().toString());
                    calcularVolumen(infusion,perdidas,mantenimiento);
                }
            }
        });
    }
    private void calcularVolumen (Double infusion,Double perdidas,Double kg) {
        double preTotal = 0;
        if (kg >= 16) {
            preTotal = infusion + (perdidas * (kg) * 10) + (40 * kg);
        } else if (kg < 16) {
            preTotal = infusion + (perdidas * (kg) * 10) + (60 * kg);
        }
        total.setText("Volumen total = " + String.valueOf(preTotal) + "ml/24h " +
                "\nVolumen total = " + String.valueOf(String.format("%.2f", preTotal / 24)) + "ml/1h");
    }
    //Mover y mostrar el porcentaje de deshidratación.
    private void say_minutes_left(int how_many)
    {
        String what_to_say = String.valueOf(how_many);
        fade_text.setText(what_to_say);

        int left = vPerdidas.getLeft() + vPerdidas.getPaddingLeft();
        int right = vPerdidas.getRight() - vPerdidas.getPaddingRight();
        int seek_label_pos = ((( right- left) * vPerdidas.getProgress()) / vPerdidas.getMax()) + vPerdidas.getLeft();
        fade_text.setX((seek_label_pos - fade_text.getWidth() / 2)+140);
    }
}
