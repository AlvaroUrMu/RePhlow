package org.ivz.ad.aurbano.rephlow.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.ivz.ad.aurbano.rephlow.model.Repository;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;

public class DeleteFloraViewModel extends AndroidViewModel {
    private Repository repository;

    public DeleteFloraViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<Long> getDeleteFloraLiveData() {

        return repository.getDeleteFloraLiveData();
    }

    public void deleteFlora(long id) {
        repository.deleteFlora(id);
    }
}
