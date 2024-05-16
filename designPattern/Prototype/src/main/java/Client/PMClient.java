package Client;

import Photo.Photo;
import Prototype.Resume;

import java.util.Scanner;

public class PMClient {
    public static void main(String[] args) {
        //原型模板
        String resumeInfo = "简历信息";
        Photo resumePhoto = new Photo("简历照片");
        Resume resume = new Resume(resumeInfo, resumePhoto);
        System.out.println(resume.getInfo() + resume.getPhoto().getPhotoInfo());

        System.out.println("1. ShallowClone or DeepClone");
        Scanner scanner01 = new Scanner(System.in);
        String choice01 = scanner01.next();
        if ("ShallowClone".equals(choice01)) {
            shallowClone(resume);
        } else {
            deepClone(resume);
        }
    }

    public static void shallowClone(Resume resume) {
        //浅度拷贝
        System.out.println("浅拷贝：");
        Resume shallowResume = (Resume) resume.clone();
        System.out.print("resume == shallowResume : ");
        System.out.println(resume == shallowResume);
        System.out.print("resume.getPhoto() == shallowResume.getPhoto() : ");
        System.out.println(resume.getPhoto() == shallowResume.getPhoto());
        System.out.println(shallowResume.getInfo() + shallowResume.getPhoto().getPhotoInfo());
    }

    public static void deepClone(Resume resume) {
        //深度拷贝
        System.out.println("深拷贝：");
        Resume deepResume = (Resume) resume.deepClone();
        System.out.print("resume == deepResume : ");
        System.out.println(resume == deepResume);
        System.out.println("resume.getPhoto() == deepResume.getPhoto() : ");
        System.out.println(resume.getPhoto() == deepResume.getPhoto());
        System.out.println(deepResume.getInfo() + deepResume.getPhoto().getPhotoInfo());
    }
}
