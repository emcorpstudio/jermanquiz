package emcorp.studio.jermanquiz.Model;

import java.io.Serializable;

public class MenuBelajar implements Serializable {
    private String description;
    private int photo;

    public MenuBelajar(String description, int photo) {
        this.description = description;
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }
    public int getPhoto() {
        return photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setPhoto(int photo) {
        this.photo = photo;
    }
}


