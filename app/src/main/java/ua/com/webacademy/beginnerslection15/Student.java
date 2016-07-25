package ua.com.webacademy.beginnerslection15;


import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    public long id;

    public String FirstName;
    public String LastName;
    public long Age;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.FirstName);
        dest.writeString(this.LastName);
        dest.writeLong(this.Age);
    }

    protected Student(Parcel in) {
        this.id = in.readLong();
        this.FirstName = in.readString();
        this.LastName = in.readString();
        this.Age = in.readLong();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
