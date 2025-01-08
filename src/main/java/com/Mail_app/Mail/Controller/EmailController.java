package com.Mail_app.Mail.Controller;

import com.Mail_app.Mail.Entities.Email;
import com.Mail_app.Mail.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/Send")
    public String SendMail(@RequestBody Email email){
        emailService.sendSimpleEmail(email.getReceiverId(), email.getSubject(), email.getContent());
        return "Mail sent Successfully!";
    }

    // Handle sending email with attachment
    @PostMapping("/Send/attachments")
    public String SendWithAttach(
            @RequestParam("receiverId") String receiverId,
            @RequestParam("subject") String subject,
            @RequestParam("content") String content,
            @RequestParam("file") MultipartFile file) {

        emailService.sendEmailWithAttachment(receiverId, subject, content, file);
        return "Mail with attachments sent Successfully!";
    }
}
