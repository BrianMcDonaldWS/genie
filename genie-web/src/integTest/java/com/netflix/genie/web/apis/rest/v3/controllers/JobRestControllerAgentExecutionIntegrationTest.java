/*
 *
 *  Copyright 2016 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.genie.web.apis.rest.v3.controllers;

import com.netflix.genie.web.properties.LocalAgentLauncherProperties;
import com.netflix.genie.web.util.JobExecutionModeSelector;
import org.springframework.test.context.TestPropertySource;

/**
 * Integration tests for Jobs REST API, executing in agent mode.
 *
 * @author mprimi
 * @since 4.0.0
 */
@TestPropertySource(
    properties = {
        JobExecutionModeSelector.DEFAULT_EXECUTE_WITH_AGENT_PROPERTY + "=true",
        LocalAgentLauncherProperties.PROPERTY_PREFIX + ".run-as-user=false",
        "genie.services.job-resolver.v4-probability=1.0",
    }
)
public class JobRestControllerAgentExecutionIntegrationTest extends JobRestControllerIntegrationTest {

    /**
     * Constructor.
     */
    public JobRestControllerAgentExecutionIntegrationTest() {
        super(true);
    }
}
