package ua.com.webacademy.beginnerslection15;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

public class StudentViewModel extends AndroidViewModel {

    public Student student;

    public StudentViewModel(Application application) {
        super(application);
    }
}
