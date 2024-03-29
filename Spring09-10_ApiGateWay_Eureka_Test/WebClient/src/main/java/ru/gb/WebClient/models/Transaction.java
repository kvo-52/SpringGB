package ru.gb.WebClient.models;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Объект с данными для транзакции.
 */
public record Transaction (Long creditNumber, Long debitNumber, BigDecimal sum) {
}