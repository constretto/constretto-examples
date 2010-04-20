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

import org.constretto.ConstrettoConfiguration;
import org.constretto.Property;
import org.constretto.annotation.Tags;
import org.constretto.spring.annotation.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author <a href="mailto:kaare.nilsen@gmail.com">Kaare Nilsen</a>
 */
@Controller
public class DashboardController {
    @Tags
    private List<String> tags;
    @Environment
    private List<String> environments;

    private final ConstrettoConfiguration configuration;


    @Autowired
    public DashboardController(ConstrettoConfiguration configuration) {
        this.configuration = configuration;
    }

    @RequestMapping("/dashboard.html")
    public
    @ModelAttribute("dashboard")
    DashboardModel createDashBoard() {
        DashboardModel model = new DashboardModel(environments, tags);
        for (Property property : configuration) {
            model.addProperty(property);
        }
        return model;
    }
}
