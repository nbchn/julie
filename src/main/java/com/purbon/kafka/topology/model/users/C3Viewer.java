package com.purbon.kafka.topology.model.users;

import com.purbon.kafka.topology.model.User;
import java.util.Objects;

public class C3Viewer extends User {

  public C3Viewer() {
    super();
  }

  public C3Viewer(String principal) {
    super(principal);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof C3Viewer)) {
      return false;
    }
    C3Viewer consumer = (C3Viewer) o;
    return getPrincipal().equals(consumer.getPrincipal());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrincipal());
  }
}
