/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.reconfiguration.spring;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.service.common.PostgresqlServiceInfo;

public final class PostgresHibernateCloudServiceBeanFactoryPostProcessorTest extends
        AbstractHibernateBasedCloudServiceBeanFactoryPostProcessorTest {

    private static final PostgresqlServiceInfo SERVICE_INFO = new PostgresqlServiceInfo("service-postgres",
            "postgres://service-user:service-password@127.0.0.1:4321/service-database");

    public PostgresHibernateCloudServiceBeanFactoryPostProcessorTest() {
        super(SessionFactory.class, "postgres-datasource", SERVICE_INFO);
    }

    @Override
    protected BeanFactoryPostProcessor getInstance(Cloud cloud) {
        return new DataSourceCloudServiceBeanFactoryPostProcessor(cloud);
    }

    @Override
    protected void assertLocalConfiguration(SessionFactory factory) {
        assertConfiguration(factory, "org.hibernate.dialect.H2Dialect");
    }

    @Override
    protected void assertServiceConfiguration(SessionFactory factory) {
        assertConfiguration(factory, "org.hibernate.dialect.PostgreSQLDialect");
    }

}
