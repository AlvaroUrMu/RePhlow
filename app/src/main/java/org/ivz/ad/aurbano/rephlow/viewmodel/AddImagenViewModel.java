package org.ivz.ad.aurbano.rephlow.viewmodel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.ivz.ad.aurbano.rephlow.model.Repository;
import org.ivz.ad.aurbano.rephlow.model.entity.Imagen;

public class AddImagenViewModel extends AndroidViewModel {
    Repository repository;

    public AddImagenViewModel(@NonNull Application application) {
        super(application);

        repository = new Repository(application);
    }

    public MutableLiveData<Long> getAddImagenLiveData() {
        return repository.getAddImagenLiveData();
    }

    public void saveImagen(Intent intent, Imagen imagen) {
        repository.saveImagen(intent, imagen);
    }
}
