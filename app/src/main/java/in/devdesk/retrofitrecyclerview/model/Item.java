package in.devdesk.retrofitrecyclerview.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by richardandrews on 06/07/17.
 */

public class Item implements Serializable{

    /**
     *   {
     * "category": "Shrubs",
     * "price": 15.99,
     * "instructions": "Large double. Good grower, heavy bloomer. Early to mid-season, acid loving plants. Plant in moist well drained soil with pH of 4.0-5.5.",
     * "photo": "california_snow.jpg",
     * "name": "Azalea",
     * "productId": 1
     * },
     */

    @Expose
    private String category;

    @Expose
    private double price;

    @Expose
    private String instructions;

    @Expose
    private String photo;

    @Expose
    private String name;

    @Expose
    private int productId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
