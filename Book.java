import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private String author;
    private int price;
    public Book(String name,String author,int price){
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public String toString(){
        return "book{书名《" + name +"》 " +  "作者" + author + " " + "价格：" +price + "}";
    }
}
