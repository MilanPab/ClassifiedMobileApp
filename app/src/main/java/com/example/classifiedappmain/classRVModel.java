package com.example.classifiedappmain;

import android.os.Parcel;
import android.os.Parcelable;

public class classRVModel implements Parcelable {
    private String businessName;
    private String location;
    private String email;
    private String phone;
    private String website;
    private String photosUrl;
    private String Schedule;
    private String postID;

    public classRVModel(String businessName, String location, String email, String phone, String website, String photosUrl, String schedule, String postID) {
        this.businessName = businessName;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.photosUrl = photosUrl;
        this.Schedule = schedule;
        this.postID = postID;
    }

    protected classRVModel(Parcel in) {
        businessName = in.readString();
        location = in.readString();
        email = in.readString();
        phone = in.readString();
        website = in.readString();
        photosUrl = in.readString();
        Schedule = in.readString();
        postID = in.readString();
    }

    public static final Creator<classRVModel> CREATOR = new Creator<classRVModel>() {
        @Override
        public classRVModel createFromParcel(Parcel in) {
            return new classRVModel(in);
        }

        @Override
        public classRVModel[] newArray(int size) {
            return new classRVModel[size];
        }
    };

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(businessName);
        parcel.writeString(location);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(website);
        parcel.writeString(photosUrl);
        parcel.writeString(Schedule);
        parcel.writeString(postID);
    }
}
