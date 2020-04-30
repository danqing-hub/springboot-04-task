package com.danqing.task;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void test01(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件设置
        simpleMailMessage.setSubject("通知-今晚开会");
        simpleMailMessage.setText("今晚7:30开会");
        simpleMailMessage.setTo("2591871445@qq.com");
        simpleMailMessage.setFrom("2832466495@qq.com");
        mailSender.send(simpleMailMessage);
    }

    @Test
    public void test02() throws Exception{
        //复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        //邮件设置
        mimeMessageHelper.setSubject("通知-今晚开会");
        mimeMessageHelper.setText("<b style='color:red'>今晚7:30开会</b>",true);
        mimeMessageHelper.setTo("2591871445@qq.com");
        mimeMessageHelper.setFrom("2832466495@qq.com");
        //上传文件
        mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\丹青\\Pictures\\Saved Pictures\\1F52G20Z0-5.jpg"));
        mimeMessageHelper.addAttachment("2.jpg",new File("C:\\Users\\丹青\\Pictures\\Saved Pictures\\1F52G20Z0-5.jpg"));
        mailSender.send(mimeMessage);
    }


    @Test
    void contextLoads() {
    }

}
