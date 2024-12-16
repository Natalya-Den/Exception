package ru.netology.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Id = " + id + " не найден");
    }
}
