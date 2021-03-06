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

import org.springframework.cloud.Cloud;

final class RabbitCloudServiceBeanFactoryPostProcessor extends AbstractCloudServiceBeanFactoryPostProcessor {

    private static final String BEAN_CLASS = "org.springframework.amqp.rabbit.connection.ConnectionFactory";

    private static final String SERVICE_BEAN_NAME = "__cloudRabbitConnectionFactory";

    RabbitCloudServiceBeanFactoryPostProcessor(Cloud cloud) {
        super(cloud);
    }

    @Override
    protected String getBeanClass() {
        return BEAN_CLASS;
    }

    @Override
    protected String getServiceBeanName() {
        return SERVICE_BEAN_NAME;
    }

}
