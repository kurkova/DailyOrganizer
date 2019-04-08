package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyDetails;
import com.crud.tasks.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

import static com.crud.tasks.domain.Mail.Type.DAILY_INFORMATION_EMAIL;
import static com.crud.tasks.domain.Mail.Type.TRELLO_CARD_EMAIL;

@Service
public class MailCreatorService {
    @Autowired
    private CompanyDetails companyDetails;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String build(String message, Mail.Type mailType) {
        if (mailType == TRELLO_CARD_EMAIL) {
            return buildTrelloCardEmail(message);
        } else if (mailType == DAILY_INFORMATION_EMAIL) {
            return buildDailyInformationEmail(message);
        }
        return "";
    }

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://kurkova.github.io");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview", "New card added");
        context.setVariable("company_name", companyDetails.getAppName());
        context.setVariable("company_details", companyDetails.getAppName() + "\n" +
                companyDetails.getOwnerName() + " " + companyDetails.getOwnerSurname());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildDailyInformationEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can check your tasks for today");
        functionality.add("You can manage your tasks");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://kurkova.github.io");
        context.setVariable("button", "See tasks");
        context.setVariable("application_functionality", functionality);
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview", "Trello app");
        context.setVariable("company_name", companyDetails.getAppName());
        context.setVariable("company_details", companyDetails.getAppName() + "\n" +
                companyDetails.getOwnerName() + " " + companyDetails.getOwnerSurname());
        context.setVariable("show_button", true);
        context.setVariable("admin_config", adminConfig);
        return templateEngine.process("mail/daily-information-mail", context);
    }
}
