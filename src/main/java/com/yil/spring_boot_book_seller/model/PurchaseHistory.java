package com.yil.spring_boot_book_seller.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "purchase_time", nullable = false)
    private LocalDateTime purchaseTime;
}