package emcorp.studio.jermanquiz.Model;

import java.io.Serializable;

public class MendengarkanPercobaan implements Serializable {
    private String description;
    private int photo_1;
    private int photo_2;
    private String jawaban;

    public MendengarkanPercobaan(String description, int photo_1, int photo_2, String jawaban) {
        this.description = description;
        this.photo_1 = photo_1;
        this.photo_2 = photo_2;
        this.jawaban = jawaban;
    }

    public String getDescription() {
        return description;
    }
    public int getPhoto_1() {
        return photo_1;
    }
    public int getPhoto_2() {
        return photo_2;
    }
    public String getJawaban() {
        return jawaban;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setphoto_1(int photo_1) {
        this.photo_1 = photo_1;
    }
    public void setphoto_2(int photo_2) {
        this.photo_2 = photo_2;
    }
    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}


