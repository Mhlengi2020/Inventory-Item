public class InventoryItem {
    int itemNo;
    String name;
    int qty;
    double unitPrice;

    public InventoryItem(int num, String name, int qty, double price) {
        this.itemNo = num;
        this.name = name;
        this.qty = qty;
        this.unitPrice = price;
    }

    public void DisplayItem() {
        System.out.printf("%d,%s,%d,%.2f\n", this.itemNo, this.name, this.qty, this.unitPrice);
    }

    public int GetItemNo() {
        return this.itemNo;
    }

    public String GetName() {
        return this.name;
    }

    public int GetQty() {
        return this.qty;
    }

    public double GetUnitPrice() {
        return this.unitPrice;
    }

    public void SetQty(int quantity) {
        this.qty = quantity;}
}
