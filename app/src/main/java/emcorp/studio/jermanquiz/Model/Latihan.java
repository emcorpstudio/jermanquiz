package emcorp.studio.jermanquiz.Model;

import java.io.Serializable;

public class Latihan implements Serializable {
    private int photo;
    private String soal;
    private String opsi;
    private String jawaban;

    public Latihan(int photo, String soal, String opsi, String jawaban) {
        this.photo = photo;
        this.soal = soal;
        this.opsi = opsi;
        this.jawaban = jawaban;
    }

    public int getphoto(){
        return photo;
    }
    public String getopsi(){
        return opsi;
    }
    public String getsoal(){
        return soal;
    }
    public String getjawaban(){
        return jawaban;
    }

    public void setphoto(int photo){
        this.photo = photo;
    }
    public void setsoal(String soal){
        this.soal= soal;
    }
    public void setopsi(String opsi){
        this.opsi = opsi;
    }
    public void setjawaban(String jawaban){
        this.jawaban = jawaban;
    }
}


