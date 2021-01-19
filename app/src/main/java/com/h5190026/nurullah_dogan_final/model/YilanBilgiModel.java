package com.h5190026.nurullah_dogan_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YilanBilgiModel {

    @SerializedName("Adi")
    @Expose
    private String adi;
    @SerializedName("Boyu")
    @Expose
    private String boyu;
    @SerializedName("Ailesi")
    @Expose
    private String ailesi;
    @SerializedName("Ozelligi")
    @Expose
    private String ozelligi;
    @SerializedName("KucukResimUrl")
    @Expose
    private String kucukResimUrl;
    @SerializedName("BuyukResimUrl")
    @Expose
    private String buyukResimUrl;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getBoyu() {
        return boyu;
    }

    public void setBoyu(String boyu) {
        this.boyu = boyu;
    }

    public String getAilesi() {
        return ailesi;
    }

    public void setAilesi(String ailesi) {
        this.ailesi = ailesi;
    }

    public String getOzelligi() {
        return ozelligi;
    }

    public void setOzelligi(String ozelligi) {
        this.ozelligi = ozelligi;
    }

    public String getKucukResimUrl() {
        return kucukResimUrl;
    }

    public void setKucukResimUrl(String kucukResimUrl) {
        this.kucukResimUrl = kucukResimUrl;
    }

    public String getBuyukResimUrl() {
        return buyukResimUrl;
    }

    public void setBuyukResimUrl(String buyukResimUrl) {
        this.buyukResimUrl = buyukResimUrl;
    }

}
