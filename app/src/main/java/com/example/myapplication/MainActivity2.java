package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText Nom1;
    private EditText Apell1;

    private EditText Carg1;

    private EditText Sueldo1;
    private EditText Diaslb1;

    private CheckBox checkDescuento, checkSalud, checkPension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Nom1 = ( EditText)findViewById(R.id.Nom1);
        Apell1 = (EditText)findViewById(R.id.Apell1);
        Carg1 = (EditText)findViewById(R.id.Carg1);
        Sueldo1 = (EditText)findViewById(R.id.Sueldo1);
        Diaslb1 = (EditText)findViewById(R.id.Diaslb1);

        checkDescuento = findViewById(R.id.Descuento);
        checkSalud = findViewById(R.id.Salud);
        checkPension = findViewById(R.id.Pension);

    }
    public void Regresar(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Liquidar(View view){
        Intent i = new Intent(this, MainActivity3.class);


        double sueldoInicial = Double.parseDouble(Sueldo1.getText().toString());

        boolean descuento = checkDescuento.isChecked();
        boolean salud = checkSalud.isChecked();
        boolean pension = checkPension.isChecked();

        double porcentajeDescuento = 0;

        if (descuento) {
            porcentajeDescuento +=  3;

            double descuento_ = sueldoInicial * 0.03;
            i.putExtra("descuento",descuento_);
        }
        if (salud) {
            porcentajeDescuento += 4;
            double salud_ = sueldoInicial * 0.04;
            i.putExtra("salud",salud_);
        }
        if (pension) {
            porcentajeDescuento += 4;
            double pension_ = sueldoInicial * 0.04;
            i.putExtra("pension",pension_);
        }

        // calcular descuento total
        double descuentoObtenido = sueldoInicial * (porcentajeDescuento / 100);

        //calcular el valor por dia

        double dias = Double.parseDouble(Diaslb1.getText().toString());

        double valor_dia = sueldoInicial / 30;

        double salario_bruto = valor_dia *  dias;

        double sueldoNeto = salario_bruto - descuentoObtenido;



        i.putExtra("Nombres", Nom1.getText().toString());
        i.putExtra("Apellidos", Apell1.getText().toString());
        i.putExtra("Cargo", Carg1.getText().toString());
        i.putExtra("Sueldo", Sueldo1.getText().toString());
        i.putExtra("Dias", Diaslb1.getText().toString());
        i.putExtra("sueldo_neto", sueldoNeto);
        i.putExtra("salario_bruto", valor_dia);


        startActivity(i);
    }
}