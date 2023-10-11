package kz.zhanbolat.gym.annotation.bpp;

import kz.zhanbolat.gym.annotation.InjectRandomEntity;
import kz.zhanbolat.gym.entity.Entity;
import kz.zhanbolat.gym.entity.Trainer;
import kz.zhanbolat.gym.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class InjectRandomEntityBeanPostProcessor implements BeanPostProcessor {

    private static final List<Entity> ENTITIES = List.of(
            new User(1, "test", "user"),
            new Trainer(2, "trainer1"),
            new User(3, "ites", "tesgds"),
            new Trainer(4, "tesgsdg")
    );

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Arrays.stream(beanClass.getDeclaredFields()) // going through all the fields of the class
                .filter(field -> field.isAnnotationPresent(InjectRandomEntity.class)) // check if each of fields annotated with @InjectRandomEntity
                .forEach(field -> {
                    field.setAccessible(true); // make the field accessible to set a value
                    ReflectionUtils.setField(field, bean, getRandomEntity()); // set the value in the object
                });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private Entity getRandomEntity() {
        Random random = new Random();
        return ENTITIES.get(random.nextInt(ENTITIES.size()));
    }
}
