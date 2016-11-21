package sample;

/**
 * Created by 47276138y on 21/11/16.
 */
public class Card {

    private String name;
    private String rarity;
    private String color;
    private String tipus;
    private String imgURL;

    public String getName() { return name; }
    public void setName(String name) {this.name = name;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }
    public String getTipus() {return tipus;}
    public void setTipus(String tipus) {this.tipus = tipus;}
    public String getImgURL() {return imgURL;}
    public void setImgURL(String imgURL) {this.imgURL = imgURL;}



    @Override
    public String toString(){
        return  "\n\t\t" + name + "\n\t\t" + rarity +  "\n\t\t" + tipus + "\n\t\t " + color;
    }
}
