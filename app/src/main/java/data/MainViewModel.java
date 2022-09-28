package data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public String editString;
    public MutableLiveData<String> editString2 = new MutableLiveData<>();
    public MutableLiveData<Boolean> selectAllTypes = new MutableLiveData<>();

}
