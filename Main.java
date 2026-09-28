import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Створення об'єктів класу Product
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном…", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        Catalog catalog = new Catalog();
        catalog.addProduct(product1);
        catalog.addProduct(product2);
        catalog.addProduct(product3);

        Cart cart = new Cart();
        OrderHistory history = new OrderHistory();

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Пошук товарів за категорією");
            System.out.println("3 - Додати товар до кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Видалити товар з кошика");
            System.out.println("6 - Зробити замовлення");
            System.out.println("7 - Історія замовлень");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Список категорій:");
                    System.out.println(electronics);
                    System.out.println(smartphones);
                    System.out.println(accessories);
                    System.out.println("Введіть ID категорії, за якою потрібно виконати пошук:");
                    int searchId = scanner.nextInt();
                    if (searchId == 1){
                        catalog.searchByCategory(1);
                    }
                    else if (searchId == 2){
                        catalog.searchByCategory(2);
                    }
                    else if (searchId == 3){
                        catalog.searchByCategory(3);
                    }
                    else System.out.println("Категорію з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    // Проста логіка додавання, для прикладу використаємо ID для вибору
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    System.out.println("Введіть ID товару, який потрібно видалити з кошика:");
                    int delId = scanner.nextInt();
                    if (delId == 1) cart.removeProduct(product1);
                    else if (delId == 2) cart.removeProduct(product2);
                    else if (delId == 3) cart.removeProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 6:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        history.addOrder(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 7:
                    if (history.getOrders().isEmpty()) {
                        System.out.println("Історія замовлень порожня.");
                    } else {
                        System.out.println("Історія замовлень:");
                        System.out.println(history.getOrders());
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}
