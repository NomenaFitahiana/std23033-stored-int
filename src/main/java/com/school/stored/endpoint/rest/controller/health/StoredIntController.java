package com.school.stored.endpoint.rest.controller.health;

import com.school.stored.model.StoredIntModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StoredIntController {
  private final StoredIntModel storedIntModel;

  @GetMapping("/stored-int")
  public int getStoredInt() {
    return storedIntModel.getOrCreateStoredInt();
  }
}
