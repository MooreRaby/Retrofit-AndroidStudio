package poly.quylpph27484.assignmentapi;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Albums {
    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Albums{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
