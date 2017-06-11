/**
 * Created by championswimmer on 10/12/16.
 */

public class GroceryStore {

    private static GroceryStore groceryStore;


    private GroceryStore() {

    }

    public static GroceryStore getInstance () {
        if (groceryStore == null) {
            groceryStore = new GroceryStore();
        }

        return groceryStore;
    }
}
