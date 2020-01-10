
package record;


public class AddProduct {
    
    public int code, pur, sale;
    public String category, food, date, price;
    
    
    AddProduct (int code, String category, String food, String price, String date, int pur, int sale){
        
        this.code = code;
        this.category = category;
        this.food = food;
        this.price = price;
        this.date = date;
        this.pur = pur;
        this.sale = sale;
            
    }
    
    public int getCode(){
        return code;
    }
    public String getCategory(){
        return category;
    }
    public String getFood(){
        return food;        
    }
    public String getPrice(){
        return price;
    }
    public String getDate(){
        return date;
    }
    public int getPur(){
        return pur;
    }
    public int getSale(){
        return sale;
    }
    
}
