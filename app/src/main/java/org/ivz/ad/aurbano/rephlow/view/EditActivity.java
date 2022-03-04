package org.ivz.ad.aurbano.rephlow.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;

import org.ivz.ad.aurbano.rephlow.R;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;
import org.ivz.ad.aurbano.rephlow.viewmodel.DeleteFloraViewModel;
import org.ivz.ad.aurbano.rephlow.viewmodel.EditFloraViewModel;

public class EditActivity extends AppCompatActivity {
    private long idflora;
    private TextInputLayout tilNombre;
    private EditText etNombre, etFamilia, etIdent, etAltitud, etHabitat, etFito, etBiotipo,
            etBiorep, etFloracion, etFruct, etExpsex, etPolin, etDisp, etNumcrom, etRepasex, etDist,
            etBiologia, etDemo, etAmen, etMedprop;
    private Button btConfirm;
    Toolbar toolbar;
    Flora flora = new Flora();
    private DeleteFloraViewModel dvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flora);

        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Editar flor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void init() {
        flora = getIntent().getExtras().getParcelable("flora");

        idflora = flora.id;

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

        etNombre.setText(flora.nombre);
        etFamilia.setText(flora.familia);
        etIdent.setText(flora.identificacion);
        etAltitud.setText(flora.altitud);
        etHabitat.setText(flora.habitat);
        etFito.setText(flora.fitosociologia);
        etBiotipo.setText(flora.biotipo);
        etBiorep.setText(flora.biologia_reproductiva);
        etFloracion.setText(flora.floracion);
        etFruct.setText(flora.fructificacion);
        etExpsex.setText(flora.expresion_sexual);
        etPolin.setText(flora.polinizacion);
        etDisp.setText(flora.dispersion);
        etNumcrom.setText(flora.numero_cromosomatico);
        etRepasex.setText(flora.reproduccion_asexual);
        etDist.setText(flora.distribucion);
        etBiologia.setText(flora.biologia);
        etDemo.setText(flora.demografia);
        etAmen.setText(flora.amenazas);
        etMedprop.setText(flora.medidas_propuestas);

        EditFloraViewModel evm = new ViewModelProvider(this).get(EditFloraViewModel.class);
        evm.getEditFloraLiveData().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                Log.v("xyzyx", "respuesta " + aLong);
                if(aLong > 0) {
                    finish();
                }
            }
        });

        btConfirm.setOnClickListener(v -> {
            if(etNombre.length() == 0) {
                tilNombre.setError("Debes introducir un nombre");
            } else {
                getFlora();
                Log.v("xyzyx", String.valueOf(getFlora()));
                evm.editFlora(flora.getId(), getFlora());
            }
        });

        dvm = new ViewModelProvider(this).get(DeleteFloraViewModel.class);
        dvm.getDeleteFloraLiveData().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                Log.v("xyzyx", "respuesta " + aLong);
                if(aLong > 0) {
                    finish();
                }
            }
        });
    }

    private Flora getFlora(){
        Flora flora = new Flora();
        flora.setNombre(etNombre.getText().toString());
        flora.setFamilia(etFamilia.getText().toString());
        flora.setIdentificacion(etIdent.getText().toString());
        flora.setAltitud(etAltitud.getText().toString());
        flora.setHabitat(etHabitat.getText().toString());
        flora.setFitosociologia(etFito.getText().toString());
        flora.setBiologia(etBiologia.getText().toString());
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
        return flora;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case  R.id.app_bar_delete:
                delete();
        }
        return super.onOptionsItemSelected(item);
    }

    public void delete() {
        long id = idflora;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(("Eliminar registro"))
                .setMessage("Está a punto de eliminar el registro de esta flor, ¿desea continuar?")
                .setPositiveButton(R.string.btConfirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dvm.deleteFlora(id);
                        Toast.makeText(EditActivity.this, "El registro se ha eliminado éxitosamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.btCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
        builder.create().show();
    }
}
