package ua.com.webacademy.beginnerslection15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RequiredEditText requiredEditText;
    private MyButton myButton;
    private MyButton myButton2;
    private MyButton myButton3;
    StudentView studentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requiredEditText = (RequiredEditText) findViewById(R.id.requiredEditText);
        myButton = (MyButton) findViewById(R.id.view3);
        myButton2 = (MyButton) findViewById(R.id.view4);
        myButton3 = (MyButton) findViewById(R.id.view5);
        studentView = (StudentView) findViewById(R.id.view6);

        myButton.setOnClickListener(new MyButton.ClickInterface() {
            @Override
            public void onClick() {
                Student student = new Student("Ivanov", "Ivan", 22);
                studentView.setStudent(student);
            }
        });

        myButton2.setOnClickListener(new MyButton.ClickInterface() {
            @Override
            public void onClick() {
                if (studentView.validate()) {
                    Student student = studentView.getStudent();
                    Toast.makeText(MainActivity.this, student.FirstName, Toast.LENGTH_SHORT).show();
                }
            }
        });

        myButton3.setOnClickListener(new MyButton.ClickInterface() {
            @Override
            public void onClick() {
                Student student = new Student("Ivanov", "Ivan", 22);

                StudentDialog dialog = StudentDialog.newInstance(student);
                dialog.setOnOkClickListener(new StudentDialog.StudentDialogInterface() {
                    @Override
                    public void onOkClick(Student student) {
                        Toast.makeText(MainActivity.this, student.FirstName, Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show(getFragmentManager(), "dialog");
            }
        });
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                requiredEditText.validate();

                if(requiredEditText.validate()){
                    Toast.makeText(MainActivity.this, requiredEditText.getText(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button2:
                validate();
                break;
        }
    }

    public boolean validate() {
        ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);
        ArrayList<RequiredEditText> requiredViews = getViewsForvalidate(rootView);
        boolean result = true;

        for (int i = 0; i < requiredViews.size(); i++) {
            RequiredEditText view = requiredViews.get(i);

            view.validate();
        }

        return result;
    }

    private ArrayList<RequiredEditText> getViewsForvalidate(ViewGroup root) {
        ArrayList<RequiredEditText> views = new ArrayList<>();
        final int childCount = root.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);

            if (child instanceof ViewGroup) {
                views.addAll(getViewsForvalidate((ViewGroup) child));
            } else if (child instanceof RequiredEditText) {
                RequiredEditText view = (RequiredEditText) child;

                if (view.getRequired() && view.getVisibility() == View.VISIBLE) {
                    views.add(view);
                }
            }
        }

        return views;
    }
}
