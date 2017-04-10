package com.example.dinker.calculette;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    //On déclare nos variables
    Button Bouton0;
    Button Bouton1;
    Button Bouton2;
    Button Bouton3;
    Button bouton4;
    Button Bouton5;
    Button Bouton6;
    Button Bouton7;
    Button Bouton8;
    Button Bouton9;
    Button BoutonPlus;
    Button BoutonMoins;
    Button BoutonDiviser;
    Button BoutonMulti;
    Button BoutonClear;
    Button BoutonEgal;
    Button BoutonVirgule;
    EditText Resultat;

    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On recup grâce aux ID
        Bouton0 = (Button) findViewById(R.id.Bouton0);
        Bouton1 = (Button) findViewById(R.id.Bouton1);
        Bouton2 = (Button) findViewById(R.id.Bouton2);
        Bouton3 = (Button) findViewById(R.id.Bouton3);
        bouton4 = (Button) findViewById(R.id.bouton4);
        Bouton5 = (Button) findViewById(R.id.Bouton5);
        Bouton6 = (Button) findViewById(R.id.Bouton6);
        Bouton7 = (Button) findViewById(R.id.Bouton7);
        Bouton8 = (Button) findViewById(R.id.Bouton8);
        Bouton9 = (Button) findViewById(R.id.Bouton9);
        BoutonVirgule = (Button) findViewById(R.id.BoutonVirgule);
        BoutonPlus = (Button) findViewById(R.id.BoutonPlus);
        BoutonMoins = (Button) findViewById(R.id.BoutonMoins);
        BoutonDiviser = (Button) findViewById(R.id.BoutonDiviser);
        BoutonMulti = (Button) findViewById(R.id.BoutonMulti);
        BoutonClear = (Button) findViewById(R.id.BoutonClear);
        BoutonEgal = (Button) findViewById(R.id.BoutonEgal);

        Resultat = (EditText) findViewById(R.id.resultat);

        //Ecouteur d'évènement aux  boutons
        BoutonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        BoutonMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });

        BoutonDiviser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        BoutonMulti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });

        BoutonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        BoutonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        BoutonVirgule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });

        Bouton0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        Bouton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        Bouton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        Bouton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        bouton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        Bouton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        Bouton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        Bouton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        Bouton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        Bouton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });

    }

    //Fonctin quand on clique sur un chiffre
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!Resultat.getText().equals("0"))
                str = Resultat.getText() + str;
        }
        Resultat.setText(str);
    }

    //Fonction quand on clique sur +
    public void plusClick(){

        if(clicOperateur){
            calcul();
            Resultat.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(Resultat.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }

    //Fonction quand on clique sur -
    public void moinsClick(){
        if(clicOperateur){
            calcul();
            Resultat.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(Resultat.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }

    //Fonction quand on clique sur Multi
    public void mulClick(){
        if(clicOperateur){
            calcul();
            Resultat.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(Resultat.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }

    //Fonction quand on clique sur Diviser
    public void divClick(){
        if(clicOperateur){
            calcul();
            Resultat.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(Resultat.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }

    //Fonction quand on clique sur Egal
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }

    //LE clear
    public void resetClick(){
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        Resultat.setText("");
    }

    //Calcul
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(Resultat.getText().toString()).doubleValue();
            Resultat.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(Resultat.getText().toString()).doubleValue();
            Resultat.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(Resultat.getText().toString()).doubleValue();
            Resultat.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(Resultat.getText().toString()).doubleValue();
                Resultat.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                Resultat.setText("0");
            }
        }
    }
}