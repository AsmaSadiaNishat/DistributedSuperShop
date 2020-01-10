
package record;

public class SaleProduct {
    
    public int code, custID, qty, price;
    public String name;
    
    
    SaleProduct (int code, String name, int custID, int qty, int price){
        
        this.code = code;
        this.name = name;
        this.custID = custID;
        this.qty = qty;
        this.price = price;
            
    }

    public int getCode() {
        return code;
    }

    public int getCustID() {
        return custID;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    

}
