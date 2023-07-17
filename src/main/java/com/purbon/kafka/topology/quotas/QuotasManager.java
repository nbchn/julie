package com.purbon.kafka.topology.quotas;

import com.purbon.kafka.topology.Configuration;
import com.purbon.kafka.topology.ExecutionPlan;
import com.purbon.kafka.topology.ExecutionPlanUpdater;
import com.purbon.kafka.topology.api.adminclient.TopologyBuilderAdminClient;
import com.purbon.kafka.topology.model.Project;
import com.purbon.kafka.topology.model.Topology;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuotasManager implements ExecutionPlanUpdater {

  private static final Logger LOGGER = LogManager.getLogger(QuotasManager.class);

  private final TopologyBuilderAdminClient adminClient;
  private final Configuration config;

  public QuotasManager(TopologyBuilderAdminClient adminClient, Configuration config) {
    this.adminClient = adminClient;
    this.config = config;
  }

  @Override
  public void updatePlan(ExecutionPlan plan, Map<String, Topology> topologies) throws IOException {
    for (Topology topology : topologies.values()) {
      for (Project project : topology.getProjects()) {
        adminClient.assignQuotasPrincipal(project.getQuotas());
      }
    }
  }

  @Override
  public void printCurrentState(PrintStream out) throws IOException {}
}
