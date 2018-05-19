package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.MailCreatorService;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email!";
    private static final String ONETASK = "Currently in database you got 1 task";

    @Autowired
    private SimpleEmailService mailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private MailCreatorService mailCreatorService;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationMail() {
        long size = taskRepository.count();
        if (size == 1) {
            mailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, ONETASK, null));
        } else mailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, "Currently in database you got " + size + "tasks", null));
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationMailOnceADay() {
        long size = taskRepository.count();
        mailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, mailCreatorService.buildTaskQuantityMail(size), null));
    }
}
