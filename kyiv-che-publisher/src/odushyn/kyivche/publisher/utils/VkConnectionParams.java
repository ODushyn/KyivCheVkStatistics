package odushyn.kyivche.publisher.utils;

/**
 * Created by Oleksander.Dushyn on 7/23/2015.
 */
public class VkConnectionParams {

    private String accessToken;

    private String appId;

    private String appKey;

    private String authPath = Constants.AUTH_PATH;

    private String host = Constants.HOST;

    private String scope = Constants.SCOPE;

    private String redirect_uri = Constants.REDIRECT_URI;

    private String display= Constants.DISPLAY;

    private String apiVersion = Constants.VERSION;

    private String scheme = Constants.SCHEME;

    public  VkConnectionParams (String appId, String appKey, String accessToken){
        this.appId = appId;
        this.appKey = appKey;
        this.accessToken = accessToken;
    }

    public void generateAccessToken(){
        //TODO: implement...
        /*URI uri = null;

        try {
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme(scheme).setHost(authPath)
                    .setParameter("client_id", "5002202")
                    .setParameter("scope", scope)
                    .setParameter("redirect_uri", redirect_uri)
                    .setParameter("display", display)
                    .setParameter("v", apiVersion)
                    .setParameter("response_type", "token");
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.exit(-1);
        }*/
    }

    public String getAuthPath() {
        return authPath;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppdId(String appdId) {
        this.appId = appdId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHost() {
        return host;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
