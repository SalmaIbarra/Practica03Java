package com.example.practica03_java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {
    private Button btnSumar;
    private Button btnRestar;
    private Button btnMultiplicar;
    private Button btnDividir;
    private Button btnRegresar;
    private Button btnLimpiar;
    private TextView lblUsuario;
    private TextView lblResultado;
    private EditText txtUno;
    private EditText txtDos;

    private Calculadora calculadora = new Calculadora(0, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        iniciarComponentes();

        String strUsuario;
        String strContraseña;

        strUsuario = getResources().getString(R.string.usuario);
        lblUsuario.setText(strUsuario.toString());

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSumar();
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRestar();
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMultiplicar();
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDividir();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLimpiar();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegresar();
            }
        });
    }

    private void iniciarComponentes() {
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMulti);
        btnDividir = findViewById(R.id.btnDivision);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        lblUsuario = findViewById(R.id.lblUsuario);
        lblResultado = findViewById(R.id.lblResultado);
        txtUno = findViewById(R.id.txtNum1);
        txtDos = findViewById(R.id.txtNum2);
    }

    private void btnSumar() {
        calculadora.num1 = (Integer.parseInt(txtUno.getText().toString()));
        calculadora.num2 = (Integer.parseInt(txtDos.getText().toString()));
        int total = calculadora.suma();
        lblResultado.setText(String.valueOf(total));
    }

    private void btnRestar() {
        calculadora.num1 = (Integer.parseInt(txtUno.getText().toString()));
        calculadora.num2 = (Integer.parseInt(txtDos.getText().toString()));
        int total = calculadora.resta();
        lblResultado.setText(String.valueOf(total));
    }

    private void btnMultiplicar() {
        calculadora.num1 = (Integer.parseInt(txtUno.getText().toString()));
        calculadora.num2 = (Integer.parseInt(txtDos.getText().toString()));
        int total = calculadora.multiplicar();
        lblResultado.setText(String.valueOf(total));
    }

    private void btnDividir() {
        calculadora.num1 = (Integer.parseInt(txtUno.getText().toString()));
        calculadora.num2 = (Integer.parseInt(txtDos.getText().toString()));
        int total = calculadora.division();
        lblResultado.setText(String.valueOf(total));
    }

    private void btnLimpiar() {
        lblResultado.setText("");
        txtUno.setText("");
        txtDos.setText("");
    }

    private void btnRegresar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);

        confirmar.setTitle("Calculadora");
        confirmar.setMessage("¿Regresar al MainActivity?");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No hacer nada
            }
        });

        confirmar.show();
    }
}