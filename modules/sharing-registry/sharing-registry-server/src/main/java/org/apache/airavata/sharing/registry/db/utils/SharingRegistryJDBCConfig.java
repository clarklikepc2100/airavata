/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.airavata.sharing.registry.db.utils;

import org.apache.airavata.common.exception.ApplicationSettingsException;
import org.apache.airavata.common.utils.JDBCConfig;
import org.apache.airavata.common.utils.ServerSettings;

public class SharingRegistryJDBCConfig implements JDBCConfig {

    public static final String SHARING_REG_JDBC_DRIVER = "sharingcatalog.jdbc.driver";
    public static final String SHARING_REG_JDBC_URL = "sharingcatalog.jdbc.url";
    public static final String SHARING_REG_JDBC_USER = "sharingcatalog.jdbc.user";
    public static final String SHARING_REG_JDBC_PWD = "sharingcatalog.jdbc.password";

    @Override
    public String getURL() {
        return readServerProperties(SHARING_REG_JDBC_URL);
    }

    @Override
    public String getDriver() {
        return readServerProperties(SHARING_REG_JDBC_DRIVER);
    }

    @Override
    public String getUser() {
        return readServerProperties(SHARING_REG_JDBC_USER);
    }

    @Override
    public String getPassword() {
        return readServerProperties(SHARING_REG_JDBC_PWD);
    }

    private String readServerProperties(String propertyName) {
        try {
            return ServerSettings.getSetting(propertyName);
        } catch (ApplicationSettingsException e) {
            throw new RuntimeException("Unable to read airavata-server.properties...", e);
        }
    }
}