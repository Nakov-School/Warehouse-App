package me.tcpackfrequency.Warehouse.model;

import javax.persistence.*;

@Entity
@Table(name = "box")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOX_ID")
    private int id;
    @Column(name = "BOX_CONTENT")
    private String content;
    @Column(name = "BOX_QUANTITY")
    private String quantity;
    @Column(name = "BOX_PR")
    private boolean pr;

    public Box(){
        super();
    }

    public Box(int id, String content, String quantity, boolean pr) {
        this.id = id;
        this.content = content;
        this.quantity = quantity;
        this.pr = pr;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isPr() {
        return pr;
    }

    public void setPr(boolean pr) {
        this.pr = pr;
    }



}
