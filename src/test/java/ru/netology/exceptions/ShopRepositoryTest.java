package ru.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void removeWhenProductExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 100);
        Product product2 = new Product(2, "тетрадь", 200);
        Product product3 = new Product(4, "молоко", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenProductNotExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 100);
        Product product2 = new Product(2, "тетрадь", 200);
        Product product3 = new Product(4, "молоко", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(21);
        });

//        Product[] actual = repo.findAll();
//        Product[] expected = {product1, product2, product3};
//
//        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addWhenNewProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 100);
        Product product2 = new Product(2, "тетрадь", 200);
        Product product3 = new Product(4, "молоко", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addWhenReplaingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 100);
        Product product2 = new Product(2, "тетрадь", 200);
        Product product3 = new Product(2, "молоко", 150);

        repo.add(product1);
        repo.add(product2);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product3);
        });

    }

}