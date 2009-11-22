/*
 * Copyright 2009 the original author or authors.
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
package org.constretto.examples.log4j;

import org.apache.log4j.Logger;
import org.constretto.ConstrettoBuilder;
import org.constretto.ConstrettoConfiguration;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;

/**
 * Simple test case that shows how constretto could be used
 * to configure different log4j configurations depending on context.
 *
 * @author <a href="mailto:kaare.nilsen@gmail.com">Kaare Nilsen</a>
 */

public class LogLevelTest {
    Logger log = Logger.getLogger(LogLevelTest.class);

    @Test
    public void whenInDevelopmentLogAlot() {
        ConstrettoConfiguration configuration = new ConstrettoBuilder()
                .addCurrentTag("development")
                .createPropertiesStore()
                .addResource(new DefaultResourceLoader().getResource("logger.properties"))
                .done()
                .getConfiguration();
        configuration.as(Log4JConfigurer.class);
        log.debug("This should be visible on system.out");
    }


    @Test
    public void whenInProductionLogLess() {
        ConstrettoConfiguration configuration = new ConstrettoBuilder()
                .addCurrentTag("production")
                .createPropertiesStore()
                .addResource(new DefaultResourceLoader().getResource("logger.properties"))
                .done()
                .getConfiguration();
        configuration.as(Log4JConfigurer.class);
        log.debug("This should NOT be visible on system.out");
    }

}
