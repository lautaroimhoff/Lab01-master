package isi.frsf.utn.edu.ar.lab01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int progress = 0;
    SeekBar mSeekBar;
    TextView textView;
    Button boton;
TextView intereses;
    TextView resultado;
    CheckBox renovar;

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mSeekBar.setMax(100);
        mSeekBar.setProgress(50);

        textView=(TextView) findViewById(R.id.textView);
        textView.setText(Integer.toString(50));

        intereses = (TextView) findViewById(R.id.textView8);

        resultado=(TextView) findViewById(R.id.textView9);

        renovar = (CheckBox) findViewById(R.id.checkBox);


        boton=(Button) findViewById(R.id.button);

        final EditText  edmail = (EditText)findViewById(R.id.editText2);
        final EditText edcuit = (EditText)findViewById(R.id.editText3);
        final EditText edimporte = (EditText)findViewById(R.id.editText4);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i,boolean fromUser) {
                // TODO Auto-generated method stub
            progress=i;
                textView.setText(Integer.toString(progress));
                if (!isEmpty(edimporte)){
                  if (Integer.parseInt(edimporte.getText().toString())<5000 && Integer.parseInt(textView.getText().toString())<30)
                      intereses.setText(String.valueOf(Float.parseFloat(edimporte.getText().toString())*(Math.pow((1+Float.parseFloat(getResources().getString(R.string.ceroa5000menor30))),(Float.parseFloat(textView.getText().toString())/360))-1)));
                    else if (Integer.parseInt(edimporte.getText().toString())<5000 && Integer.parseInt(textView.getText().toString())>=30)
                      intereses.setText(String.valueOf(Float.parseFloat(edimporte.getText().toString())*(Math.pow((1+Float.parseFloat(getResources().getString(R.string.ceroa5000mayor30))),(Float.parseFloat(textView.getText().toString())/360))-1)));
                    else if (Integer.parseInt(edimporte.getText().toString())>5000 && Integer.parseInt(edimporte.getText().toString())<99999 && Integer.parseInt(textView.getText().toString())<30)
                      intereses.setText(String.valueOf(Float.parseFloat(edimporte.getText().toString())*(Math.pow((1+Float.parseFloat(getResources().getString(R.string.cincomila999999menor30))),(Float.parseFloat(textView.getText().toString())/360))-1)));
                    else if (Integer.parseInt(edimporte.getText().toString())>5000 && Integer.parseInt(edimporte.getText().toString())<99999 && Integer.parseInt(textView.getText().toString())>=30)
                      intereses.setText(String.valueOf(Float.parseFloat(edimporte.getText().toString())*(Math.pow((1+Float.parseFloat(getResources().getString(R.string.cincomila999999mayor30))),(Float.parseFloat(textView.getText().toString())/360))-1)));
                    else if (Integer.parseInt(edimporte.getText().toString())>99999 && Integer.parseInt(textView.getText().toString())<30)
                      intereses.setText(String.valueOf(Float.parseFloat(edimporte.getText().toString())*(Math.pow((1+Float.parseFloat(getResources().getString(R.string.mas999999menor30))),(Float.parseFloat(textView.getText().toString())/360))-1)));
                    else if (Integer.parseInt(edimporte.getText().toString())>99999 && Integer.parseInt(textView.getText().toString())>30)
                      intereses.setText(String.valueOf(Float.parseFloat(edimporte.getText().toString())*(Math.pow((1+Float.parseFloat(getResources().getString(R.string.mas999999mayor30))),(Float.parseFloat(textView.getText().toString())/360))-1)));
                }


            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(edmail) || isEmpty(edcuit) || isEmpty(edimporte)){
                    resultado.setText("Error! Complete todos los campos");
                    resultado.setTextColor(getResources().getColor(R.color.Error));}
                else{
                    if (renovar.isChecked()==true)
                    resultado.setText("Plazo Fijo Realizado. Recibira $" + intereses.getText() +" al vencimiento!");
                    else resultado.setText("Plazo Fijo Realizado");
                resultado.setTextColor(getResources().getColor(R.color.Exito));}
            }
        });



    }




}
