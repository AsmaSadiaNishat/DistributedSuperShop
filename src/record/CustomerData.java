/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package record;

/**
 *
 * @author zahid
 */
public class CustomerData {
    
        public String cname, phone, address, pname;
        int qty, price, cust_id, pro_id;
 
    CustomerData (String pname, int qty, int price, String cname, String phone, String address, int cust_id, int pro_id){
        
        
        this.pname = pname;
        this.qty = qty;
        this.price = price;
        this.cname = cname;
        this.phone = phone;
        this.address = address;
        this.cust_id = cust_id;
        this.pro_id = pro_id;
            
    }

    public int getCust_id() {
        return cust_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public String getCname() {
        return cname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPname() {
        return pname;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    

    
}
