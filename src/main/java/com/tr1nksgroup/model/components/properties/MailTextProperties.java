package com.tr1nksgroup.model.components.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:properties/mailText.properties", encoding = "UTF-8")
public class MailTextProperties {
    @Value("#{'${email.pattern.sendUser}'}")
    private String sendUserPattern;
    @Value("#{'${email.pattern.nowDate}'}")
    private String nowDatePattern;
    @Value("#{'${email.recipient}'}")
    private String recipient;
    @Value("#{'${email.title}'}")
    private String title;
    @Value("#{'${email.text}'}")
    private String text;

    //region get
    public String getSendUserPattern() {
        return sendUserPattern;
    }

    public void setSendUserPattern(String sendUserPattern) {
        this.sendUserPattern = sendUserPattern;
    }

    public String getNowDatePattern() {
        return nowDatePattern;
    }

    public void setNowDatePattern(String nowDatePattern) {
        this.nowDatePattern = nowDatePattern;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }
    //endregion

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
