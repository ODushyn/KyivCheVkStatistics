package odushyn.kyivche.publisher.domain;

import java.util.Map;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public class VkRequest {

    private String methodName;
    private Map<String, String> params;

    public VkRequest(String methodName, Map<String, String> params) {
        this.methodName = methodName;
        this.params = params;
    }

    public String getMethodName() {
        return methodName;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
