package com.yil.spring_boot_book_seller.controller;

import com.yil.spring_boot_book_seller.model.PurchaseHistory;
import com.yil.spring_boot_book_seller.security.UserPrincipal;
import com.yil.spring_boot_book_seller.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/purchase-history")
public class PurchaseHistoryServiceController
{
    @Autowired
   private IPurchaseHistoryService purchaseHistoryService;

    @PostMapping
    public ResponseEntity<?> savePurchaseHistory (@RequestBody PurchaseHistory purchaseHistory) {
        return new ResponseEntity<>(purchaseHistoryService.savedPurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }


    @GetMapping //api/purchase-history
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal)
    {
        return ResponseEntity.ok(purchaseHistoryService.findPurchasedItemOfUser(userPrincipal.getId()));
    }
}

