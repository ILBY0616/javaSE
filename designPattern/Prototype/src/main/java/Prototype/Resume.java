package Prototype;

import Photo.Photo;

import java.io.*;

public class Resume implements Cloneable, Serializable {

    private String info;
    private Photo photo;

    public Resume(String info, Photo photo) {
        this.info = info;
        this.photo = photo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }


    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (Exception e) {
            System.out.println("Not Support Clone");
        }
        return object;
    }

    public Object deepClone() {
        Object object = null;
        try {
            ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
            ObjectOutputStream oOS = new ObjectOutputStream(bAOS);
            oOS.writeObject(this);

            ByteArrayInputStream bAIS = new ByteArrayInputStream(bAOS.toByteArray());
            ObjectInputStream oIS = new ObjectInputStream(bAIS);
            object = oIS.readObject();
        } catch (Exception e) {
            System.out.println("Not Support DeepClone");
        }
        return object;
    }
}
