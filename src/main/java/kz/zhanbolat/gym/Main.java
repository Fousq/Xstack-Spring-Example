package kz.zhanbolat.gym;

import kz.zhanbolat.gym.entity.Entity;
import kz.zhanbolat.gym.reader.DataReader;
import kz.zhanbolat.gym.service.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kz.zhanbolat");
        EntityService entityService = applicationContext.getBean(EntityService.class);
        DataReader dataReader = applicationContext.getBean(DataReader.class);

        log.info(entityService.getEntity().toPrint()); // now we resolve it with BEAN POST PROCESSOR. BUT WHAT IS IT?

        List<Entity> entities = dataReader.read("data.txt");
        entities.forEach(entity -> log.info(entity.toPrint()));
    }
}
