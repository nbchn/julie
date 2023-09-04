package com.purbon.kafka.topology.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.purbon.kafka.topology.model.Impl.ProjectImpl;
import com.purbon.kafka.topology.model.artefact.KConnectArtefacts;
import com.purbon.kafka.topology.model.artefact.KsqlArtefacts;
import com.purbon.kafka.topology.model.users.*;
import java.util.List;
import java.util.Map;

@JsonDeserialize(as = ProjectImpl.class)
public interface Project {

  String getName();

  List<String> getZookeepers();

  List<Consumer> getConsumers();

  void setConsumers(List<Consumer> consumers);

  List<Producer> getProducers();

  void setProducers(List<Producer> producers);

  List<KStream> getStreams();

  void setStreams(List<KStream> streams);

  @JsonProperty("ksql")
  List<KSqlApp> getKSqls();

  void setKSqls(List<KSqlApp> c3Viewers);

  List<C3Viewer> getC3Viewers();

  void setC3Viewers(List<C3Viewer> ksqls);

  List<Quota> getQuotas();

  void setQuotas(List<Quota> quotas);

  List<CustomBinding> getCustomBindings();

  void setCustomBindings(List<CustomBinding> customBindings);

  Map<String, List<Other>> getOthers();

  void setOthers(Map<String, List<Other>> others);

  List<Connector> getConnectors();

  KConnectArtefacts getConnectorArtefacts();

  KsqlArtefacts getKsqlArtefacts();

  void setConnectors(List<Connector> connectors);

  List<Schemas> getSchemas();

  void setSchemas(List<Schemas> schemas);

  List<Topic> getTopics();

  void addTopic(Topic topic);

  void setTopics(List<Topic> topics);

  String namePrefix();

  void setRbacRawRoles(Map<String, List<String>> rbacRawRoles);

  Map<String, List<String>> getRbacRawRoles();

  void setPrefixContextAndOrder(Map<String, Object> asFullContext, List<String> order);
}
