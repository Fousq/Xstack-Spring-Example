package kz.zhanbolat.gym.reader;

import kz.zhanbolat.gym.entity.Entity;
import kz.zhanbolat.gym.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityDataReader implements DataReader {

    private static final Logger log = LoggerFactory.getLogger(EntityDataReader.class);

    @Override
    public List<Entity> read(String fileName) {
        log.debug("Going to read from file {}", fileName);
        URL resource = this.getClass().getClassLoader().getResource(fileName);
        Path path;
        try {
            path = Path.of(resource.toURI());
        } catch (URISyntaxException e) {
            log.error("Cannot transform file {} to read", fileName);
            throw new RuntimeException(e);
        }
        try {
            return Files.readAllLines(path).stream()
                    .map(this::mapToUser)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Cannot read file {}", fileName);
            throw new RuntimeException(e);
        }
    }

    private User mapToUser(String line) {
        String[] columns = line.split(",");
        return new User(Integer.parseInt(columns[1]), columns[2], columns[3]);
    }
}
