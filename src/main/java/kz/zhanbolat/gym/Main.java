package kz.zhanbolat.gym;

import kz.zhanbolat.gym.service.EntityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kz.zhanbolat");
        EntityService entityService = applicationContext.getBean(EntityService.class);

        System.out.println(entityService.getEntity()); // getting null for entity, but shouldn't. HOW TO FIX ?
    }
}
