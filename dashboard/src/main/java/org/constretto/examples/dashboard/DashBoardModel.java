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

import org.constretto.Property;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:kaare.nilsen@arktekk.no">Kaare Nilsen</a>
 */
public class DashboardModel {
    private final List<String> environments;
    private final List<String> tags;
    private final Set<Property> properties = new HashSet<Property>();

    public DashboardModel(List<String> environments, List<String> tags) {
        this.environments = environments;
        this.tags = tags;
    }

    public List<String> getEnvironments() {
        return environments;
    }

    public List<String> getTags() {
        return tags;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }
}
