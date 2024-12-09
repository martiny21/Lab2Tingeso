package tingeso.user_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tingeso.user_service.Entities.DocumentEntity;
import tingeso.user_service.repositories.DocumentRepository;
import tingeso.user_service.repositories.UserRepository;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    UserRepository userRepository;

    public void saveDocument(MultipartFile file, Long userId, String name) throws IOException {
        // Verify if the user exists
        if (userRepository.existsById(userId)) {
            // Create new document, transform MultipartFile to byte array and save to database
            DocumentEntity document = new DocumentEntity();
            document.setName(name);
            document.setPdfData(file.getBytes());
            document.setUserId(userId);

            // Save the document in the database
            documentRepository.save(document);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<DocumentEntity> getDocumentsByUserId(Long userId) {
        return documentRepository.findByUserId(userId);
    }
}
