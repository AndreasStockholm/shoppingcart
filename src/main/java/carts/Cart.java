package carts;

import java.util.ArrayList;

/**
 * Created by andgra on 2014-10-10.
 */
public class Cart {
    private String id;
    private ArrayList<CartRowItem> rows;
    private double totalPriceIncVatAmount;
    private double totalVatAmount;
    //private ArrayList<Product> productsList;

    public Cart(String id, ArrayList<CartRowItem> rows, double totalPriceIncVatAmount, double totalVatAmount){
        this.id = id;
        this.rows = rows;
        this.totalPriceIncVatAmount = totalPriceIncVatAmount;
        this.totalVatAmount = totalVatAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<CartRowItem> getRows() {
        return rows;
    }

    public void setRows(ArrayList<CartRowItem> rows) {
        this.rows = rows;
    }

    public double getTotalPriceIncVatAmount() {
        return totalPriceIncVatAmount;
    }

    public void setTotalPriceIncVatAmount(double totalPriceIncVatAmount) {
        this.totalPriceIncVatAmount = totalPriceIncVatAmount;
    }

    public double getTotalVatAmount() {
        return totalVatAmount;
    }

    public void setTotalVatAmount(double totalVatAmount) {
        this.totalVatAmount = totalVatAmount;
    }

    public void addProductInRow(CartRowItem cartRowItem) {
        this.rows.add(cartRowItem);
    }

  /*  public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }
    public Product getProduct(String productId){
        Product product = null;
        for (Product item: productsList){
            if (item.getId().equals(productId)){
                product = item;
            }

        }
        return product;
    }*/
}
