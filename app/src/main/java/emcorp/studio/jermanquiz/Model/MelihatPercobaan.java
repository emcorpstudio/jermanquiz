package emcorp.studio.jermanquiz.Model;

import java.io.Serializable;

public class MelihatPercobaan implements Serializable {
    private int photo;
    private String opsi_a;
    private String opsi_b;
    private String opsi_c;
    private String opsi_d;
    private String jawaban;

    public MelihatPercobaan(int photo,String opsi_a,String opsi_b,String opsi_c,String opsi_d,String jawaban) {
        this.photo = photo;
        this.opsi_a = opsi_a;
        this.opsi_b = opsi_b;
        this.opsi_c = opsi_c;
        this.opsi_d = opsi_d;
        this.jawaban = jawaban;
    }

    public int getphoto(){
        return photo;
    }
    public String getopsi_a(){
        return opsi_a;
    }
    public String getopsi_b(){
        return opsi_b;
    }
    public String getopsi_c(){
        return opsi_c;
    }
    public String getopsi_d(){
        return opsi_d;
    }
    public String getjawaban(){
        return jawaban;
    }

    public void setphoto(int photo){
        this.photo = photo;
    }
    public void setopsi_a(String opsi_a){
        this.opsi_a = opsi_a;
    }
    public void setopsi_b(String opsi_b){
        this.opsi_b = opsi_b;
    }
    public void setopsi_c(String opsi_c){
        this.opsi_c = opsi_c;
    }
    public void setopsi_d(String opsi_d){
        this.opsi_d = opsi_d;
    }
    public void setjawaban(String jawaban){
        this.jawaban = jawaban;
    }
}


