package kr.ai.a0524_exparce;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    private String message;

    public SimpleData(String msg)
    {
        message = msg;
    }

    protected SimpleData(Parcel in) {
        message = in.readString();
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
