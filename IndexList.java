import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IndexList {
    ArrayList<Index> itemNoIndexList;
    int sortedState = 0;

    public IndexList() {

        itemNoIndexList = new ArrayList<>();
    }

    public int FindIndex(int wanted) {
        if (sortedState != 1) {
            Sort();
        }
        return this.BinarySearchItemNr(wanted) + 1;

    }

    private int BinarySearchItemNr(int wanted) {
        int first = 0;
        int last = this.itemNoIndexList.size() - 1;

        while(first <= last) {
            int mid = (first + last) / 2;
            Index currentone = (Index)this.itemNoIndexList.get(mid);
            if (currentone.GetItemNo() == wanted) {
                return mid;
            }

            else if (wanted < currentone.GetItemNo()) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        return -1;
    }

    public void AddIndex(Index newone) {
        if (this.sortedState == 0) {
            this.itemNoIndexList.add(newone);
        } else {
            int last = this.itemNoIndexList.size() - 1;
            this.InsertSort(newone, last);
        }

    }

    public void DeleteIndex(int pos) {
       pos--;
       itemNoIndexList.remove(pos-1);
    }
    public void UpdateOGpos(int originalPos) {
        for (int i = 0; i < this.itemNoIndexList.size(); i++) {
            Index currentone = (Index)this.itemNoIndexList.get(i);
            if(currentone.GetPosition() > originalPos) {
                currentone.SetPosition(currentone.GetPosition() - 1);
            }
        }
    }

    public void InsertSort(Index newone, int last) {
        int curpos = last;
        Index curentone = (Index)this.itemNoIndexList.get(last);

        while(curpos != -1 && newone.GetPosition() < curentone.GetPosition()) {
            --curpos;
            if (curpos != -1) {
                curentone = (Index)this.itemNoIndexList.get(curpos);
            }
        }

        this.itemNoIndexList.add(curpos + 1, newone);
    }

    public Index GetIndex(int pos) {
        --pos;
        if((pos >= 0) && (pos < itemNoIndexList.size())) {
            return this.itemNoIndexList.get(pos);
        }
        return null;
    }

    private void SortAsc(int last, Index newone) {
        int curpos = last;
        Index currentone = (Index)this.itemNoIndexList.get(last);

        while(curpos != -1 && newone.GetItemNo() < currentone.GetItemNo()) {
            --curpos;
            if (curpos != -1) {
                currentone = (Index)this.itemNoIndexList.get(curpos);
            }
        }

        this.itemNoIndexList.add(curpos + 1, newone);
    }

    public void Sort() {
        Collections.sort(this.itemNoIndexList, Comparator.comparingInt(Index::GetItemNo
        ));
        this.sortedState = 1;
    }

}
