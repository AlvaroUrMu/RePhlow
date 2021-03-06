package org.ivz.ad.aurbano.rephlow.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.ivz.ad.aurbano.rephlow.model.Repository;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;

public class AddFloraViewModel extends AndroidViewModel {
    private Repository repository;

    public AddFloraViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<Long> getAddFloraLiveData() {
        return repository.getAddFloraLiveData();
    }

    public void createFlora(Flora flora) {
        repository.createFlora(flora);
    }
}
