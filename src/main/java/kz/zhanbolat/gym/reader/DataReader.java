package kz.zhanbolat.gym.reader;

import kz.zhanbolat.gym.entity.Entity;

import java.util.List;

public interface DataReader {
    List<Entity> read(String fileName);
}
