package action

import com.cloudbees.jenkins.plugins.bitbucket.endpoints.BitbucketCloudEndpoint
import com.cloudbees.jenkins.plugins.bitbucket.endpoints.BitbucketEndpointConfiguration
import groovy.transform.InheritConstructors
import jenkins.model.Jenkins

@InheritConstructors
class BitbucketConfigAction extends ConfigAction {

    @Override
    void execute() {
        def instance = Jenkins.get()

        BitbucketCloudEndpoint endpoint = new BitbucketCloudEndpoint(true, config.credentialId)
        BitbucketEndpointConfiguration endpointConfig = instance.getDescriptorByType(BitbucketEndpointConfiguration)
        endpointConfig.updateEndpoint(endpoint)
        endpointConfig.save()
    }
}
