package org.ivz.ad.aurbano.rephlow.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.ivz.ad.aurbano.rephlow.model.Repository;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;

public class EditFloraViewModel extends AndroidViewModel {
    private Repository repository;

    public EditFloraViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<Long> getEditFloraLiveData() {

        return repository.getEditFloraLiveData();
    }

    public void editFlora(long id, Flora flora) {
        repository.editFlora(id, flora);
    }
}
