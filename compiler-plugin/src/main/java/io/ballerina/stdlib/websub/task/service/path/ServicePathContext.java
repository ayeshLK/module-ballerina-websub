/*
 * Copyright (c) 2021, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.ballerina.stdlib.websub.task.service.path;

import io.ballerina.projects.DocumentId;
import io.ballerina.projects.ModuleId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@code ServicePathContext} contains details related to compile-time service path generation.
 */
public class ServicePathContext {
    private final ModuleId moduleId;
    private final DocumentId documentId;
    private final List<ServicePathInformation> servicePathDetails;

    public ServicePathContext(ModuleId moduleId, DocumentId documentId) {
        this.moduleId = moduleId;
        this.documentId = documentId;
        this.servicePathDetails = new ArrayList<>();
    }

    public ModuleId getModuleId() {
        return moduleId;
    }

    public DocumentId getDocumentId() {
        return documentId;
    }

    public List<ServicePathInformation> getServicePathDetails() {
        return Collections.unmodifiableList(servicePathDetails);
    }

    void updateServicePathDetails(ServicePathInformation servicePathDetails) {
        this.servicePathDetails.add(servicePathDetails);
    }

    /**
     * {@code ServicePathInformation} contains details related to generated service-path.
     */
    public static class ServicePathInformation {
        private final int serviceId;
        private final String servicePath;

        public ServicePathInformation(int serviceId, String servicePath) {
            this.serviceId = serviceId;
            this.servicePath = servicePath;
        }

        public int getServiceId() {
            return serviceId;
        }

        public String getServicePath() {
            return servicePath;
        }
    }
}
