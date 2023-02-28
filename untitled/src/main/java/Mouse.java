import java.util.Comparator;

public class Mouse {
    private String name ;
    private int price;

    public Mouse(String name, int price){
        this.name = name;
        this.price = price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static Comparator<Mouse> MouseNameComparator = new Comparator<Mouse>() {
        @Override
        public int compare(Mouse o1, Mouse o2) {
            String MouseName1 = o1.getName().toUpperCase();
            String MouseName2 = o2.getName().toUpperCase();

            return MouseName1.compareTo(MouseName2);
        }
    };

    public static Comparator<Mouse> MousePriceComparator = new Comparator<Mouse>() {
        @Override
        public int compare(Mouse o1, Mouse o2) {
            int price1 = o1.getPrice();
            int price2 = o2.getPrice();

            return price1 - price2;
        }
    };

    @Override
    public String toString(){
        return "Name: " + name + "; Price: " + price;
    }
}
