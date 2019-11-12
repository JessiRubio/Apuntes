package com.example.apuntes.ui.cambioAtributos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CambioAtributosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CambioAtributosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}