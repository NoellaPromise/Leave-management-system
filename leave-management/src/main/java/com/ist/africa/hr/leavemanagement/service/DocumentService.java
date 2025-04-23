package com.ist.africa.hr.leavemanagement.service;

import com.ist.africa.hr.leavemanagement.model.Document;
import com.ist.africa.hr.leavemanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document uploadDocument(MultipartFile file) {
        // Placeholder for actual logic to upload and save document
        Document document = new Document();
        document.setName(file.getOriginalFilename());
        return documentRepository.save(document);
    }
} 