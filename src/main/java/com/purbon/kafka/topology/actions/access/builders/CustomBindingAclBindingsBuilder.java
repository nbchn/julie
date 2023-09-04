package com.purbon.kafka.topology.actions.access.builders;

import com.purbon.kafka.topology.BindingsBuilderProvider;
import com.purbon.kafka.topology.model.users.C3Viewer;
import com.purbon.kafka.topology.model.users.CustomBinding;

import java.util.List;


public class CustomBindingAclBindingsBuilder implements AclBindingsBuilder {

    private final String fullTopicName;
    private final List<CustomBinding> customBindings;
    private final BindingsBuilderProvider builderProvider;
    private boolean prefixed;

    public CustomBindingAclBindingsBuilder(
            BindingsBuilderProvider builderProvider,
            List<CustomBinding> customBindings,
            String fullTopicName,
            boolean prefixed) {
        this.customBindings = customBindings;
        this.fullTopicName = fullTopicName;
        this.builderProvider = builderProvider;
        this.prefixed = prefixed;
    }

    @Override
    public AclBindingsResult getAclBindings() {
        return AclBindingsResult.forAclBindings(
                builderProvider.buildBindingsCustomBindings(customBindings, fullTopicName, prefixed));
    }
}
