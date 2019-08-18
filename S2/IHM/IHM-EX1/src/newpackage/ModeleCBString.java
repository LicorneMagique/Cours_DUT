package newpackage;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeleCBString extends AbstractListModel<String> implements ComboBoxModel<String> {
    
    private List<String> tab;
    private String selectedItem;
    
    public ModeleCBString() {
        this.tab = new ArrayList<>();
        this.selectedItem = null;
    }
    
    public ModeleCBString(String[] tabStrings) {
        this.tab = new ArrayList<>();
        for (String tabString : tabStrings) {
            this.tab.add(tabString);
        }
        this.selectedItem = tabStrings[0];
    }
    
    List<String> accesStrings() {
        return tab;
    }
    
    int accesIndice(Object element) {
        for (int i = 0; i < this.tab.size(); i++) {
            if (this.tab.get(i) == element) {
                return i;
            }
        }
        return -1;
    }
    
    void ajoutString(String string) {
        this.tab.add(string);
        super.fireIntervalAdded(this, getSize(), getSize());
        this.selectedItem = string;
    }
    
    void effaceString(String string){
        for (int i = 0; i < this.tab.size(); i++) {
            if (this.tab.get(i).equals(string)) {
                this.tab.remove(i);
                super.fireIntervalRemoved(this, getSize(), getSize());
                if (this.getSize() != 0) {
                    this.selectedItem = this.tab.get(0);
                }
                else {
                    this.selectedItem = "";
                }
            }
        }
    }
    
    void effaceTout() {
        this.tab.clear();
        super.fireIntervalRemoved(this, getSize(), getSize());
        this.selectedItem = "";
    }
    
    @Override
    public int getSize() {
        if (this.tab != null) {
            return this.tab.size();
        }
        return 0;
    }

    @Override
    public String getElementAt(int index) {
        return this.tab.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = (String)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }
}
