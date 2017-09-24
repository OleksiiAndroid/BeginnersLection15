package ua.com.webacademy.beginnerslection15;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class StudentFragment extends Fragment {

    public Student student;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }
}
