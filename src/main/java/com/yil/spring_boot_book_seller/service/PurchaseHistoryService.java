package com.yil.spring_boot_book_seller.service;

import com.yil.spring_boot_book_seller.model.PurchaseHistory;
import com.yil.spring_boot_book_seller.repository.IPurchaseHistoryRepository;
import com.yil.spring_boot_book_seller.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{

    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory savedPurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<IPurchaseItem> findPurchasedItemOfUser(Long userId) {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
