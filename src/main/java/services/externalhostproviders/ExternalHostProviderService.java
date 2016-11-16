/*
Copyright (c) 2015 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package services.externalhostproviders;

import annotations.Area;
import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import services.ExternalProviderService;
import types.ExternalHostProvider;

@Service
@Area("Infrastructure")
public interface ExternalHostProviderService extends ExternalProviderService {
    interface Get {
        @Out ExternalHostProvider provider();
    }

    interface Update {
        @In @Out ExternalHostProvider provider();

        /**
         * Indicates if the update should be performed asynchronously.
         */
        @In Boolean async();
    }

    interface Remove {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        @In Boolean async();
    }

    @Service ExternalComputeResourcesService computeResources();
    @Service ExternalDiscoveredHostsService discoveredHosts();
    @Service ExternalHostGroupsService hostGroups();
    @Service ExternalHostsService hosts();
}