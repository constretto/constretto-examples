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
package org.constretto.examples.dashboard;

/**
 * @author <a href="mailto:kaare.nilsen@gmail.com">Kaare Nilsen</a>
 */
public class DevelopmentDashboard extends Dashboard {

    @Override
    public String constrettoTags() {
        return "development,constretto,exampletag";
    }

    @Override
    public String constrettoEnv() {
        return "development,constretto,exampleenv";
    }

    public static void main(String[] args) {
        new DevelopmentDashboard();
    }
}
