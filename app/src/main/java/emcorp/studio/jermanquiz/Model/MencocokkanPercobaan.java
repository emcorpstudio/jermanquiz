package emcorp.studio.jermanquiz.Model;

import java.io.Serializable;

public class MencocokkanPercobaan implements Serializable {
    private int photo;
    private String opsi;
    private String jawaban;

    public MencocokkanPercobaan(int photo, String opsi, String jawaban) {
        this.photo = photo;
        this.opsi = opsi;
        this.jawaban = jawaban;
    }

    public int getphoto(){
        return photo;
    }
    public String getopsi(){
        return opsi;
    }
    public String getjawaban(){
        return jawaban;
    }

    public void setphoto(int photo){
        this.photo = photo;
    }
    public void setopsi(String opsi){
        this.opsi = opsi;
    }
    public void setjawaban(String jawaban){
        this.jawaban = jawaban;
    }
}


