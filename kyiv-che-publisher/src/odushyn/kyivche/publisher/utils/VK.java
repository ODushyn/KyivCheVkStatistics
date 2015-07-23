package odushyn.kyivche.publisher.utils;

import odushyn.kyivche.publisher.domain.VkRequest;
import odushyn.kyivche.publisher.domain.message.WallMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksander.Dushyn on 7/20/2015.
 */
public class VK implements VkInterface {

    private VkConnectionParams connParams;

    //methods
    public static final String VK_WALL_GET = "/method/wall.get";

    public VK(VkConnectionParams connection) {
        this.connParams = connection;
    }

    @Override
    public List<WallMessage> getWallMessages(Map<String, String> paramsMap) {
        List<WallMessage> wallMessages = new ArrayList<WallMessage>();

        URI uri = vkURIBuilder(new VkRequest(VK_WALL_GET, paramsMap));

        HttpResponse response = makeRequest(uri);

        StringWriter content = new StringWriter();

        try {
            IOUtils.copy(response.getEntity().getContent(), content);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println(content.toString());

        return wallMessages;
    }

    /*private URI getWallMessages(String userName, String count){

        URI uri = null;
        try {
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme(connParams.getScheme()).setHost(connParams.getHost())
                    .setPath(VK_WALL_GET)
                    .setParameter("domain", userName)
                    .setParameter("copy_history_depth", count);
            if(connParams.getAccessToken() != null) {
                uriBuilder.setParameter("access_token", "1bf4c6df671efd8e62a6671f6542ed13a35592d2a37a4ab5433d9c7d9201c49db2bfba134494624504967");
            }
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return uri;
    }*/

    private HttpResponse makeRequest(URI uri){

        HttpClient client     = HttpClientBuilder.create().build();
        HttpGet      request    = new HttpGet(uri);
        HttpResponse response   = null;

        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return response;
    }

    private URI vkURIBuilder(VkRequest request){
        URI uri = null;
        try {
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme(connParams.getScheme()).setHost(connParams.getHost())
                    .setPath(request.getMethodName());

            for(Map.Entry<String, String> param : request.getParams().entrySet()){
                uriBuilder.setParameter(param.getKey(), param.getValue());
            }

            if(connParams.getAccessToken() != null){
                uriBuilder.setParameter("access_token", connParams.getAccessToken());
            }

            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return uri;
    }


    public void updateConnectionParams(String token){
        this.connParams.setAccessToken(token);
    }

}
