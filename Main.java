import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        IndexList nrIndexList = new IndexList();
        Scanner scanner = new Scanner(System.in);
        inventory.BuiltIndex(nrIndexList);

        int choice;
        do {
            DisplayOptions();
            choice = Integer.parseInt(scanner.nextLine());
            ProcessOption(inventory, nrIndexList, choice, scanner);
        } while(choice != 6);

        scanner.close();
    }

    static void DisplayOptions() {
        System.out.println("Choose one of the following options: ");
        System.out.println("1. Add a new inventory item");
        System.out.println("2. Delete an inventory item");
        System.out.println("3. Update inventory item quantity");
        System.out.println("4. Calculate inventory value");
        System.out.println("5. Display all inventory items");
        System.out.println("6. Quit");
        System.out.print("Choice: ");
    }

    static void ProcessOption(InventoryManager inventory, IndexList nrIndexList, int choice, Scanner scanner) {
        System.out.println();
        switch (choice) {
            case 1:
                AddInventoryItem(inventory, nrIndexList, scanner);
                System.out.println();
                break;
            case 2:
                DeleteInventoryItem(inventory, nrIndexList, scanner);
                System.out.println();
                break;
            case 3:
                UpdateQuantity(inventory, nrIndexList, scanner);
                System.out.println();
                break;
            case 4:
                CalculateInventory(inventory);
                System.out.println();
                break;
            case 5:
                DisplayInventory(inventory);
                System.out.println();
                break;
            default:
                System.out.println("Goodbye");
        }

    }

    static void AddInventoryItem(InventoryManager inventory, IndexList nrIndexList, Scanner scanner) {
        System.out.print("Item no: ");
        int itemno = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Unit price: ");
        double unitprice = Double.parseDouble(scanner.nextLine());
        InventoryItem newItem = new InventoryItem(itemno, name, qty, unitprice);
        inventory.Add1(newItem, nrIndexList);
        System.out.println("Inventory added");
    }

    static void DeleteInventoryItem(InventoryManager inventory, IndexList nrIndexList, Scanner scanner) {
        System.out.print("Enter item no: ");
        int itemno = Integer.parseInt(scanner.nextLine());
        int pos = nrIndexList.FindIndex(itemno);
        if (pos == 0) {
            System.out.println("Item not found");
        } else {
            Index newindex=nrIndexList.GetIndex(pos);
            int originalpos=newindex.GetPosition();
            inventory.Delete(originalpos+1,pos,nrIndexList);
            System.out.println("Inventory deleted");
        }

    }


    static void UpdateQuantity(InventoryManager inventory, IndexList nrIndexList, Scanner scanner) {
        System.out.print("Enter item no to update quantity: ");
        int itemno = Integer.parseInt(scanner.nextLine());
        int pos = nrIndexList.FindIndex(itemno);
        if (pos == 0) {
            System.out.println("Item not found.");
        } else {
            Index newIndex = nrIndexList.GetIndex(pos);
            int actpos = newIndex.GetPosition();
            InventoryItem newone= inventory.getItem(actpos + 1);
            System.out.print("Enter new quantity: ");
            int newQty = Integer.parseInt(scanner.nextLine());
            newone.SetQty(newQty);
            System.out.println("Quantity updated successfully.");


        }

    }

    static void CalculateInventory(InventoryManager inventory) {

    }
    static void DisplayInventory(InventoryManager inventory) {
          inventory.Display();

    }
}
