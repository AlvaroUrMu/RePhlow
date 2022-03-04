package org.ivz.ad.aurbano.rephlow.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import org.ivz.ad.aurbano.rephlow.R;
import org.ivz.ad.aurbano.rephlow.model.entity.Imagen;
import org.ivz.ad.aurbano.rephlow.viewmodel.AddImagenViewModel;

public class AddImagenActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;
    Context context;
    private Intent resultadoImagen = null;
    private ImageView ivImageEdit;
    private EditText etNombre, etDescripcion;
    private Button btConfirmImage, btCancelImage;
    private AddImagenViewModel aivm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_imagen);

        init();
    }

    private void init() {
        launcher = getLauncher();

        //idflora = getIntent().getExtras().getLong("idflora");

        Toolbar toolbarImage = findViewById(R.id.toolbarImage);
        setSupportActionBar(toolbarImage);
        getSupportActionBar().setTitle("Editar imagen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ivImageEdit = findViewById(R.id.ivImageEdit);
        ivImageEdit.setImageResource(R.drawable.ic_baseline_add_photo_alternate_24);
        etNombre = findViewById(R.id.etNombreImagen);
        etDescripcion = findViewById(R.id.etDesc);

        ivImageEdit.setOnClickListener(view -> {
            selectImage();
        });

        btConfirmImage = findViewById(R.id.btConfirmImage);
        btConfirmImage.setOnClickListener(view -> {
            uploadDataImage();
            //Intent intent = new Intent(AddImagenActivity.this, MainActivity.class);
            //startActivity(intent);
        });

        aivm = new ViewModelProvider(this).get(AddImagenViewModel.class);
    }

    private void uploadDataImage() {
        long id = getIntent().getExtras().getLong("idflora");
        String nombre = etNombre.getText().toString();
        String descripcion = etDescripcion.getText().toString();

        if(resultadoImagen != null) {
            Imagen imagen = new Imagen();
            imagen.idflora = id;
            imagen.nombre = nombre;
            imagen.descripcion = descripcion;
            aivm.saveImagen(resultadoImagen, imagen);
        } else {
            Toast.makeText(context, "Debes elegir una imagen", Toast.LENGTH_SHORT);
        }

        Log.v("xyzyx", String.valueOf(id));
    }

    ActivityResultLauncher<Intent> getLauncher() {
        return registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    // Respuesta al resultado de haber seleccionado una imagen
                    if(result.getResultCode() == Activity.RESULT_OK) {
                        //copyData(result.getData());
                        resultadoImagen = result.getData();
                        ivImageEdit.setImageURI(resultadoImagen.getData());
                    }
                }
        );
    }

    Intent getContentIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        return intent;
    }

    void selectImage() {
        Intent intent = getContentIntent();
        launcher.launch(intent);
        //getLauncher().launch(getContentIntent());
    }
}
