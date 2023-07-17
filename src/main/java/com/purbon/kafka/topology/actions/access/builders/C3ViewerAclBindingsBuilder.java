package com.purbon.kafka.topology.actions.access.builders;

import com.purbon.kafka.topology.BindingsBuilderProvider;
import com.purbon.kafka.topology.model.users.C3Viewer;
import java.util.List;

public class C3ViewerAclBindingsBuilder implements AclBindingsBuilder {

  private final String fullTopicName;
  private final List<C3Viewer> viewers;
  private final BindingsBuilderProvider builderProvider;
  private boolean prefixed;

  public C3ViewerAclBindingsBuilder(
      BindingsBuilderProvider builderProvider,
      List<C3Viewer> viewers,
      String fullTopicName,
      boolean prefixed) {
    this.viewers = viewers;
    this.fullTopicName = fullTopicName;
    this.builderProvider = builderProvider;
    this.prefixed = prefixed;
  }

  @Override
  public AclBindingsResult getAclBindings() {
    return AclBindingsResult.forAclBindings(
        builderProvider.buildBindingsC3Viewers(viewers, fullTopicName, prefixed));
  }
}
