package odushyn.kyivche.publisher.utils;

import odushyn.kyivche.publisher.covertor.CommentConvertor;
import odushyn.kyivche.publisher.covertor.WallMessageConvertor;
import odushyn.kyivche.publisher.domain.VkRequest;
import odushyn.kyivche.publisher.domain.message.Comment;
import odushyn.kyivche.publisher.domain.message.WallMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    public static final String VK_GET_COMMENTS = "/method/wall.getComments";

    public VK(VkConnectionParams connection) {
        this.connParams = connection;
    }

    @Override
    public List<WallMessage> getWallMessages(Map<String, String> paramsMap) {
        List<WallMessage> wallMessages;

        URI uri = vkURIBuilder(new VkRequest(VK_WALL_GET, paramsMap));
        HttpResponse response = makeRequest(uri);
        JSONArray json = convertResponseToJSON(response);

        wallMessages = new WallMessageConvertor().convert(json);

        return wallMessages;
    }

    @Override
    public List<Comment> getComments(Map<String, String> paramsMap) {
        List<Comment> comments = new ArrayList<Comment>();

        URI uri = vkURIBuilder(new VkRequest(VK_GET_COMMENTS, paramsMap));
        HttpResponse response = makeRequest(uri);
        JSONArray json = convertResponseToJSON(response);

        comments = new CommentConvertor().convert(json);

        return comments;
    }

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

    private JSONArray convertResponseToJSON(HttpResponse response){
        StringWriter content = new StringWriter();

        try {
            IOUtils.copy(response.getEntity().getContent(), content);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JSONParser parser   = new JSONParser();
        JSONArray postsList = null;

        try {

            JSONObject jsonResp  = (JSONObject) parser.parse(content.toString());
            postsList = (JSONArray) jsonResp.get("response");

        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return postsList;
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
