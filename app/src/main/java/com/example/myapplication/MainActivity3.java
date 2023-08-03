package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView Nom2;
    private TextView Apell2;
    private TextView Carg2;
    private TextView Sueldo2;
    private TextView Diaslb2;

    private TextView Sub_total;

    private TextView Valor_dia;
    private TextView salud_v ;
    private TextView descuento_v ;
    private TextView pension_v ;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Nom2 = (TextView)findViewById(R.id.Nom2);
        Apell2 = (TextView)findViewById(R.id.Apell2);
        Carg2 = (TextView)findViewById(R.id.Carg2);
        Sueldo2 = (TextView)findViewById(R.id.Sueldo2);
        Diaslb2 = (TextView)findViewById(R.id.Diaslb2);
        Sub_total = (TextView)findViewById(R.id.subtotal);
        Valor_dia = (TextView) findViewById(R.id.ValorDia);
        salud_v = (TextView) findViewById(R.id.saludvista);
        descuento_v = (TextView) findViewById(R.id.DescuentoVIista);
        pension_v = (TextView) findViewById(R.id.pensionvista);


        String Nombres = getIntent().getStringExtra("Nombres");
        Nom2.setText(Nombres);

        String Cargo = getIntent().getStringExtra("Cargo");
        Carg2.setText("Cargo: " + Cargo);

        String Apellidos = getIntent().getStringExtra("Apellidos");
        Apell2.setText(Apellidos);

        String Dias = getIntent().getStringExtra("Dias");
        Diaslb2.setText("Dias: " + Dias);

        String Sueldo = getIntent().getStringExtra("Sueldo");
        Sueldo2.setText("sueldo: " + Sueldo);

        double sueldoNeto = getIntent().getDoubleExtra("sueldo_neto", 0.0);
        Sub_total.setText(String.valueOf("Sueldo Neto: " + sueldoNeto));

        double valor_dias = getIntent().getDoubleExtra("salario_bruto", 0.0);
        Valor_dia.setText(String.valueOf("Valor dia: " + valor_dias));

        double salud = getIntent().getDoubleExtra("salud", 0.0);
        salud_v.setText(String.valueOf("Valor salud: " + salud));

        double pension = getIntent().getDoubleExtra("pension", 0.0);
        pension_v.setText(String.valueOf("Valor pension: " + pension));

        double descuento = getIntent().getDoubleExtra("descuento", 0.0);
        descuento_v.setText(String.valueOf("Valor descuento: " + descuento));



    }
    public void Salir(View View){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}