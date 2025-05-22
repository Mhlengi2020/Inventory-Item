import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private ArrayList<InventoryItem> mylist ;

    public InventoryManager() {
        mylist = new ArrayList<>();
        ReadData();
    }

    public void ReadData() {
        char delim = ',';
        String filename = "InventoryData.txt";

        try {
            try (Scanner sr = new Scanner(new File(filename))) {
                while(sr.hasNextLine()) {
                    String inputline = sr.nextLine();
                    String[] field = inputline.split(String.valueOf(','));
                    int itemNo = Integer.parseInt(field[0]);
                    String name = field[1];
                    int qty = Integer.parseInt(field[2]);
                    double unitPrice = Double.parseDouble(field[3]);
                    InventoryItem newone = new InventoryItem(itemNo, name, qty, unitPrice);
                    this.mylist.add(newone);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void Add1(InventoryItem item, IndexList list) {
        mylist.add(item);
        int no = item.GetItemNo();
        Index newone = new Index(no,mylist.size() - 1);
        list.AddIndex(newone);
    }

    public void Delete(int originalPos,int indexPos,IndexList list) {
       originalPos--;
       mylist.remove(originalPos);
       list.DeleteIndex(indexPos);
       list.UpdateOGpos(originalPos);
    }

    public InventoryItem getItem(int pos) {
        if(pos >= 0 && pos <= mylist.size()-1) {
            return mylist.get(pos);
        }
       return null;
    }

    public void Display() {
        for(int i = 0; i < this.mylist.size(); ++i) {
            InventoryItem newone = (InventoryItem)this.mylist.get(i);
            newone.DisplayItem();
        }

    }

    public void BuiltIndex(IndexList list) {
        for(int i = 0; i < this.mylist.size(); ++i) {
            InventoryItem newone = (InventoryItem)this.mylist.get(i);
            int no = newone.GetItemNo();
            Index neww = new Index(no,i);
            list.AddIndex(neww);
        }

        list.Sort();
    }

    public double CalcInventory(InventoryItem item) {
        int qty = item.GetQty();
        double amount = item.GetUnitPrice();
        return (double)qty * amount;
    }


}
