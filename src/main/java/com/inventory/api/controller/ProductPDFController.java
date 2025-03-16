package com.inventory.api.controller;

import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.ProductRepository;
import com.inventory.api.domain.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/test")
public class ProductPDFController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PdfService pdfService;

    @PreAuthorize("hasAuthority('ROLE_SEARCH_PRODUCT') and hasAuthority('SCOPE_read')")
    @GetMapping()
    public ResponseEntity<byte[]> exportProductsToPdf() {
        List<Product> products = productRepository.findAll();
        byte[] pdf = pdfService.generateProductPdf(products);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=products.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
