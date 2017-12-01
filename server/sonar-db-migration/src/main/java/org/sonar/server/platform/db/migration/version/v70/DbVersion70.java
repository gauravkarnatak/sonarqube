/*
 * SonarQube
 * Copyright (C) 2009-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server.platform.db.migration.version.v70;

import org.sonar.server.platform.db.migration.step.MigrationStepRegistry;
import org.sonar.server.platform.db.migration.version.DbVersion;

public class DbVersion70 implements DbVersion {

  @Override
  public void addSteps(MigrationStepRegistry registry) {
    registry
      .add(1900, "Add QUALITY_GATES.IS_BUILT_IN", AddIsBuiltInToQualityGates.class)
      .add(1901, "Populate QUALITY_GATES.IS_BUILT_IN", PopulateQualityGatesIsBuiltIn.class)
      .add(1902, "Make QUALITY_GATES.IS_BUILT_IN not null", MakeQualityGatesIsBuiltInNotNullable.class)
      .add(1903, "Remove quality gates loaded templates", RemoveQualityGateLoadedTemplates.class)
      .add(1904, "Rename quality gate \"SonarQube way\" to \"Sonar way\"", RenameOldSonarQubeWayQualityGate.class)
      .add(1905, "Drop LOADED_TEMPLATES table", DropLoadedTemplatesTable.class)
      .add(1906, "Create ORG_QUALITY_GATES table", CreateOrgQualityGatesTable.class)
      .add(1907, "Add ORGANIZATIONS.DEFAULT_QUALITY_GATE_UUID", AddDefaultQualityGateUuidToOrganizations.class)
      .add(1908, "Create QUALITY_GATES.UUID", AddUuidToQualityGates.class)
      .add(1909, "Populate QUALITY_GATES.UUID", PopulateUuidOnQualityGates.class)
      .add(1910, "Make QUALITY_GATES.UUID not nullable", MakeUuidNotNullableOnQualityGates.class)
    ;
  }

}
