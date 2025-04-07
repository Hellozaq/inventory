package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Product;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {
    private Integer index = 0;

    public byte[] generateProductPdf(List<Product> products) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Liste de Produits"));

            // Criar tabela
            float[] columnWidths = {50f, 150f, 150f, 150f}; // Ajuste conforme necessário
            Table table = new Table(columnWidths);
            table.addCell("");
            table.addCell("Nom");
            table.addCell("Numero de série");
            table.addCell("Attribué à");

            for (Product product : products) {
                this.index++;
                table.addCell(this.index.toString());
                table.addCell(product.getName());
                table.addCell(product.getSerialNumber().toString());
                table.addCell(product.getProfessional().getName().toString());
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}
