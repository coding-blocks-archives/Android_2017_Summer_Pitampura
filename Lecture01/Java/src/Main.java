import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {
//        Food food = new Food();
//        Fruit fruit = new Fruit();
//
//        Fruit f1 = (Fruit) new Food();
//
//        Food f2  = new Fruit();
//        ((Fruit)f2).sweetness = 0.7f;
//
//        Basket<Food> foodBasket = new Basket<Food>();
//        foodBasket.basketObjects = new Food[] {f2};
//
//        Basket<Fruit> fruitBasket = new Basket<Fruit>();
//        fruitBasket.basketObjects = new Fruit[10];

        ArrayList<Integer> intArray = new ArrayList<>();
        intArray.add(90);
        intArray.add(2);

        intArray.get(0);

        try {
            System.out.println("Trying to print pos 4");
            int a = intArray.get(4);
            System.out.println("We got " + a);


        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("This doesn't exit");
        } finally {
            System.out.println("Tried and/or caught");
        }

        GroceryStore gs = GroceryStore.getInstance();

        Currency usd = Currency.newInstance("USD");
        Currency otherUsd = Currency.newInstance("USD");


        System.out.println("Hello World!");
    }

    static class Food {
        int calories;
        String color;

    }

    static class Fruit extends Food {
        float sweetness = 0.5f;
    }

    static class Basket <T> {
        T[] basketObjects;
    }





}


