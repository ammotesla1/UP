package com.example.UP.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProduct;
    private Integer amount;
    private String weight;
    private String price;
    private String date_Of_Production;
    @ManyToOne(cascade = CascadeType.ALL)
    private Color color;
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductType productType;
    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;
    @ManyToOne(cascade = CascadeType.ALL)
    private Material material;
    @ManyToOne(cascade = CascadeType.ALL)
    private Warehouse warehouse;

    @ManyToMany
    @JoinTable(name="plan_product",
            joinColumns = @JoinColumn(name = "ID_Product"),
            inverseJoinColumns = @JoinColumn(name = "ID_Plan"))
    private List<Plan> plan;

    @ManyToMany
    @JoinTable(name="order_product",
            joinColumns = @JoinColumn(name = "ID_Product"),
            inverseJoinColumns = @JoinColumn(name = "ID_Order"))
    private List<Order> order;

    public Product(String nameProduct, Integer amount, String weight, String price, String date_Of_Production, Color color, ProductType productType, Supplier supplier, Material material, Warehouse warehouse){
        this.nameProduct = nameProduct;
        this.amount = amount;
        this.weight = weight;
        this.price = price;
        this.date_Of_Production = date_Of_Production;
        this.color = color;
        this.productType = productType;
        this.supplier = supplier;
        this.material = material;
        this.warehouse = warehouse;
    }

    public Product() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate_Of_Production() {
        return date_Of_Production;
    }

    public void setDate_Of_Production(String date_Of_Production) {
        this.date_Of_Production = date_Of_Production;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<Plan> getPlan() {
        return plan;
    }

    public void setPlan(List<Plan> plan) {
        this.plan = plan;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
