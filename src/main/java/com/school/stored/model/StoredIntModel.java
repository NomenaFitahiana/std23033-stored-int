package com.school.stored.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class StoredIntModel {
  private static final String FILE_NAME = "stored-int.txt";
  private static final Random RANDOM = new Random();

  public int getOrCreateStoredInt() {
    Path path = Paths.get(System.getProperty("java.io.tmpdir"), FILE_NAME);
    try {
      if (Files.exists(path)) {
        String content = Files.readString(path);
        return Integer.parseInt(content.trim());
      } else {
        Files.createDirectories(path.getParent());
        int randomInt = RANDOM.nextInt(1000);
        Files.writeString(path, String.valueOf(randomInt));
        return randomInt;
      }
    } catch (IOException e) {
      throw new RuntimeException("Erreur lors de l'accès au fichier", e);
    }
  }
}
