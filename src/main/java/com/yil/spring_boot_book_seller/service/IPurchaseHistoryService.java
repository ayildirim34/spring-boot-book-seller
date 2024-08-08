package com.yil.spring_boot_book_seller.service;

import com.yil.spring_boot_book_seller.model.PurchaseHistory;
import com.yil.spring_boot_book_seller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savedPurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemOfUser(Long userId);
}
