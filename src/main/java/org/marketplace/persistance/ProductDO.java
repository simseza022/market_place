package org.marketplace.persistance;

public class ProductDO {
    private int id;
    private int p_type;
    private int p_size;

    private int p_color;

    private String p_description;

    private String p_image;


    public ProductDO(int id, int p_type, int p_size, int p_color, String p_description, String p_image) {
        this.id = id;
        this.p_type = p_type;
        this.p_size = p_size;
        this.p_color = p_color;
        this.p_description = p_description;
        this.p_image = p_image;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getP_type() {
        return p_type;
    }

    public void setP_type(int p_type) {
        this.p_type = p_type;
    }

    public int getP_size() {
        return p_size;
    }

    public void setP_size(int p_size) {
        this.p_size = p_size;
    }

    public int getP_color() {
        return p_color;
    }

    public void setP_color(int p_color) {
        this.p_color = p_color;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }


}
