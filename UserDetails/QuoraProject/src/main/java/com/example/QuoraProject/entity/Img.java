package com.example.QuoraProject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="images")
public class Img {
    @Id
    @GeneratedValue(generator = "seq_gen_alias")
    @GenericGenerator(name="seq_gen_alias",strategy = "uuid2")
    @Column(name = "imgId")
    private String imgId;

    public String imageName;

    private byte[] imgByte;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public void setImgByte(byte[] imgByte) {
        this.imgByte = imgByte;
    }

}
