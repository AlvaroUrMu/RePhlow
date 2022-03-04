package org.ivz.ad.aurbano.rephlow.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;

import org.ivz.ad.aurbano.rephlow.R;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;
import org.ivz.ad.aurbano.rephlow.viewmodel.AddFloraViewModel;

public class AddFloraActivity extends AppCompatActivity {
    private TextInputLayout tilNombre;
    private EditText etNombre, etFamilia, etIdent, etAltitud, etHabitat, etFito, etBiotipo,
            etBiorep, etFloracion, etFruct, etExpsex, etPolin, etDisp, etNumcrom, etRepasex, etDist,
            etBiologia, etDemo, etAmen, etMedprop;
    private Button btConfirm;
    Toolbar toolbar;
    AddFloraViewModel avm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flora);

        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Añadir flor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btConfirm.setOnClickListener(v -> {
            if(etNombre.length() == 0) {
                tilNombre.setError("Debes introducir un nombre");
            } else {
                addFlora();
                Intent intent = new Intent(AddFloraActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);

        tilNombre = findViewById(R.id.tilNombre);

        etNombre = findViewById(R.id.etNombre);
        etFamilia = findViewById(R.id.etFamilia);
        etIdent = findViewById(R.id.etIdent);
        etAltitud = findViewById(R.id.etAltitud);
        etHabitat = findViewById(R.id.etHabitat);
        etFito = findViewById(R.id.etFito);
        etBiotipo = findViewById(R.id.etBiotipo);
        etBiorep = findViewById(R.id.etBiorep);
        etFloracion = findViewById(R.id.etFloracion);
        etFruct = findViewById(R.id.etFruct);
        etExpsex = findViewById(R.id.etExpsex);
        etPolin = findViewById(R.id.etPolin);
        etDisp = findViewById(R.id.etDisp);
        etNumcrom = findViewById(R.id.etNumcrom);
        etRepasex = findViewById(R.id.etRepasex);
        etDist = findViewById(R.id.etDist);
        etBiologia = findViewById(R.id.etBiologia);
        etDemo = findViewById(R.id.etDemo);
        etAmen = findViewById(R.id.etAmen);
        etMedprop = findViewById(R.id.etMedprop);
        btConfirm = findViewById(R.id.btConfirm);

        avm = new ViewModelProvider(this).get(AddFloraViewModel.class);
        avm.getAddFloraLiveData().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                if(aLong > 0) {
                    finish();
                } else {
                    Toast.makeText(AddFloraActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        /*MainActivityViewModel mavm = new ViewModelProvider(this).get(MainActivityViewModel.class);
        MutableLiveData<ArrayList<Flora>> floraList = mavm.getFloraLiveData();
        mavm.getFlora();*/
    }

    public void addFlora() {
        Flora flora = new Flora();
        flora.setNombre(etNombre.getText().toString());
        flora.setFamilia(etFamilia.getText().toString());
        flora.setIdentificacion(etIdent.getText().toString());
        flora.setAltitud(etAltitud.getText().toString());
        flora.setHabitat(etHabitat.getText().toString());
        flora.setFitosociologia(etFito.getText().toString());
        flora.setBiotipo(etBiotipo.getText().toString());
        flora.setBiologia_reproductiva(etBiorep.getText().toString());
        flora.setFloracion(etFloracion.getText().toString());
        flora.setFructificacion(etFruct.getText().toString());
        flora.setExpresion_sexual(etExpsex.getText().toString());
        flora.setPolinizacion(etPolin.getText().toString());
        flora.setDispersion(etDisp.getText().toString());
        flora.setNumero_cromosomatico(etNumcrom.getText().toString());
        flora.setReproduccion_asexual(etRepasex.getText().toString());
        flora.setDistribucion(etDist.getText().toString());
        flora.setBiologia(etBiologia.getText().toString());
        flora.setDemografia(etDemo.getText().toString());
        flora.setAmenazas(etAmen.getText().toString());
        flora.setMedidas_propuestas(etMedprop.getText().toString());
        avm.createFlora(flora);
    }
}
