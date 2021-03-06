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
package com.netflix.genie.web.services.impl;

import com.google.common.collect.Sets;
import com.netflix.genie.common.dto.Job;
import com.netflix.genie.web.data.services.JobSearchService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

/**
 * Unit tests for the default implementation of the JobMetricsService.
 *
 * @author tgianos
 * @since 3.0.0
 */
class JobMetricsServiceImplTest {

    private final String hostName = UUID.randomUUID().toString();
    private JobSearchService jobSearchService;
    private JobMetricsServiceImpl jobMetricsService;

    /**
     * Setup for tests.
     */
    @BeforeEach
    void setup() {
        this.jobSearchService = Mockito.mock(JobSearchService.class);
        this.jobMetricsService = new JobMetricsServiceImpl(this.jobSearchService, this.hostName);
    }

    /**
     * Test to make sure the method returns the number of running jobs.
     */
    @Test
    void canGetNumJobs() {
        Mockito
            .when(this.jobSearchService.getAllActiveJobsOnHost(this.hostName))
            .thenReturn(
                Sets.newHashSet(
                    Mockito.mock(Job.class),
                    Mockito.mock(Job.class),
                    Mockito.mock(Job.class)
                )
            );

        Assertions.assertThat(this.jobMetricsService.getNumActiveJobs()).isEqualTo(3);
    }
}
