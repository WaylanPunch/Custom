package com.maildemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaildemoApplicationTests {

    @Autowired
    private JavaMailSenderImpl javaMailSender;


    @Test
    public void mail1() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("sdfsf");
        simpleMailMessage.setText("sdfsfs");
        simpleMailMessage.setTo("asdas@qq.com");
        simpleMailMessage.setFrom("");

        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void mail2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("sdfsf");
        mimeMessageHelper.setText("<b>sdfsfs</b>", true);
        mimeMessageHelper.setTo("asdas@qq.com");
        mimeMessageHelper.setFrom("asdasd@qq.com");
        mimeMessageHelper.addAttachment("1.jpg", new File("C:\\Users\\pc\\Pictures\\00.PNG"));

        javaMailSender.send(mimeMessage);
    }

}
