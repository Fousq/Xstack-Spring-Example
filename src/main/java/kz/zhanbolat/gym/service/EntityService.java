package kz.zhanbolat.gym.service;

import kz.zhanbolat.gym.annotation.InjectRandomEntity;
import kz.zhanbolat.gym.entity.Entity;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    @InjectRandomEntity
    private Entity entity;

    public Entity getEntity() {
        return entity;
    }
}
