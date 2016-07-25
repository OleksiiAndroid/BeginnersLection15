package ua.com.webacademy.beginnerslection15;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class StudentView extends LinearLayout {
    RequiredEditText mEditTextFirstName;
    RequiredEditText mEditTextLastName;
    RequiredEditText mEditTextAge;

    private Student mStudent;

    public StudentView(Context context) {
        super(context);

        init(context);
    }

    public StudentView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        View view = inflate(context, R.layout.view_student, this);

        mEditTextFirstName = (RequiredEditText) view.findViewById(R.id.firstName);
        mEditTextLastName = (RequiredEditText) findViewById(R.id.lastName);
        mEditTextAge = (RequiredEditText) findViewById(R.id.age);
    }

    public void setStudent(Student student) {
        this.mStudent = student;

        mEditTextFirstName.setText(this.mStudent.FirstName);
        mEditTextLastName.setText(this.mStudent.LastName);
        mEditTextAge.setText(String.valueOf(this.mStudent.Age));
    }

    public Student getStudent() {
        this.mStudent.FirstName = mEditTextFirstName.getText().toString();
        this.mStudent.LastName = mEditTextLastName.getText().toString();
        this.mStudent.Age = Integer.valueOf(mEditTextAge.getText().toString());

        return this.mStudent;
    }

    public boolean validate() {
        return mEditTextFirstName.validate() && mEditTextLastName.validate() && mEditTextAge.validate();
    }
}
