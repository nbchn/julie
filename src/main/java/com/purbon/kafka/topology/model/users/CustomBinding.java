package com.purbon.kafka.topology.model.users;

import com.purbon.kafka.topology.model.User;
import java.util.Objects;
import java.util.Optional;

public class CustomBinding extends User {

    private Optional<String> role;
    private Optional<String> principal;
    private Optional<String> resourceType;
    private Optional<String> resourceName;
    private Optional<Boolean> prefixed;

    public CustomBinding() {
        super();
        role = Optional.empty();
        principal = Optional.empty();
        resourceType = Optional.empty();
        resourceName = Optional.empty();
        prefixed = Optional.empty();
    }

    public Optional<String> getRole() {
        return role;
    }
    public Optional<String> getResourceName() {
        return resourceName;
    }
    public Optional<String> getResourceType() {
        return resourceType;
    }
    public Optional<Boolean> getPrefixed() {
        return prefixed;
    }
    public String getRoleString() {
        return role.orElse("");
    }
    public String getResourceNameString() {
        return resourceName.orElse("");
    }
    public String getResourceTypeString() {
        return resourceType.orElse("");
    }
    public Boolean gePrefixedBool() {
        return prefixed.orElse(true);
    }

    public void setRole(Optional<String> role) {
        this.role = role;
    }
    public void setResourceName(Optional<String> resourceName) {
        this.resourceName = resourceName;
    }
    public void setResourceType(Optional<String> resourceType) {
        this.resourceType = resourceType;
    }
    public void setPrefixed(Optional<Boolean> prefixed) {
        this.prefixed = prefixed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomBinding)) {
            return false;
        }
        CustomBinding other = (CustomBinding) o;
        return getPrincipal().equals(other.getPrincipal())
                && getRoleString().equals(other.getRoleString())
                && getResourceNameString().equals(other.getResourceNameString())
                && getResourceTypeString().equals(other.getResourceTypeString())
                && gePrefixedBool().equals(other.gePrefixedBool());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrincipal(), getRoleString(), getResourceNameString(), getResourceTypeString(), gePrefixedBool());
    }
}
