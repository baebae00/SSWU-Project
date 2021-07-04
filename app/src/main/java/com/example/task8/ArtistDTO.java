package com.example.task8;

//아이템이 출력될 데이터를 위한 클래스

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class ArtistDTO implements Parcelable {
    private Drawable image;
    private String name;
    private String debut;
    private String agency;
    private String award;

    public ArtistDTO() {
        this.image = image;
        this.name = name;
        this.debut = debut;
        this.agency = agency;
        this.award = award;
    }

    protected ArtistDTO(Parcel in) {
        name = in.readString();
        debut = in.readString();
        agency = in.readString();
        award = in.readString();
    }

    public static final Creator<ArtistDTO> CREATOR = new Creator<ArtistDTO>() {
        @Override
        public ArtistDTO createFromParcel(Parcel in) {
            return new ArtistDTO(in);
        }

        @Override
        public ArtistDTO[] newArray(int size) {
            return new ArtistDTO[size];
        }
    };

    public void setImage(Drawable image) { this.image = image;}

    public void setName(String name) {
        this.name = name;
    }

    public void setDebut(String debut) { this.debut = debut; }

    public void setAgency(String agency) { this.agency = agency; }

    public void setAward(String award) { this.award = award; }

    public Drawable getImage() { return this.image; }

    public String getName() {
        return this.name;
    }

    public String getDebut() {
        return this.debut;
    }

    public String getAgency() {
        return this.agency;
    }

    public String getAward() {
        return this.award;
    }

    //Parcel하려는 오브젝트 종류 정의
    @Override
    public int describeContents() {
        return 0;
    }

    //실제 오브젝트 serialization/flattening 하는 메소드
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(debut);
        parcel.writeString(agency);
        parcel.writeString(award);
    }
}
