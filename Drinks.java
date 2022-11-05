public enum Drinks {

    COFFEE(40),
    TEA(30),
    LEMONADE(25),
    MOJITO(25),
    SODA(15),
    COCA_COLA(20);

    private final int price;

    public int getPrice() {
        return price;
    }

    private Drinks(int price) {
        this.price = price;
    }



}
