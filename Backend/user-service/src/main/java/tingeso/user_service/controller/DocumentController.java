package tingeso.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tingeso.user_service.Entities.DocumentEntity;
import tingeso.user_service.services.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/user/document")
@CrossOrigin("*")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<DocumentEntity> uploadDocument(@RequestParam("file") MultipartFile file,
                                                         @RequestParam("userId") Long userId,
                                                         @RequestParam("name") String name){
        try {
            documentService.saveDocument(file, userId, name);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DocumentEntity>> getDocumentsByUserId(@PathVariable Long userId) {
        List<DocumentEntity> documents = documentService.getDocumentsByUserId(userId);
        return ResponseEntity.ok(documents);
    }
}
