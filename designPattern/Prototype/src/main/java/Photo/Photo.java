package Photo;

import java.io.Serializable;

public class Photo implements Serializable {

    private String photoInfo;

    public Photo(String photoInfo) {
        this.photoInfo = photoInfo;
    }

    public void setPhotoInfo(String photoInfo) {
        this.photoInfo = photoInfo;
    }

    public String getPhotoInfo() {
        return photoInfo;
    }
}
